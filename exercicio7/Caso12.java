import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Caso12 {
    public static void executar() {
        byte[] chave = "ABCDE".getBytes();
        String nomeArquivo = "./saida.bin";

        File arquivoPDF = new File(nomeArquivo);
        byte[] bytesPDF = new byte[(int) arquivoPDF.length()];

        try {
            FileInputStream inputStream = new FileInputStream(arquivoPDF);
            inputStream.read(bytesPDF);
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        byte[] bytesDecifrados = null;

        try {
            bytesDecifrados = CipherUtils.decifrarComModoECB(bytesPDF, chave);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        File arquivoSaida = new File("./decriptografado.pdf");

        try {
            FileOutputStream outputStream = new FileOutputStream(arquivoSaida);
            outputStream.write(bytesDecifrados);
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println();
        System.out.println("========== CASO 12 ==========");
        System.out.println("12.1. Qual o tamanho em bytes do arquivo? " + arquivoSaida.length() + " bytes");
    }
}
