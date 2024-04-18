public class Caso07 {
    public static void executar() {
        byte[] chave = {65, 66, 67, 68, 69};
        String texto = "FURB";
        byte[] vetorInicializacao = {1, 1, 2, 2, 3, 3, 4, 4};

        byte[] textoCifrado = CipherUtils.cifrarComModoCBC(texto, chave, vetorInicializacao);
        String textoCifradoString = new String(textoCifrado);
        String textoCifradoHex = CipherUtils.converterBytesParaHexadecimal(textoCifrado);

        System.out.println();
        System.out.println("========== CASO 07 ==========");
        System.out.println("7.1. Qual o conteúdo do texto cifrado? " + textoCifradoString);
        System.out.println("7.2. Qual o conteúdo do texto cifrado (em hexadecimal)? " + textoCifradoHex);
    }
}
