public class Caso06 {
    public static void executar() {
        byte[] chave = {65, 66, 67, 68, 69};
        String texto = "FURB";
        byte[] vetorInicializacao = {0, 0, 0, 0, 0, 0, 0, 0}; // vetor padrao (nao foi dados no enunciado)

        byte[] textoCifrado = CipherUtils.cifrarComModoCBC(texto, chave, vetorInicializacao);
        String textoCifradoHex = CipherUtils.converterBytesParaHexadecimal(textoCifrado);

        byte[] textoDecifrado = CipherUtils.decifrarComModoCBC(textoCifrado, chave, vetorInicializacao);
        String textoDecifradoString = new String(textoDecifrado);

        System.out.println();
        System.out.println("========== CASO 06 ==========");
        System.out.println("6.1. Qual o conteúdo do texto cifrado (em hexadecimal)? " + textoCifradoHex);
        System.out.println("6.2. Tente decifrar o texto cifrado, para recuperar o texto simples. O que acontece? " + "Sem um vetor de inicializacao definido o processo de cifra é interrompido por uma exceção");
    }
}
