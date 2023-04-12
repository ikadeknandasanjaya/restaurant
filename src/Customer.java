import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    private static String username = "customer";
    private static String password = "customer";

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static void loginCustomer(ArrayList<Restaurant> listRestaurant) {
        Scanner scanner = new Scanner(System.in);
        Customer customers = new Customer();

        Fitur fiturs = new Fitur();
        String username = fiturs.readString(scanner, "Masukan username : ");
        String password = fiturs.readString(scanner, "Masukan password : ");
        if (username.equals(customers.getUsername()) && password.equals(customers.getPassword())) {
            customers.menuCustomer(listRestaurant);
        } else {
            System.out.println("Username dan password tidak sesuai dengan database kami.");
            System.out.println("Silahkan ulangi.");
            customers.loginCustomer(listRestaurant);
        }
    }

    public void menuCustomer(ArrayList<Restaurant> listRestaurant) {
        while (true) {
            System.out.println("Selamat datang Customer!");
            System.out.println("Menu Customer");
            System.out.println("1. Lihat Restaurant");
            System.out.println("2. Lihat Menu");
            System.out.println("3. Buat Pesanan");
            System.out.println("4. Lihat Pesanan");
            System.out.println("5. Kembali Ke Login");
            System.out.print("Masukan Pilihan : ");
            Scanner scanner = new Scanner(System.in);
            Login logins = new Login();
            int pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1:
                    lihatRestaurant(listRestaurant);
                    break;
                case 2:
                    lihatMenu(listRestaurant);
                    break;
                case 3:
                    buatPesanan(listRestaurant);
                    break;
                case 4:
                    lihatPesanan(listRestaurant);
                    break;
                case 5:
                    logins.loginSystem(listRestaurant);
                    break;
                default:
                    System.out.println("Pilihan salah, coba ulangi.");
                    menuCustomer(listRestaurant);
            }
        }
    }

    public static void lihatRestaurant(ArrayList<Restaurant> listRestaurant) {
        Scanner scanner = new Scanner(System.in);
        Customer customers = new Customer();
        if (listRestaurant.isEmpty()) {
            scanner = new Scanner(System.in);
            System.out.println("| Restaurant kosong, silahkan tambah restauran |");
            System.out.print("Tekan enter untuk kembali ke menu");
            String enter = scanner.nextLine();
            Admin admins = new Admin();
            admins.menuAdmin(listRestaurant);
        } else {
            System.out.println("=======================================");
            System.out.println("|          Daftar Restaurant          |");
            System.out.println("=======================================");
            for (int i = 0; i < listRestaurant.size(); i++) {
                System.out.println("| " + (i + 1) + ".  Nama Restaurant : " + listRestaurant.get(i).getName() + " | Alamat Restaurant : " + listRestaurant.get(i).getAddress() + " |");
            }
            System.out.println("| Tekan 1 untuk melihat lagi atau tekan 2 untuk kembali ke menu |");
            System.out.print("Pilih : ");
            int pilihan = scanner.nextInt();
            if (pilihan == 1) {
                customers.lihatRestaurant(listRestaurant);
            } else {
                String enter = scanner.nextLine();
                customers.menuCustomer(listRestaurant);
            }
        }
    }

    public static void lihatMenu(ArrayList<Restaurant> listRestaurant) {
        Scanner scanner = new Scanner(System.in);
        Customer customers = new Customer();
        if (listRestaurant.isEmpty()) {
            System.out.println("Restaurant kosong.");
            System.out.println("Silahkan tambahkan terlebih dahulu");
            System.out.print("Tekan enter untuk kembali ke menu");
            String enter = scanner.nextLine();
            customers.menuCustomer(listRestaurant);
        }

        System.out.println("Pilih restaurant untuk dilihat menunya : ");
        for (int i = 0; i < listRestaurant.size(); i++) {
            System.out.println((i + 1) + ". " + listRestaurant.get(i).getName());
        }
        System.out.print("Pilihan: ");
        int restaurantIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        Restaurant restaurant = listRestaurant.get(restaurantIndex);
        ArrayList<Menu> menuMakanan = restaurant.getMakananList();
        ArrayList<Menu> menuMinuman = restaurant.getMinumanList();
        if (menuMakanan.isEmpty()) {
            System.out.println("Tidak terdapat menu untuk restaurant " + restaurant.getName());
            System.out.println("Tekan 1 untuk melihat lagi atau tekan 2 untuk kembali ke menu |");
            System.out.print("Pilih : ");
            int pilihan = scanner.nextInt();
            if (pilihan == 1) {
                customers.lihatMenu(listRestaurant);
            } else {
                String enter = scanner.nextLine();
                customers.menuCustomer(listRestaurant);
            }
        } else {
            System.out.println("| " + "Makanan :  " + restaurant.getName() + " |");
            for (Menu item : menuMakanan) {
                System.out.println("| " + item.getNamaMenu() + " " + item.getHargaMenu() + " |");
            }
            System.out.println("| " + "Minuman :  " + restaurant.getName() + " |");
            for (Menu item : menuMinuman) {
                System.out.println("| " + item.getNamaMenu() + " " + item.getHargaMenu() + " |");
            }
            System.out.println("Tekan 1 untuk melihat lagi atau tekan 2 untuk kembali ke menu |");
            System.out.print("Pilih : ");
            int pilihan = scanner.nextInt();
            if (pilihan == 1) {
                customers.lihatMenu(listRestaurant);
            } else {
                String enter = scanner.nextLine();
                customers.menuCustomer(listRestaurant);
            }
        }
    }

    public static void buatPesanan(ArrayList<Restaurant> listRestaurant) {
        Customer customers = new Customer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pilih restaurant yang akan dipesan : ");
        for (int i = 0; i < listRestaurant.size(); i++) {
            System.out.println("| " + (i + 1) + ".  Nama Restaurant : " + listRestaurant.get(i).getName() + " | Alamat Restaurant : " + listRestaurant.get(i).getAddress() + " |");
        }
        System.out.print("Pilihan : ");
        int restaurantIndex = scanner.nextInt() - 1;
        Restaurant restaurant = listRestaurant.get(restaurantIndex);
        scanner.nextLine();

        if (listRestaurant.isEmpty()) {
            System.out.println("Restaurant kosong.");
            System.out.println("Silahkan tambahkan terlebih dahulu");
            System.out.print("Tekan enter untuk kembali ke menu");
            String enter = scanner.nextLine();
            customers.menuCustomer(listRestaurant);
        }

        System.out.println("Pilih restaurant untuk dilihat menunya : ");
        for (int i = 0; i < listRestaurant.size(); i++) {
            System.out.println((i + 1) + ". " + listRestaurant.get(i).getName());
        }
        System.out.print("Pilihan: ");
        int indexRestaurant = scanner.nextInt() - 1;
        scanner.nextLine();

        Restaurant restaurants = listRestaurant.get(indexRestaurant);
        ArrayList<Menu> menuMakanan = restaurants.getMakananList();
        ArrayList<Menu> menuMinuman = restaurants.getMinumanList();
        if (menuMakanan.isEmpty()) {
            System.out.println("Tidak terdapat menu untuk restaurant " + restaurant.getName());
            System.out.println("Tekan 1 untuk melihat lagi atau tekan 2 untuk kembali ke menu |");
            System.out.print("Pilih : ");
            int pilihan = scanner.nextInt();
            if (pilihan == 1) {
                customers.lihatMenu(listRestaurant);
            } else {
                String enter = scanner.nextLine();
                customers.menuCustomer(listRestaurant);
            }
        } else {
            System.out.println("| " + "Makanan :  " + restaurant.getName() + " |");
            for (Menu item : menuMakanan) {
                System.out.println("| " + item.getNamaMenu() + " " + item.getHargaMenu() + " |");
            }
            System.out.println("| " + "Minuman :  " + restaurant.getName() + " |");
            for (Menu item : menuMinuman) {
                System.out.println("| " + item.getNamaMenu() + " " + item.getHargaMenu() + " |");
            }
            System.out.println("Tekan 1 untuk melihat lagi atau tekan 2 untuk kembali ke menu |");
            System.out.print("Pilih : ");
            int pilihan = scanner.nextInt();
            if (pilihan == 1) {
                customers.lihatMenu(listRestaurant);
            } else {
                String enter = scanner.nextLine();
                customers.menuCustomer(listRestaurant);
            }

        }

    }
    public static void lihatPesanan(ArrayList<Restaurant> listRestaurant) {

    }
}