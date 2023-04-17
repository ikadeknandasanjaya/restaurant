
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private static String username = "admin";

    private static String password = "admin";

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }


    public static void loginAdmin(ArrayList<Restaurant> listRestaurant, ArrayList<Pesanan> listPesanan) {
        Admin admins = new Admin();
        Fitur fiturs = new Fitur();
        System.out.println("=======================================");
        System.out.println("|    Selamat Datang di Login Admin    |");
        System.out.println("=======================================");
        Scanner scanner = new Scanner(System.in);
        String username = fiturs.hanyaString(scanner, "| Masukan username : ");
        String password = fiturs.hanyaString(scanner, "| Masukan password : ");
        System.out.println("=======================================");

        if (username.equals(admins.getUsername()) && password.equals(admins.getPassword())) {
            admins.menuAdmin(listRestaurant, listPesanan);
        } else {
            System.out.println("Username dan password tidak sesuai dengan database kami.");
            System.out.println("Silahkan ulangi.");
            admins.loginAdmin(listRestaurant, listPesanan);
        }
    }


    public static void menuAdmin(ArrayList<Restaurant> listRestaurant, ArrayList<Pesanan> listPesanan) {
        Fitur fiturs = new Fitur();
        Scanner scanner = new Scanner(System.in);
        Login logins = new Login();
        while (true) {
            System.out.println("=======================================");
            System.out.println("|    Selamat Datang di Menu Admin     |");
            System.out.println("=======================================");
            System.out.println("| Menu Admin :                        |");
            System.out.println("| 1. Lihat Restaurant                 |");
            System.out.println("| 2. Tambah Restaurant                |");
            System.out.println("| 3. Hapus Restaurant                 |");
            System.out.println("| 4. Tambah Menu                      |");
            System.out.println("| 5. Lihat Menu                       |");
            System.out.println("| 6. Kembali Ke Login                 |");
            System.out.println("=======================================");
            System.out.print("Masukan Pilihan : ");
            int pilihan = fiturs.hanyaInteger(scanner, "");
            switch (pilihan) {
                case 1:
                    lihatRestaurant(listRestaurant, listPesanan);
                    break;
                case 2:
                    tambahRestaurant(listRestaurant, listPesanan);
                    break;
                case 3:
                    hapusRestaurant(listRestaurant, listPesanan);
                    break;
                case 4:
                    tambahMenu(listRestaurant, listPesanan);
                case 5:
                    lihatMenu(listRestaurant, listPesanan);
                case 6:
                    logins.loginSystem(listRestaurant, listPesanan);
                default:
                    System.out.println("Pilihan Salah!");
                    menuAdmin(listRestaurant, listPesanan);
            }
        }
    }

    public static void lihatRestaurant(ArrayList<Restaurant> listRestaurant, ArrayList<Pesanan> listPesanan) {
        Fitur fiturs = new Fitur();
        if (listRestaurant.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("| Restaurant kosong, silahkan tambah restauran |");
            System.out.print("Tekan enter untuk kembali ke menu");
            scanner.nextLine();
            Admin admins = new Admin();
            admins.menuAdmin(listRestaurant, listPesanan);
        } else {
            System.out.println("=======================================");
            System.out.println("|          Daftar Restaurant          |");
            System.out.println("=======================================");
            for (int i = 0; i < listRestaurant.size(); i++) {
                System.out.println("| " + (i + 1) + ".  Nama Restaurant : " + listRestaurant.get(i).getNamaRestaurant() + " | Alamat Restaurant : " + listRestaurant.get(i).getAddress() + " |");
            }
            Scanner scanner = new Scanner(System.in);
            Admin admins = new Admin();
            System.out.println("| Tekan 1 untuk melihat lagi atau tekan 2 untuk kembali ke menu |");
            System.out.print("Pilih : ");
            int pilihan = fiturs.hanyaInteger(scanner, "");
            if (pilihan == 1) {
                admins.lihatRestaurant(listRestaurant, listPesanan);
            } else {
                scanner.nextLine();
                menuAdmin(listRestaurant, listPesanan);
            }
        }
    }

    public static void tambahRestaurant(ArrayList<Restaurant> listRestaurant, ArrayList<Pesanan> listPesanan) {
        Scanner scanner = new Scanner(System.in);
        Fitur fiturs = new Fitur();
        System.out.println("=======================================");
        System.out.println("|       Menu Tambah Restaurant         |");
        System.out.println("=======================================");
        System.out.print("Masukan ID restaurant : ");
        int idRestaurant = fiturs.hanyaInteger(scanner, "");
        scanner.nextLine();
        System.out.print("Masukan nama restaurant : ");
        String namaRestaurant = fiturs.hanyaString(scanner, "");
        System.out.print("Masukan alamat restaurant : ");
        String alamatRestaurant = fiturs.hanyaString(scanner, "");
        Restaurant restaurantBaru = new Restaurant(idRestaurant, namaRestaurant, alamatRestaurant);
        listRestaurant.add(restaurantBaru);
        System.out.println("| Restaurant berhasil ditambahkan |");
        Admin admins = new Admin();
        System.out.println("| Tekan 1 untuk menambah lagi atau tekan 2 untuk kembali ke menu |");
        System.out.print("Pilih : ");
        int pilihan = fiturs.hanyaInteger(scanner, "");
        if (pilihan == 1) {
            admins.tambahRestaurant(listRestaurant, listPesanan);
        } else {
            scanner.nextLine();
            menuAdmin(listRestaurant, listPesanan);
        }
    }

    public static void tambahMenu(ArrayList<Restaurant> listRestaurant,ArrayList<Pesanan> listPesanan) {
        Scanner scanner = new Scanner(System.in);
        Admin admins = new Admin();
        Fitur fiturs = new Fitur();
        System.out.println("=======================================");
        System.out.println("|          Menu Tambah Menu           |");
        System.out.println("=======================================");
        if (listRestaurant.isEmpty()) {
            System.out.println("Restaurant kosong.");
            System.out.println("Silahkan tambahkan terlebih dahulu");
            System.out.print("Tekan enter untuk kembali ke menu");
            scanner.nextLine();
            admins.menuAdmin(listRestaurant, listPesanan);
        }
        System.out.println("Pilih restaurant yang akan ditambahkan menu : ");
        for (int i = 0; i < listRestaurant.size(); i++) {
            System.out.println("| " + listRestaurant.get(i).getIdRestaurant() + ".  Nama Restaurant : " + listRestaurant.get(i).getNamaRestaurant() + " | Alamat Restaurant : " + listRestaurant.get(i).getAddress() + " |");
        }
        System.out.print("Pilihan : ");
        int pilihRestaurant = fiturs.hanyaInteger(scanner, "");
        Restaurant restaurant = fiturs.cariRestaurantDenganID(pilihRestaurant, listRestaurant, listPesanan);
        if (restaurant == null) {
            System.out.println("Restaurant not found. Please try again.");
            return;
        }
        scanner.nextLine();

        System.out.print("Masukan ID menu : ");
        int idMenu = fiturs.hanyaInteger(scanner, "");

        scanner.nextLine();

        System.out.print("Masukan nama menu : ");
        String namaMenu = fiturs.hanyaString(scanner, "");

        System.out.print("Masukan jenis menu (Makanan/Minuman) : ");
        String tipeMenu = scanner.nextLine();

        System.out.print("Masukan harga menu : ");
        double price = scanner.nextDouble();

        Menu menu = new Menu(idMenu, namaMenu, tipeMenu, price);
        restaurant.getMenuList().add(menu);

        System.out.println("Menu makanan berhasil ditambahkan.");
            System.out.println("| Tekan 1 untuk menambahkan lagi atau tekan 2 untuk kembali ke menu |");
            System.out.print("Pilih : ");
            int pilihan3 = fiturs.hanyaInteger(scanner, "");
            if (pilihan3 == 1) {
                admins.tambahMenu(listRestaurant, listPesanan);
            } else {
                scanner.nextLine();
                menuAdmin(listRestaurant,listPesanan);
        }
    }

    public static void lihatMenu(ArrayList<Restaurant> listRestaurant, ArrayList<Pesanan> listPesanan) {
        Scanner scanner = new Scanner(System.in);
        Fitur fiturs = new Fitur();
        Admin admins = new Admin();
         if (listRestaurant.isEmpty()) {
            System.out.println("Restaurant kosong.");
            System.out.println("Silahkan tambahkan terlebih dahulu");
            System.out.print("Tekan enter untuk kembali ke menu");
            scanner.nextLine();
            admins.menuAdmin(listRestaurant, listPesanan);
        }

        System.out.println("Pilih restaurant untuk dilihat menunya : ");
        for (int i = 0; i < listRestaurant.size(); i++) {
            System.out.println((i + 1) + ". " + listRestaurant.get(i).getNamaRestaurant());
        }
        System.out.print("Pilihan: ");
        int idRestaurant = fiturs.hanyaInteger(scanner, "");
        scanner.nextLine();
        Restaurant restaurant = fiturs.cariRestaurantDenganID(idRestaurant, listRestaurant, listPesanan);
        ArrayList<Menu> menuRestaurant = restaurant.getMenuList();
        if (menuRestaurant.isEmpty()) {
            System.out.println("Tidak terdapat menu untuk restaurant " + restaurant.getNamaRestaurant());
            System.out.println("Tekan 1 untuk melihat lagi atau tekan 2 untuk kembali ke menu |");
            System.out.print("Pilih : ");
            int pilihan = fiturs.hanyaInteger(scanner, "");
            if (pilihan == 1) {
                admins.lihatMenu(listRestaurant, listPesanan);
            } else {
                scanner.nextLine();
                admins.menuAdmin(listRestaurant, listPesanan);
            }
        } else {
            System.out.println("| " + "Menu untuk restaurant :  " + restaurant.getNamaRestaurant() + " |");
            System.out.println("| ID Menu \t\t Nama Menu \t\t Tipe Menu \t\t Harga");
            for (Menu item : menuRestaurant) {
                System.out.println("| " + item.getIdMenu() + " \t\t\t " + item.getNamaMenu() + " \t\t\t " + item.getTipeMenu() + " \t\t " + item.getPrice() + " |");
            }
            System.out.println("Tekan 1 untuk melihat lagi atau tekan 2 untuk kembali ke menu |");
            System.out.print("Pilih : ");
            int pilihan = fiturs.hanyaInteger(scanner, "");
            if (pilihan == 1) {
                admins.lihatMenu(listRestaurant, listPesanan);
            } else {
                scanner.nextLine();
                menuAdmin(listRestaurant, listPesanan);
            }
        }
    }


    public static void hapusRestaurant(ArrayList <Restaurant> listRestaurant, ArrayList <Pesanan> listPesanan) {
        Fitur fiturs = new Fitur();
        Scanner scanner = new Scanner(System.in);
        Admin admins = new Admin();
        System.out.println("=======================================");
        System.out.println("|  Selamat Datang di Hapus Restaurant |");
        System.out.println("=======================================");
        if (listRestaurant.isEmpty()) {
            System.out.println("Restaurant kosong.");
            System.out.println("Silahkan tambahkan terlebih dahulu");
            System.out.print("Tekan enter untuk kembali ke menu");
            scanner.nextLine();
            admins.menuAdmin(listRestaurant, listPesanan);
        }
        System.out.println("Pilih restaurant yang akan dihapus");
        for (int i = 0; i < listRestaurant.size(); i++) {
            System.out.println((i + 1) + ". " + listRestaurant.get(i).getNamaRestaurant());
        }
        System.out.print("Pilih : ");
        int pilih = fiturs.hanyaInteger(scanner, "");
        listRestaurant.remove(pilih - 1);
        System.out.println("| Restaurant telah dihapus |");
        System.out.println("| Tekan 1 untuk menghapus lagi atau tekan 2 untuk kembali ke menu |");
        System.out.print("Pilih : ");
        int pilihan = fiturs.hanyaInteger(scanner, "");
        if (pilihan == 1) {
            admins.hapusRestaurant(listRestaurant, listPesanan);
        } else {
            scanner.nextLine();
            menuAdmin(listRestaurant, listPesanan);
        }
    }

}