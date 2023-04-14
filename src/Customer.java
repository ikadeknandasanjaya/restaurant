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

    public static void loginCustomer(ArrayList<Restaurant> listRestaurant, ArrayList<Pesanan> listPesanan) {
        Scanner scanner = new Scanner(System.in);
        Customer customers = new Customer();

        Fitur fiturs = new Fitur();
        String username = fiturs.hanyaString(scanner, "Masukan username : ");
        String password = fiturs.hanyaString(scanner, "Masukan password : ");
        if (username.equals(customers.getUsername()) && password.equals(customers.getPassword())) {
            customers.menuCustomer(listRestaurant, listPesanan);
        } else {
            System.out.println("Username dan password tidak sesuai dengan database kami.");
            System.out.println("Silahkan ulangi.");
            customers.loginCustomer(listRestaurant, listPesanan);
        }
    }

    public void menuCustomer(ArrayList<Restaurant> listRestaurant, ArrayList<Pesanan> listPesanan) {
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
                    lihatRestaurant(listRestaurant, listPesanan);
                    break;
                case 2:
                    lihatMenu(listRestaurant, listPesanan);
                    break;
                case 3:
                    buatPesanan(listRestaurant, listPesanan);
                    break;
                case 4:
                    lihatPesanan(listRestaurant, listPesanan);
                    break;
                case 5:
                    logins.loginSystem(listRestaurant, listPesanan);
                    break;
                default:
                    System.out.println("Pilihan salah, coba ulangi.");
                    menuCustomer(listRestaurant, listPesanan);
            }
        }
    }

    public static void lihatRestaurant(ArrayList<Restaurant> listRestaurant, ArrayList<Pesanan> listPesanan) {
        Scanner scanner = new Scanner(System.in);
        Customer customers = new Customer();
        if (listRestaurant.isEmpty()) {
            scanner = new Scanner(System.in);
            System.out.println("Restaurant kosong, silahkan tambah restauran");
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
            System.out.println("Tekan 1 untuk melihat lagi atau tekan 2 untuk kembali ke menu");
            System.out.print("Pilih : ");
            int pilihan = scanner.nextInt();
            if (pilihan == 1) {
                customers.lihatRestaurant(listRestaurant, listPesanan);
            } else {
                scanner.nextLine();
                customers.menuCustomer(listRestaurant, listPesanan);
            }
        }
    }

    public static void lihatMenu(ArrayList<Restaurant> listRestaurant, ArrayList<Pesanan> listPesanan) {
        Scanner scanner = new Scanner(System.in);
        Customer customers = new Customer();
        if (listRestaurant.isEmpty()) {
            System.out.println("Restaurant kosong.");
            System.out.println("Silahkan tambahkan terlebih dahulu");
            System.out.print("Tekan enter untuk kembali ke menu");
            scanner.nextLine();
            customers.menuCustomer(listRestaurant, listPesanan);
        }

        System.out.println("Pilih restaurant untuk dilihat menunya : ");
        for (int i = 0; i < listRestaurant.size(); i++) {
            System.out.println("| " + (i + 1) + ".  Nama Restaurant : " + listRestaurant.get(i).getNamaRestaurant() + " | Alamat Restaurant : " + listRestaurant.get(i).getAddress() + " |");
        }
        System.out.print("Pilihan: ");
        int restaurantIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        Restaurant restaurant = listRestaurant.get(restaurantIndex);
        ArrayList<Menu> menuList = restaurant.getMenuList();
        if (menuList.isEmpty()) {
            System.out.println("Tidak terdapat menu untuk restaurant " + restaurant.getNamaRestaurant());
            System.out.println("Tekan 1 untuk melihat lagi atau tekan 2 untuk kembali ke menu |");
            System.out.print("Pilih : ");
            int pilihan = scanner.nextInt();
            if (pilihan == 1) {
                customers.lihatMenu(listRestaurant, listPesanan);
            } else {
                scanner.nextLine();
                customers.menuCustomer(listRestaurant, listPesanan);
            }
        } else {
            System.out.println("| " + "Menu untuk restaurant :  " + restaurant.getNamaRestaurant() + " |");
            System.out.println("| ID Menu \t\t Nama Menu \t\t Tipe Menu \t\t Harga");
            for (Menu item : menuList) {
                System.out.println("| " + item.idMenu + " \t\t\t " + item.namaMenu + " \t\t\t " + item.tipeMenu + " \t\t\t " + item.price + " |");
            }
        }
        System.out.println("Tekan 1 untuk melihat lagi atau tekan 2 untuk kembali ke menu |");
        System.out.print("Pilih : ");
        int pilihan = scanner.nextInt();
        if (pilihan == 1) {
            customers.lihatMenu(listRestaurant, listPesanan);
        } else {
            scanner.nextLine();
            customers.menuCustomer(listRestaurant, listPesanan);
        }
    }

    public static void buatPesanan(ArrayList<Restaurant> listRestaurant, ArrayList<Pesanan> listPesanan) {
        Customer customers = new Customer();
        for (int i = 0; i < listRestaurant.size(); i++) {
            System.out.println("| " + (i + 1) + ".  Nama Restaurant : " + listRestaurant.get(i).getNamaRestaurant() + " | Alamat Restaurant : " + listRestaurant.get(i).getAddress() + " |");
        }
        System.out.print("Pilih restaurant : ");
        Scanner scanner = new Scanner(System.in);
        int restaurantId = scanner.nextInt();
        Fitur fiturs = new Fitur();
        Restaurant restaurant = fiturs.cariRestaurantDenganID(restaurantId, listRestaurant, listPesanan);
        if (restaurant == null) {
            System.out.println("Restaurant not found. Please try again.");
            return;
        }
        System.out.println("| Menu dari restaurant " + restaurant.getNamaRestaurant() + ":" + "  |");
        System.out.println("| ID Menu\t\tNama Menu\t\tTipe Menu\t\tHarga Menu |");
        for (Menu menu : restaurant.menuList) {
            System.out.println("| "+ menu.idMenu + "\t\t\t\t" + menu.namaMenu + "\t\t\t\t" + menu.tipeMenu + "\t\t\t\t" + menu.price + " |");
        }
        System.out.print("Masukan menu yang akan dipesan :");
        int menuId = scanner.nextInt();

        Menu menu = fiturs.cariMenuDenganID(restaurant, menuId, listRestaurant, listPesanan);

        if (menu == null) {
            System.out.println("Menu tidak ditemukan.");
        }
        System.out.print("Masukan jumlah pesan : ");
        int jumlah = scanner.nextInt();
        System.out.print("Masukan jarak rumah (dalam KM) : ");
        int jarakRumah = scanner.nextInt();
        double total = menu.price * jumlah;
        total = total * jarakRumah * 0.75;
        Pesanan order = new Pesanan(restaurantId, menuId, jumlah, jarakRumah, total);
        listPesanan.add(order);
        System.out.println("Order sudah berhasil dengan jumlah biaya " + total);
        System.out.println("Tekan 1 untuk memesan lagi atau tekan 2 untuk kembali ke menu |");
        System.out.print("Pilih : ");
        int pilihan = scanner.nextInt();
        if (pilihan == 1) {
            customers.buatPesanan(listRestaurant, listPesanan);
        } else {
            scanner.nextLine();
            customers.menuCustomer(listRestaurant, listPesanan);
        }
    }


    public static void lihatPesanan(ArrayList<Restaurant> listRestaurant, ArrayList<Pesanan> listPesanan) {
        Customer customers = new Customer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("| Pilih restaurant untuk dilihat pesanannya :  |");
        for (int i = 0; i < listRestaurant.size(); i++) {
            System.out.println("| " + (i + 1) + ".  Nama Restaurant : " + listRestaurant.get(i).getNamaRestaurant() + " | Alamat Restaurant : " + listRestaurant.get(i).getAddress() + " |");
        }
        if (listPesanan.isEmpty()) {
            System.out.println("Pesanan tidak ditemukan.");
            System.out.println("Tekan 1 untuk melihat lagi atau tekan 2 untuk kembali ke menu |");
            System.out.print("Pilih : ");
            int pilihan = scanner.nextInt();
            if (pilihan == 1) {
                customers.lihatPesanan(listRestaurant, listPesanan);
            } else {
                scanner.nextLine();
                customers.menuCustomer(listRestaurant, listPesanan);
            }
        }
        System.out.print("Pilih : ");
        int restaurantId = scanner.nextInt();
        scanner.nextLine();
        Fitur fiturs = new Fitur();
        Restaurant restaurant = fiturs.cariRestaurantDenganID(restaurantId, listRestaurant, listPesanan);

        if (restaurant == null) {
            System.out.println("Restaurant tidak ditemukan.");
            System.out.println("Tekan 1 untuk melihat lagi atau tekan 2 untuk kembali ke menu |");
            System.out.print("Pilih : ");
            int pilihan = scanner.nextInt();
            if (pilihan == 1) {
                customers.lihatPesanan(listRestaurant, listPesanan);
            } else {
                scanner.nextLine();
                customers.menuCustomer(listRestaurant, listPesanan);
            }
        }

        System.out.println("| Pesanan untuk restaurant " + restaurant.getNamaRestaurant() + " :  |");
        System.out.println("| ID Restaurant\t\tID menu\t\tNama menu\t\tJumlah pesanan\t\tJumlah menu\t\tJarak lokasi antar\t\tTotal harga");
        double totalLast = 0;
        for (Pesanan order : listPesanan) {
            if (order.idRestaurant== restaurantId) {
                String namaMenu = fiturs.cariMenuDenganID(restaurant, order.idMenu, listRestaurant, listPesanan).namaMenu;
                System.out.println("| "+ restaurantId + "\t\t\t\t\t\t" + order.idMenu + "\t\t\t\t\t"  + namaMenu + "\t\t\t\t\t" + order.jumlah + "\t\t\t\t\t" + order.jarak + "\t\t\t\t\t" + order.totalharga);
                for (int i = 0; i < restaurant.menuList.size(); i++) {
                    totalLast =  totalLast + order.totalharga;
                }
            }
        }
        System.out.println("Total yang harus kamu bayarkan ke restaurant " + restaurant.getNamaRestaurant() + " adalah : " + totalLast );
        System.out.println("Tekan 1 untuk melihat lagi atau tekan 2 untuk kembali ke menu |");
        System.out.print("Pilih : ");
        int pilihan = scanner.nextInt();
        if (pilihan == 1) {
            customers.lihatPesanan(listRestaurant, listPesanan);
        } else {
            scanner.nextLine();
            customers.menuCustomer(listRestaurant, listPesanan);
        }
    }
}

