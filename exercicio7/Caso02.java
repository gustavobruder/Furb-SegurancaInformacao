public class Caso02 {
    public static void executar() {
        byte[] chave = {65, 66, 67, 68, 69};
        String texto = "COMPUTADOR";

        byte[] textoCifrado = CipherUtils.cifrarComModoECB(texto, chave);
        String textoCifradoHex = CipherUtils.converterBytesParaHexadecimal(textoCifrado);

        System.out.println();
        System.out.println("========== CASO 02 ==========");
        System.out.println("2.1. Qual o conteúdo do texto cifrado (em hexadecimal)? " + textoCifradoHex);
        System.out.println("2.2. Qual a extensão (quantidade de caracteres) do texto cifrado? " + textoCifrado.length);
        System.out.println("2.3. Por que o texto cifrado tem tal tamanho? " + "Porque o processo de criptografia realiza a quebra do texto em blocos de 8 bytes (com padding), logo esse processo quebrou o texto em dois (2) blocos, totalizando 16 bytes");
    }
}
