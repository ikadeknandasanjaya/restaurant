
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


    public static void loginAdmin(ArrayList<Restaurant> listRestaurant) {
        Admin admins = new Admin();
        Fitur fiturs = new Fitur();
        System.out.println("=======================================");
        System.out.println("|    Selamat Datang di Login Admin    |");
        System.out.println("=======================================");
        Scanner scanner = new Scanner(System.in);
        String username = fiturs.readString(scanner, "| Masukan username : ");
        String password = fiturs.readString(scanner, "| Masukan password : ");
        System.out.println("=======================================");

        if (username.equals(admins.getUsername()) && password.equals(admins.getPassword())) {
            admins.menuAdmin(listRestaurant);
        } else {
            System.out.println("Username dan password tidak sesuai dengan database kami.");
            System.out.println("Silahkan ulangi.");
            admins.loginAdmin(listRestaurant);
        }
    }


    public static void menuAdmin(ArrayList<Restaurant> listRestaurant) {
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
                    lihatRestaurant(listRestaurant);
                    break;
                case 2:
                    tambahRestaurant(listRestaurant);
                    break;
                case 3:
                    hapusRestaurant(listRestaurant);
                    break;
                case 4:
                    tambahMenu(listRestaurant);
                case 5:
                    lihatMenu(listRestaurant);
                case 6:
                    logins.loginSystem(listRestaurant);
                default:
                    System.out.println("Pilihan Salah!");
                    menuAdmin(listRestaurant);
            }
        }
    }

    public static void lihatRestaurant(ArrayList<Restaurant> listRestaurant) {
        if (listRestaurant.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
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
            Scanner scanner = new Scanner(System.in);
            Admin admins = new Admin();
            System.out.println("| Tekan 1 untuk melihat lagi atau tekan 2 untuk kembali ke menu |");
            System.out.print("Pilih : ");
            int pilihan = scanner.nextInt();
            if (pilihan == 1) {
                admins.lihatRestaurant(listRestaurant);
            } else {
                String enter = scanner.nextLine();
                menuAdmin(listRestaurant);
            }
        }
    }

    public static void tambahRestaurant(ArrayList<Restaurant> listRestaurant) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=======================================");
        System.out.println("|       Menu Tambah Restaurant         |");
        System.out.println("=======================================");
        System.out.print("Masukan nama restaurant : ");
        String name = scanner.nextLine();
        System.out.print("Masukan alamat restaurant : ");
        String address = scanner.nextLine();
        Restaurant restaurantBaru = new Restaurant(name, address);
        listRestaurant.add(restaurantBaru);
        System.out.println("| Restaurant berhasil ditambahkan |");
        Admin admins = new Admin();
        System.out.println("| Tekan 1 untuk menambah lagi atau tekan 2 untuk kembali ke menu |");
        System.out.print("Pilih : ");
        int pilihan = scanner.nextInt();
        if (pilihan == 1) {
            admins.tambahRestaurant(listRestaurant);
        } else {
            String enter = scanner.nextLine();
            menuAdmin(listRestaurant);
        }
    }

    public static void tambahMenu(ArrayList<Restaurant> listRestaurant) {
        Scanner scanner = new Scanner(System.in);
        Admin admins = new Admin();
        System.out.println("=======================================");
        System.out.println("|          Menu Tambah Menu           |");
        System.out.println("=======================================");
        if (listRestaurant.isEmpty()) {
            System.out.println("Restaurant kosong.");
            System.out.println("Silahkan tambahkan terlebih dahulu");
            System.out.print("Tekan enter untuk kembali ke menu");
            String enter = scanner.nextLine();
            admins.menuAdmin(listRestaurant);
        }
        System.out.println("Pilih restaurant yang akan ditambahkan menu : ");
        for (int i = 0; i < listRestaurant.size(); i++) {
            System.out.println("| " + (i + 1) + ".  Nama Restaurant : " + listRestaurant.get(i).getName() + " | Alamat Restaurant : " + listRestaurant.get(i).getAddress() + " |");
        }
        System.out.print("Pilihan : ");
        int restaurantIndex = scanner.nextInt() - 1;
        Restaurant restaurant = listRestaurant.get(restaurantIndex);
        scanner.nextLine();

        System.out.println("Mau nambah apa ? : ");
        System.out.println("1. Makanan");
        System.out.println("2. Minuman");
        System.out.print("Masukan pilihan : ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();
        if (pilihan == 1) {
            System.out.print("Masukan makanan: ");
            String namaMenu = scanner.nextLine();
            System.out.print("Masukan harganya: ");
            double hargaMenu = scanner.nextDouble();
            scanner.nextLine();
            Menu menuBaru = new Menu(namaMenu, hargaMenu);
            restaurant.tambahMakanan(menuBaru);
            System.out.println("Menu makanan berhasil ditambahkan.");
            System.out.println("| Tekan 1 untuk menambahkan lagi atau tekan 2 untuk kembali ke menu |");
            System.out.print("Pilih : ");
            int pilihan3 = scanner.nextInt();
            if (pilihan3 == 1) {
                admins.tambahMenu(listRestaurant);
            } else {
                String enter = scanner.nextLine();
                menuAdmin(listRestaurant);
            }
        } else if (pilihan == 2) {
            System.out.print("Masukan minuman: ");
            String namaMenu = scanner.nextLine();
            System.out.print("Masukan harganya: ");
            double hargaMenu = scanner.nextDouble();
            Menu menuBaru = new Menu(namaMenu, hargaMenu);
            restaurant.tambahMinuman(menuBaru);
            System.out.println("Menu minuman berhasil ditambahkan.");
            System.out.println("| Tekan 1 untuk menambahkan lagi atau tekan 2 untuk kembali ke menu |");
            System.out.print("Pilih : ");
            int pilihan2 = scanner.nextInt();
            if (pilihan2 == 1) {
                admins.tambahMenu(listRestaurant);
            } else {
                String enter = scanner.nextLine();
                menuAdmin(listRestaurant);
            }
        }
    }

    public static void lihatMenu(ArrayList<Restaurant> listRestaurant) {
        Scanner scanner = new Scanner(System.in);
        Admin admins = new Admin();
        if (listRestaurant.isEmpty()) {
            System.out.println("Restaurant kosong.");
            System.out.println("Silahkan tambahkan terlebih dahulu");
            System.out.print("Tekan enter untuk kembali ke menu");
            String enter = scanner.nextLine();
            admins.menuAdmin(listRestaurant);
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
                admins.lihatMenu(listRestaurant);
            } else {
                String enter = scanner.nextLine();
                admins.menuAdmin(listRestaurant);
            }
        } else {
            System.out.println("| " + "Makanan :  " + restaurant.getName() + " |");
            for (Menu item : menuMakanan) {
                System.out.println("| " +item.getNamaMenu() + " " + item.getHargaMenu()+ " |");
            }
            System.out.println("| " +"Minuman :  " + restaurant.getName() + " |");
            for (Menu item : menuMinuman) {
                System.out.println("| " + item.getNamaMenu() + " " + item.getHargaMenu() + " |");
            }
            System.out.println("Tekan 1 untuk melihat lagi atau tekan 2 untuk kembali ke menu |");
            System.out.print("Pilih : ");
            int pilihan = scanner.nextInt();
            if (pilihan == 1) {
                admins.lihatMenu(listRestaurant);
            } else {
                String enter = scanner.nextLine();
                menuAdmin(listRestaurant);
            }
        }
    }


    public static void hapusRestaurant(ArrayList <Restaurant> listRestaurant) {
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
            admins.menuAdmin(listRestaurant);
        }
        System.out.println("Pilih restaurant yang akan dihapus");
        for (int i = 0; i < listRestaurant.size(); i++) {
            System.out.println((i + 1) + ". " + listRestaurant.get(i).getName());
        }
        System.out.print("Pilih : ");
        int pilih = scanner.nextInt();
        listRestaurant.remove(pilih - 1);
        System.out.println("| Restaurant telah dihapus |");
        System.out.println("| Tekan 1 untuk menghapus lagi atau tekan 2 untuk kembali ke menu |");
        System.out.print("Pilih : ");
        int pilihan = scanner.nextInt();
        if (pilihan == 1) {
            admins.hapusRestaurant(listRestaurant);
        } else {
            String enter = scanner.nextLine();
            menuAdmin(listRestaurant);
        }
    }

}
