import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Caso11 {
    public static void executar() {
        byte[] chave = "ABCDE".getBytes();
        String nomeArquivo = "./L07 - Criptografia Blowfish (v2).pdf";

        File arquivoPDF = new File(nomeArquivo);
        byte[] bytesPDF = new byte[(int) arquivoPDF.length()];

        try {
            FileInputStream inputStream = new FileInputStream(arquivoPDF);
            inputStream.read(bytesPDF);
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        byte[] bytesCifrados = CipherUtils.cifrarComModoECB(bytesPDF, chave);

        File arquivoSaida = new File("./saida.bin");

        try {
            FileOutputStream outputStream = new FileOutputStream(arquivoSaida);
            outputStream.write(bytesCifrados);
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println();
        System.out.println("========== CASO 11 ==========");
        System.out.println("11.1. Qual o tamanho em bytes dos dois arquivos? " + "Arquivo entrada: " + arquivoPDF.length() + " bytes - " + "Arquivo saida: " + arquivoSaida.length() + " bytes ");
    }
}
