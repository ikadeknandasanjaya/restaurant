
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    public static String username = "admin";

    public static String password = "admin";

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
            int choice = scanner.nextInt();
            switch (choice) {
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
            int pilihan = scanner.nextInt();
            if (pilihan == 1) {
                admins.lihatRestaurant(listRestaurant, listPesanan);
            } else {
                String enter = scanner.nextLine();
                menuAdmin(listRestaurant, listPesanan);
            }
        }
    }

    public static void tambahRestaurant(ArrayList<Restaurant> listRestaurant, ArrayList<Pesanan> listPesanan) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=======================================");
        System.out.println("|       Menu Tambah Restaurant         |");
        System.out.println("=======================================");
        System.out.print("Masukan ID restaurant : ");
        int restaurantId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukan nama restaurant : ");
        String name = scanner.nextLine();
        System.out.print("Masukan alamat restaurant : ");
        String address = scanner.nextLine();
        Restaurant restaurantBaru = new Restaurant(restaurantId, name, address);
        listRestaurant.add(restaurantBaru);
        System.out.println("| Restaurant berhasil ditambahkan |");
        Admin admins = new Admin();
        System.out.println("| Tekan 1 untuk menambah lagi atau tekan 2 untuk kembali ke menu |");
        System.out.print("Pilih : ");
        int pilihan = scanner.nextInt();
        if (pilihan == 1) {
            admins.tambahRestaurant(listRestaurant, listPesanan);
        } else {
            String enter = scanner.nextLine();
            menuAdmin(listRestaurant, listPesanan);
        }
    }

    public static void tambahMenu(ArrayList<Restaurant> listRestaurant,ArrayList<Pesanan> listPesanan) {
        Scanner scanner = new Scanner(System.in);
        Admin admins = new Admin();
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
        int restaurantIndex = scanner.nextInt();
        Fitur fiturs = new Fitur();
        Restaurant restaurant = fiturs.cariRestaurantDenganID(restaurantIndex, listRestaurant, listPesanan);
        if (restaurant == null) {
            System.out.println("Restaurant not found. Please try again.");
            return;
        }
        scanner.nextLine();

        System.out.print("Masukan ID menu : ");
        int idMenu = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Masukan nama menu : ");
        String menuName = scanner.nextLine();

        System.out.print("Masukan jenis makanan (Makanan/Minuman) : ");
        String menuType = scanner.nextLine();

        System.out.print("Masukan harga menu : ");
        double price = scanner.nextDouble();

        Menu menu = new Menu(idMenu, menuName, menuType, price);
        restaurant.menuList.add(menu);

        System.out.println("Menu makanan berhasil ditambahkan.");
            System.out.println("| Tekan 1 untuk menambahkan lagi atau tekan 2 untuk kembali ke menu |");
            System.out.print("Pilih : ");
            int pilihan3 = scanner.nextInt();
            if (pilihan3 == 1) {
                admins.tambahMenu(listRestaurant, listPesanan);
            } else {
                String enter = scanner.nextLine();
                menuAdmin(listRestaurant,listPesanan);
        }
    }

    public static void lihatMenu(ArrayList<Restaurant> listRestaurant, ArrayList<Pesanan> listPesanan) {
        Scanner scanner = new Scanner(System.in);
        Admin admins = new Admin();
        if (listRestaurant.isEmpty()) {
            System.out.println("Restaurant kosong.");
            System.out.println("Silahkan tambahkan terlebih dahulu");
            System.out.print("Tekan enter untuk kembali ke menu");
            String enter = scanner.nextLine();
            admins.menuAdmin(listRestaurant, listPesanan);
        }

        System.out.println("Pilih restaurant untuk dilihat menunya : ");
        for (int i = 0; i < listRestaurant.size(); i++) {
            System.out.println((i + 1) + ". " + listRestaurant.get(i).getNamaRestaurant());
        }
        System.out.print("Pilihan: ");
        int restaurantIndex = scanner.nextInt();
        scanner.nextLine();
        Fitur fiturs = new Fitur();
        Restaurant restaurant = fiturs.cariRestaurantDenganID(restaurantIndex, listRestaurant, listPesanan);
        ArrayList<Menu> menuRestaurant = restaurant.getMenuList();
        if (menuRestaurant.isEmpty()) {
            System.out.println("Tidak terdapat menu untuk restaurant " + restaurant.getNamaRestaurant());
            System.out.println("Tekan 1 untuk melihat lagi atau tekan 2 untuk kembali ke menu |");
            System.out.print("Pilih : ");
            int pilihan = scanner.nextInt();
            if (pilihan == 1) {
                admins.lihatMenu(listRestaurant, listPesanan);
            } else {
                String enter = scanner.nextLine();
                admins.menuAdmin(listRestaurant, listPesanan);
            }
        } else {
            System.out.println("| " + "Menu untuk restaurant :  " + restaurant.getNamaRestaurant() + " |");
            System.out.println("| ID Menu \t\t Nama Menu \t\t Tipe Menu \t\t Harga");
            for (Menu item : menuRestaurant) {
                System.out.println("| " + item.idMenu + " \t\t\t " + item.namaMenu + " \t\t\t " + item.tipeMenu + " \t\t " + item.price + " |");
            }
            System.out.println("Tekan 1 untuk melihat lagi atau tekan 2 untuk kembali ke menu |");
            System.out.print("Pilih : ");
            int pilihan = scanner.nextInt();
            if (pilihan == 1) {
                admins.lihatMenu(listRestaurant, listPesanan);
            } else {
                String enter = scanner.nextLine();
                menuAdmin(listRestaurant, listPesanan);
            }
        }
    }


    public static void hapusRestaurant(ArrayList <Restaurant> listRestaurant, ArrayList <Pesanan> listPesanan) {
        Scanner scanner = new Scanner(System.in);
        Admin admins = new Admin();
        System.out.println("=======================================");
        System.out.println("|  Selamat Datang di Hapus Restaurant |");
        System.out.println("=======================================");
        if (listRestaurant.isEmpty()) {
            System.out.println("Restaurant kosong.");
            System.out.println("Silahkan tambahkan terlebih dahulu");
            System.out.print("Tekan enter untuk kembali ke menu");
            String enter = scanner.nextLine();
            admins.menuAdmin(listRestaurant, listPesanan);
        }
        System.out.println("Pilih restaurant yang akan dihapus");
        for (int i = 0; i < listRestaurant.size(); i++) {
            System.out.println((i + 1) + ". " + listRestaurant.get(i).getNamaRestaurant());
        }
        System.out.print("Pilih : ");
        int pilih = scanner.nextInt();
        listRestaurant.remove(pilih - 1);
        System.out.println("| Restaurant telah dihapus |");
        System.out.println("| Tekan 1 untuk menghapus lagi atau tekan 2 untuk kembali ke menu |");
        System.out.print("Pilih : ");
        int pilihan = scanner.nextInt();
        if (pilihan == 1) {
            admins.hapusRestaurant(listRestaurant, listPesanan);
        } else {
            String enter = scanner.nextLine();
            menuAdmin(listRestaurant, listPesanan);
        }
    }

}