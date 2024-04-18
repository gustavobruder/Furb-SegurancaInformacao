public class Caso09 {
    public static void executar() {
        byte[] chave = {65, 66, 67, 68, 69};
        String texto = "SABONETESABONETESABONETE";
        byte[] vetorInicializacao1 = {10, 20, 30, 40, 50, 60, 70, 80};
        byte[] vetorInicializacao2 = {1, 1, 2, 2, 3, 3, 4, 4};

        byte[] textoCifrado = CipherUtils.cifrarComModoCBC(texto, chave, vetorInicializacao1);
        String textoCifradoString = new String(textoCifrado);
        String textoCifradoHex = CipherUtils.converterBytesParaHexadecimal(textoCifrado);

        byte[] textoDecifrado = CipherUtils.decifrarComModoCBC(textoCifrado, chave, vetorInicializacao2);
        String textoDecifradoString = new String(textoDecifrado);
        String textoDecifradoHex = CipherUtils.converterBytesParaHexadecimal(textoDecifrado);

        System.out.println();
        System.out.println("========== CASO 09 ==========");
        System.out.println("9.1. Qual o conteúdo do texto cifrado? " + textoCifradoString);
        System.out.println("9.1. Qual o conteúdo do texto cifrado (em hexadecimal)? " + textoCifradoHex);
        System.out.println("9.2. Compare o texto cifrado com o que foi obtido no caso 8 e apresente conclusão sobre a comparação. " + "Mesmo tendo o mesmo texto original, o resultado é diferente devido ao vetor de inicializacao diferente");
        System.out.println("9.3. A partir do resultado de 9.2, decriptografe a mensagem usando o vetor de inicialização constituído dos bytes 1, 1, 2, 2, 3, 3, 4, 4. Qual a conclusão que você atinge? " + "Devido ao vetor de inicializacao diferente, o resultado encontrado não é igual ao texto original");
    }
}
