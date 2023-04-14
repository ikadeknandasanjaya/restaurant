import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    public static void loginSystem(ArrayList<Restaurant> listRestaurant, ArrayList<Pesanan> listPesanan) {
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
            int pilih = fiturs.hanyaInteger(scanner, "");
            if (pilih == 1) {
                admins.loginAdmin(listRestaurant, listPesanan);
            } else if (pilih == 2) {
                customers.loginCustomer(listRestaurant, listPesanan);
            } else {
                System.out.println("Pilihan tidak sesuai");
                System.out.println("Coba ulangi");
            }
        }
    }
}
