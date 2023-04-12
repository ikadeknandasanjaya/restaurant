import java.util.Scanner;

public class Fitur {
    public int readInteger(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Input salah! tidak boleh memasukan selain angka");
            scanner.next();
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }
    public static String readString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        while (input.isEmpty()) {
            System.out.println("Input salah! tidak boleh memasukan kosong");
            System.out.print(prompt);
            input = scanner.nextLine();
        }
        return input;
    }
}
