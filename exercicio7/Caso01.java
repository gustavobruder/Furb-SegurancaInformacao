public class Caso01 {
    public static void executar() {
        byte[] chave = {65, 66, 67, 68, 69};
        String texto = "FURB";

        byte[] textoCifrado = CipherUtils.cifrarComModoECB(texto, chave);
        String textoCifradoHex = CipherUtils.converterBytesParaHexadecimal(textoCifrado);

        System.out.println();
        System.out.println("========== CASO 01 ==========");
        System.out.println("1.1. Qual o conteúdo do texto cifrado (em hexadecimal)? " + textoCifradoHex);
        System.out.println("1.2. Qual a extensão (quantidade de caracteres) do texto cifrado? " + textoCifrado.length);
    }
}
