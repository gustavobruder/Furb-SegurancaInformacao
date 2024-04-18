public class Caso08 {
    public static void executar() {
        byte[] chave = {65, 66, 67, 68, 69};
        String texto = "SABONETESABONETESABONETE";
        byte[] vetorInicializacao = {1, 1, 2, 2, 3, 3, 4, 4};

        byte[] textoCifrado = CipherUtils.cifrarComModoCBC(texto, chave, vetorInicializacao);
        String textoCifradoHex = CipherUtils.converterBytesParaHexadecimal(textoCifrado);

        System.out.println();
        System.out.println("========== CASO 08 ==========");
        System.out.println("8.1. Qual o conteúdo do texto cifrado (em hexadecimal)? " + textoCifradoHex);
        System.out.println("8.2. Compare o texto cifrado com aquele obtido no caso 4 e apresente uma conclusão desta comparação. " + "Não há nenhuma semelhança entre eles");
    }
}
