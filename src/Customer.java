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
            Fitur fiturs = new Fitur();
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
            int pilihan = fiturs.hanyaInteger(scanner, "");
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
        Fitur fiturs = new Fitur();
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
            int pilihan = fiturs.hanyaInteger(scanner, "");
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
        Fitur fiturs = new Fitur();
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
        System.out.print("Pilihan : ");
        int pilihRestaurant = fiturs.hanyaInteger(scanner, "");
        scanner.nextLine();

        Restaurant restaurant = listRestaurant.get(pilihRestaurant);
        ArrayList<Menu> menuList = restaurant.getMenuList();
        if (menuList.isEmpty()) {
            System.out.println("Tidak terdapat menu untuk restaurant " + restaurant.getNamaRestaurant());
            System.out.println("Tekan 1 untuk melihat lagi atau tekan 2 untuk kembali ke menu |");
            System.out.print("Pilih : ");
            int pilihan = fiturs.hanyaInteger(scanner, "");
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
                System.out.println("| " + item.getIdMenu() + " \t\t\t " + item.getNamaMenu() + " \t\t\t " + item.getTipeMenu() + " \t\t\t " + item.getPrice() + " |");
            }
        }
        System.out.println("Tekan 1 untuk melihat lagi atau tekan 2 untuk kembali ke menu |");
        System.out.print("Pilih : ");
        int pilihan = fiturs.hanyaInteger(scanner, "");
        if (pilihan == 1) {
            customers.lihatMenu(listRestaurant, listPesanan);
        } else {
            scanner.nextLine();
            customers.menuCustomer(listRestaurant, listPesanan);
        }
    }

    public static void buatPesanan(ArrayList<Restaurant> listRestaurant, ArrayList<Pesanan> listPesanan) {
        Customer customers = new Customer();
        Fitur fiturs = new Fitur();
        for (int i = 0; i < listRestaurant.size(); i++) {
            System.out.println("| " + (i + 1) + ".  Nama Restaurant : " + listRestaurant.get(i).getNamaRestaurant() + " | Alamat Restaurant : " + listRestaurant.get(i).getAddress() + " |");
        }
        System.out.print("Pilih restaurant : ");
        Scanner scanner = new Scanner(System.in);
        int pilihRestaurant = fiturs.hanyaInteger(scanner, "");
        Restaurant restaurant = fiturs.cariRestaurantDenganID(pilihRestaurant, listRestaurant, listPesanan);
        if (restaurant == null) {
            System.out.println("Restaurant not found. Please try again.");
            return;
        }
        System.out.println("| Menu dari restaurant " + restaurant.getNamaRestaurant() + ":" + "  |");
        System.out.println("| ID Menu\t\tNama Menu\t\tTipe Menu\t\tHarga Menu |");
        for (Menu menu : restaurant.getMenuList()) {
            System.out.println("| "+ menu.getIdMenu() + "\t\t\t\t" + menu.getNamaMenu() + "\t\t\t\t" + menu.getTipeMenu() + "\t\t\t\t" + menu.getPrice() + " |");
        }
        System.out.print("Masukan menu yang akan dipesan :");
        int idMenu = fiturs.hanyaInteger(scanner, "");

        Menu menu = fiturs.cariMenuDenganID(restaurant, idMenu, listRestaurant, listPesanan);

        if (menu == null) {
            System.out.println("Menu tidak ditemukan.");
        }
        System.out.print("Masukan jumlah pesan : ");
        int jumlah = fiturs.hanyaInteger(scanner, "");
        System.out.print("Masukan jarak rumah (dalam KM) : ");
        int jarakRumah = fiturs.hanyaInteger(scanner, "");
        double total = menu.getPrice() * jumlah;
        total = total * jarakRumah * 0.75;
        Pesanan order = new Pesanan(pilihRestaurant, idMenu, jumlah, jarakRumah, total);
        listPesanan.add(order);
        System.out.println("Order sudah berhasil dengan jumlah biaya " + total);
        System.out.println("Tekan 1 untuk memesan lagi atau tekan 2 untuk kembali ke menu |");
        System.out.print("Pilih : ");
        int pilihan = fiturs.hanyaInteger(scanner, "");
        if (pilihan == 1) {
            customers.buatPesanan(listRestaurant, listPesanan);
        } else {
            scanner.nextLine();
            customers.menuCustomer(listRestaurant, listPesanan);
        }
    }


    public static void lihatPesanan(ArrayList<Restaurant> listRestaurant, ArrayList<Pesanan> listPesanan) {
        Customer customers = new Customer();
        Fitur fiturs = new Fitur();
        Scanner scanner = new Scanner(System.in);
        System.out.println("| Pilih restaurant untuk dilihat pesanannya :  |");
        for (int i = 0; i < listRestaurant.size(); i++) {
            System.out.println("| " + (i + 1) + ".  Nama Restaurant : " + listRestaurant.get(i).getNamaRestaurant() + " | Alamat Restaurant : " + listRestaurant.get(i).getAddress() + " |");
        }
        if (listPesanan.isEmpty()) {
            System.out.println("Pesanan tidak ditemukan.");
            System.out.println("Tekan 1 untuk melihat lagi atau tekan 2 untuk kembali ke menu |");
            System.out.print("Pilih : ");
            int pilihan = fiturs.hanyaInteger(scanner, "");
            if (pilihan == 1) {
                customers.lihatPesanan(listRestaurant, listPesanan);
            } else {
                scanner.nextLine();
                customers.menuCustomer(listRestaurant, listPesanan);
            }
        }
        System.out.print("Pilih : ");
        int pilihRestaurant = fiturs.hanyaInteger(scanner, "");
        scanner.nextLine();
        Restaurant restaurant = fiturs.cariRestaurantDenganID(pilihRestaurant, listRestaurant, listPesanan);

        if (restaurant == null) {
            System.out.println("Restaurant tidak ditemukan.");
            System.out.println("Tekan 1 untuk melihat lagi atau tekan 2\3 untuk kembali ke menu |");
            System.out.print("Pilih : ");
            int pilihan = fiturs.hanyaInteger(scanner, "");
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
            if (order.getIdRestaurant() == pilihRestaurant) {
                String namaMenu = fiturs.cariMenuDenganID(restaurant, order.getIdMenu(), listRestaurant, listPesanan).getNamaMenu();
                System.out.println("| "+ pilihRestaurant + "\t\t\t\t\t\t" + order.getIdMenu() + "\t\t\t\t\t"  + namaMenu + "\t\t\t\t\t" + order.getJumlah() + "\t\t\t\t\t" + order.getJarak() + "\t\t\t\t\t" + order.getTotalharga());
                for (int i = 0; i < restaurant.getMenuList().size(); i++) {
                    totalLast =  totalLast + order.getTotalharga();
                }
            }
        }
        System.out.println("Total yang harus kamu bayarkan ke restaurant " + restaurant.getNamaRestaurant() + " adalah : " + totalLast );
        System.out.println("Tekan 1 untuk melihat lagi atau tekan 2 untuk kembali ke menu |");
        System.out.print("Pilih : ");
        int pilihan = fiturs.hanyaInteger(scanner, "");
        if (pilihan == 1) {
            customers.lihatPesanan(listRestaurant, listPesanan);
        } else {
            scanner.nextLine();
            customers.menuCustomer(listRestaurant, listPesanan);
        }
    }
}

