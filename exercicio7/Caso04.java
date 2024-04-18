public class Caso04 {
    public static void executar() {
        byte[] chave = {65, 66, 67, 68, 69};
        String texto = new String(new byte[] {8, 8, 8, 8, 8, 8, 8, 8});

        byte[] textoCifrado = CipherUtils.cifrarComModoECB(texto, chave);
        String textoCifradoHex = CipherUtils.converterBytesParaHexadecimal(textoCifrado);

        System.out.println();
        System.out.println("========== CASO 04 ==========");
        System.out.println("4.1. Qual o conteúdo do texto cifrado (em hexadecimal)? " + textoCifradoHex);
        System.out.println("4.2. Compare os primeiros 8 bytes do texto cifrado com o último bloco cifrado da questão anterior. Que conclusão é possível obter? " + "A conclusão é que eles são exatamente idênticos, pois o texto desse caso (04) resultou nos caracteres de preenchimento (padding) do caso anterior (03)");
    }
}
