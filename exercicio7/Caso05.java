public class Caso05 {
    public static void executar() {
        byte[] chave = {65, 66, 67, 68, 69};
        String texto = "SABONETESABONETESABONETE";

        byte[] textoCifrado = CipherUtils.cifrarComModoECB(texto, chave);
        String textoCifradoHex = CipherUtils.converterBytesParaHexadecimal(textoCifrado);

        System.out.println();
        System.out.println("========== CASO 05 ==========");
        System.out.println("5.1. Qual o conteúdo do texto cifrado (em hexadecimal)? " + textoCifradoHex);
        System.out.println("5.2. Qual a extensão (quantidade de caracteres) do texto cifrado? " + textoCifrado.length);
        System.out.println("5.3. Avalie o conteúdo do texto cifrado. Que conclusão é possível obter a partir do texto cifrado e do texto simples? " + "Assim como o texto simples tem a repetição 3x da palavra 'SABONETE', o texto cifrado também possui uma repetição de 3x da sequencia respectiva");
    }
}
