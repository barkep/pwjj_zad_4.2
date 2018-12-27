import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Program do pakowania i rozpakowywania plików w formacie GZIP.\nCo chcesz zrobić?\n1.Rozpakować\n2.Zapakować\nWybierz numer i zatwierdź enterem: ");
        int wybor = scanner.nextInt();
        while (wybor != 1 && wybor != 2) {
            System.out.print("Wprowadziłeś zły numer, wybierz jeszcze raz: ");
            wybor = scanner.nextInt();
        }
        if (wybor == 1) {
            GzipJava.decompressGzip();
        } else {
            GzipJava.compressGZIP();
        }
    }
}
