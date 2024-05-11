using System.Security.Cryptography;
using System.Text;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

builder.Services.AddDbContext<DatabaseContext>(opt =>
{
    var connectionString = "Host=localhost;Port=5432;Database=UsersDb;User Id=postgres;Password=admin;";
    opt.UseNpgsql(connectionString);
});

builder.Services.AddDatabaseDeveloperPageExceptionFilter();

var app = builder.Build();

using (var scope = app.Services.CreateScope())
{
    var databaseContext = scope.ServiceProvider.GetRequiredService<DatabaseContext>();
    databaseContext.Database.EnsureCreated();
}

app.MapGet("/users", async (DatabaseContext db) =>
{
    var users = await db.Users.ToListAsync();

    return Results.Ok(users);
});

app.MapPost("/users", async (UserDto userDto, DatabaseContext db) =>
{
    var hash = Hash(userDto.Password);

    var user = db.Users.Add(new User
    {
        Login = userDto.Login,
        Password = hash,
    }).Entity;
    await db.SaveChangesAsync();

    return Results.Created($"/users/{user.Id}", user);
});

app.MapPost("/users/login", async (UserDto userDto, DatabaseContext db) =>
{
    var hash = Hash(userDto.Password);

    var user = await db.Users.FirstOrDefaultAsync(x => x.Login == userDto.Login && x.Password == hash);

    if (user is null)
        return Results.NotFound(new
        {
            Message = "User not found"
        });

    return Results.Accepted($"/users/{user.Id}", new
    {
        Message = $"User {user.Id} logged in"
    });
});

app.Run();

string Hash(string text)
{
    // https://stackoverflow.com/questions/12416249/hashing-a-string-with-sha256
    var textBytes = Encoding.UTF8.GetBytes(text);
    var hash = SHA256.HashData(textBytes);
    return Convert.ToHexString(hash);
}

public class UserDto
{
    public string Login { get; set; }
    public string Password { get; set; }
}

public class User
{
    public int Id { get; set; }
    public string Login { get; set; }
    public string Password { get; set; }
}

class DatabaseContext : DbContext
{
    public DatabaseContext(DbContextOptions<DatabaseContext> options) : base(options)
    {
    }

    public DbSet<User> Users => Set<User>();
}
