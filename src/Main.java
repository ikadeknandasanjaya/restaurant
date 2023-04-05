import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat Datang di Sistem Pemesanan Restaurant");
        System.out.println("1. Login sebagai admin");
        System.out.println("2. Login sebagai customer");
        System.out.print("Masukan Pilihan : ");
        int tipeUser = scanner.nextInt();

        switch (tipeUser) {
            case 1:
                loginAdmin();
                break;
            case 2:
                loginCustomer();
                break;
            default:
                System.out.println("Pilihan tidak ada.");
                main(null);
        }
    }

    private static void loginCustomer() {
    }

    private static void loginAdmin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukan username admin : ");
        String username = scanner.nextLine();
        System.out.print("Masukan password admin : ");
        String password = scanner.nextLine();

        if (username.equals("admin") && password.equals("admin")) {
            System.out.println("Login berhasil sebagai admin.");
            adminMenu();
        } else {
            System.out.println("Username dan password salah.");
            loginAdmin();
        }
    }

    private static void adminMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Melihat Restaurant");
            System.out.println("2. Menambah Restaurant");
            System.out.println("3. Menghapus Restaurant");
            System.out.println("4. Logout");

            System.out.print("Masukan Pilihan : ");
            int choice = scanner.nextInt();

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
                    return;
                default:
                    System.out.println("Pilihan Salah!");
                    adminMenu();
                    
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
