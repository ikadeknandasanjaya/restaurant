import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        System.out.println("Selamat Datang di Sistem Pemesanan Restaurant");
        login.loginSystem();
    }
}
