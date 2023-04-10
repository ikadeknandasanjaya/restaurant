import java.util.Scanner;

public class Customer {
    private String username = "customer";
    private String password = "customer";
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void menuCustomer() {
        while (true) {
            System.out.println("Selamat datang Customer!");
            System.out.println("Menu Customer");
            System.out.println("1. Buat Pesanan");
            System.out.println("2. Lihat Pesanan");
            System.out.println("3. Kembali Ke Login");
            System.out.print("Masukan Pilihan : ");
            Scanner scanner = new Scanner(System.in);
            int pilihan = scanner.nextInt();
            Login login = new Login();
            switch (pilihan) {

                case 1:
                    buatPesanan();
                    break;
                case 2:
                    lihatPesanan();
                    break;
                case 3:
                    login.loginSystem();
                    break;
                default:
                    System.out.println("Pilihan salah, coba ulangi.");
                    menuCustomer();
            }
        }
    }

    private void buatPesanan() {
    }

    private void lihatPesanan() {

    }

}
