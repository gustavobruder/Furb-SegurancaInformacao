public class Caso03 {
    public static void executar() {
        byte[] chave = {65, 66, 67, 68, 69};
        String texto = "SABONETE";

        byte[] textoCifrado = CipherUtils.cifrarComModoECB(texto, chave);
        String textoCifradoHex = CipherUtils.converterBytesParaHexadecimal(textoCifrado);

        System.out.println();
        System.out.println("========== CASO 03 ==========");
        System.out.println("3.1. Qual o conteúdo do texto cifrado (em hexadecimal)? " + textoCifradoHex);
        System.out.println("3.2. Qual a extensão (quantidade de caracteres) do texto cifrado? " + textoCifrado.length);
        System.out.println("3.3. Por que o texto cifrado tem tal tamanho? " + "Porque o processo de criptografia realiza a quebra do texto em blocos de 8 bytes, porém quando o último bloco não precisa de preenchimento (padding), ainda assim é gerado um bloco adicional");
    }
}
