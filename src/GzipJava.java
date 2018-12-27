import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipJava {

    private static Scanner scanner = new Scanner(System.in);

    public static void compressGZIP() {
        System.out.print("Podaj ścieżkę do pliku: ");
        String fileSource = scanner.nextLine();
        System.out.println("Scieżka pliku do zapakowania: " + fileSource);

        String[] partsFileSource = fileSource.split(Pattern.quote("\\"));
        String fileName = partsFileSource[partsFileSource.length - 1] + ".gzip";
        System.out.println("Plik zostanie zapisany pod nazwą: " + fileName);

        try (GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(new File(fileName)))) {
            try (FileInputStream in = new FileInputStream(new File(fileSource))) {
                byte[] buffer = new byte[1024];
                int len;
                while ((len = in.read(buffer)) != -1) {
                    out.write(buffer, 0, len);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decompressGzip() {
        System.out.print("Podaj ścieżkę do pliku: ");
        String fileSource = scanner.nextLine();
        System.out.println("Scieżka pliku do rozpakowania: " + fileSource);

        String[] partsFileSource = fileSource.split(Pattern.quote("\\"));
        String fileName = partsFileSource[partsFileSource.length - 1].replace(".gzip", "");
        System.out.println("Plik zostanie zapisany pod nazwą: " + fileName);

        try (GZIPInputStream in = new GZIPInputStream(new FileInputStream(new File(fileSource)))) {
            try (FileOutputStream out = new FileOutputStream(new File(fileName))) {
                byte[] buffer = new byte[1024];
                int len;
                while ((len = in.read(buffer)) != -1) {
                    out.write(buffer, 0, len);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}