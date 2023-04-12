import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    public static void loginSystem(ArrayList<Restaurant> listRestaurant) {
        Admin admins = new Admin();
        Customer customers = new Customer();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("========================================");
            System.out.println("|  Selamat Datang di Sistem Pemesanan  |");
            System.out.println("========================================");
            System.out.println("| Options:                             |");
            System.out.println("|         1. Admin                     |");
            System.out.println("|         2. Customer                  |");
            System.out.println("========================================");
            System.out.print("Masukan Pilihan : ");
            Fitur fiturs = new Fitur();
            int pilih = fiturs.readInteger(scanner, "");
            if (pilih == 1) {
                admins.loginAdmin(listRestaurant);
            } else if (pilih == 2) {
                customers.loginCustomer(listRestaurant);
            } else {
                System.out.println("Pilihan tidak sesuai");
                System.out.println("Coba ulangi");
            }
        }
    }
}
