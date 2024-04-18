import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

public class CipherUtils {

    public static byte[] cifrarComModoECB(String texto, byte[] chaveBytes) {
        return cifrarComModoECB(texto.getBytes(), chaveBytes);
    }

    public static byte[] cifrarComModoECB(byte[] texto, byte[] chaveBytes) {
        SecretKeySpec chave = new SecretKeySpec(chaveBytes, "Blowfish");

        try {
            Cipher cifra = obterCifraComModoOperacao("ECB");
            cifra.init(Cipher.ENCRYPT_MODE, chave);
            return cifra.doFinal(texto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] decifrarComModoECB(byte[] textoCifrado, byte[] chaveBytes) throws Exception {
        SecretKeySpec chave = new SecretKeySpec(chaveBytes, "Blowfish");

        Cipher cifra = obterCifraComModoOperacao("ECB");
        cifra.init(Cipher.DECRYPT_MODE, chave);
        return cifra.doFinal(textoCifrado);
    }

    public static byte[] cifrarComModoCBC(String texto, byte[] chaveBytes, byte[] vetorInicializacaoBytes) {
        SecretKeySpec chave = new SecretKeySpec(chaveBytes, "Blowfish");
        IvParameterSpec vetorInicializacao = new IvParameterSpec(vetorInicializacaoBytes);

        try {
            Cipher cifra = obterCifraComModoOperacao("CBC");
            cifra.init(Cipher.ENCRYPT_MODE, chave, vetorInicializacao);
            return cifra.doFinal(texto.getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] decifrarComModoCBC(byte[] textoCifrado, byte[] chaveBytes, byte[] vetorInicializacaoBytes) {
        SecretKeySpec chave = new SecretKeySpec(chaveBytes, "Blowfish");
        IvParameterSpec vetorInicializacao = new IvParameterSpec(vetorInicializacaoBytes);

        try {
            Cipher cifra = obterCifraComModoOperacao("CBC");
            cifra.init(Cipher.DECRYPT_MODE, chave, vetorInicializacao);
            return cifra.doFinal(textoCifrado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Cipher obterCifraComModoOperacao(String modoOperacao) throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getInstance("Blowfish/" + modoOperacao + "/PKCS5Padding");
    }

    public static String converterBytesParaHexadecimal(byte[] bytes) {
        StringBuilder sb = new StringBuilder();

        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }

        return sb.toString();
    }
}
