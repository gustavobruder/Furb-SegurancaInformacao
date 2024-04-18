public class Caso10 {
    public static void executar() {
        byte[] chave1 = {65, 66, 67, 68, 69};
        byte[] chave2 = "11111".getBytes();
        String texto = "FURB";

        byte[] textoCifrado = CipherUtils.cifrarComModoECB(texto, chave1);

        String mensagemException = null;
        try {
            CipherUtils.decifrarComModoECB(textoCifrado, chave2);
        } catch (Exception e) {
            mensagemException = e.getMessage();
        }

        System.out.println();
        System.out.println("========== CASO 10 ==========");
        System.out.println("10.1. Explique o resultado. Ocorre uma exceção, pois não será capaz de recuperar o texto original com uma chave diferente da que foi utilizada para cifrar. Erro -> " + mensagemException);
    }
}
