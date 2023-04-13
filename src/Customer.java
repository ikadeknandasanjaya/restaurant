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
        ArrayList<Pesanan> listPesanan = new ArrayList<>();
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
                    buatPesanan(listRestaurant, listPesanan);
                    break;
                case 4:
                    lihatPesanan(listRestaurant, listPesanan);
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
        ArrayList<Menu> menuList = restaurant.getMenuList();
        if (menuList.isEmpty()) {
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
            for (Menu item : menuList) {
                System.out.println("| " + item.getNamaMenu() + " " + item.getHargaMenu() + " |");
            }
            System.out.println("Masukan Pesanan Kamu");
            System.out.println("Restaurant : ");
            System.out.println("Menu : ");
            System.out.println("Jarak kelokasi antar");
            System.out.println("Total harga");
        }
    }

    public static void buatPesanan(ArrayList<Restaurant> listRestaurant, ArrayList<Pesanan> listPesanan) {
        for (int i = 0; i < listRestaurant.size(); i++) {
            System.out.println("| " + (i + 1) + ".  Nama Restaurant : " + listRestaurant.get(i).getName() + " | Alamat Restaurant : " + listRestaurant.get(i).getAddress() + " |");
        }
        System.out.println("Pilih restaurant : ");
        Scanner scanner = new Scanner(System.in);
        int restaurantId = scanner.nextInt();
        Restaurant restaurant = null;
        for (Restaurant r : listRestaurant) {
            if (r.id == restaurantId) {
                restaurant = r;
                break;
            }
        }
        if (restaurant == null) {
            System.out.println("Restaurant tidak ditemukan.");
        }
        ArrayList<Menu> menuList = restaurant.getMenuList();
        if (menuList.isEmpty()) {
            System.out.println("Menu tidak ditemukan.");
        }
        System.out.println("Beberapa menu untuk " + restaurant.getName() + ":");
        for (Menu menu : menuList) {
            System.out.println(menu.id + ". " + menu.getNamaMenu() + " - $" + menu.getHargaMenu());
        }
        System.out.println("Masukan menu yang akan dipesan :");
        int menuId = scanner.nextInt();
        Menu menu = null;
        for (Menu m : menuList) {
            if (m.id == menuId) {
                menu = m;
                break;
            }
        }
        if (menu == null) {
            System.out.println("Menu tidak ditemukan.");
        }
        System.out.println("Masukan jumlah pesan : ");
        int quantity = scanner.nextInt();
        double totalPrice = menu.getHargaMenu() * quantity;
        System.out.println("Masukan jarak rumah : ");
        double jarakRumah = scanner.nextDouble();
        totalPrice += jarakRumah * 2;
        Pesanan order = new Pesanan(restaurantId, menuId, quantity, totalPrice);
        listPesanan.add(order);
        System.out.println("Order sudah berhasil dengan jumlah biaya " + totalPrice);
    }


    public static void lihatPesanan(ArrayList<Restaurant> listRestaurant, ArrayList<Pesanan> listPesanan) {
        if (listPesanan.isEmpty()) {
            System.out.println("Pesanan tidak ditemukan.");
        }
        System.out.println("Order history:");
        for (Pesanan order : listPesanan) {
            Restaurant restaurant = null;
            for (Restaurant r : listRestaurant) {
                if (r.id == order.getRestaurantId()) {
                    restaurant = r;
                    break;
                }
            }
            if (restaurant == null) {
                System.out.println("Restaurant tidak ditemukan.");
                continue;
            }
            Menu menu = null;
            for (Menu m : restaurant.getMenuList()) {
                if (m.id == order.getMenuId()) {
                    menu = m;
                    break;
                }
            }
            if (menu == null) {
                System.out.println("Menu tidak ditemukan.");
                continue;
            }
            System.out.println("Pesanan untuk " + restaurant.getName() + ":");
            System.out.println(menu.getNamaMenu() + " dengan harga " + menu.getHargaMenu() + " x " + order.getQuantity() + " =" + order.getTotalPrice());
        }
    }
}