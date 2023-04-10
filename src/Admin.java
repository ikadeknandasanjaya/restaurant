import java.util.Scanner;

public class Admin {
    private String username = "admin";
    private String password = "admin";

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static void menuAdmin() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Selamat datang Admin!");
            System.out.println("Menu Admin : ");
            System.out.println("1. Lihat Restaurant");
            System.out.println("2. Tambah Restaurant");
            System.out.println("3. Hapus Restaurant");
            System.out.println("4. Kembali Ke Login");

            System.out.print("Masukan Pilihan : ");
            int choice = scanner.nextInt();
            Login login = new Login();
            switch (choice) {
                case 1:
                    lihatRestaurant();
                    break;
                case 2:
                    tambahRestaurant();
                    break;
                case 3:
                    hapusRestaurant();
                    break;
                case 4:
                    login.loginSystem();
                default:
                    System.out.println("Pilihan Salah!");
                    menuAdmin();

            }
        }
    }

    private static void lihatRestaurant() {

    }

    private static void tambahRestaurant() {
    }

    private static void hapusRestaurant() {
    }
}
