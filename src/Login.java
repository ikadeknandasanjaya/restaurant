import java.util.Scanner;

public class Login {
    public String username;

    public String password;

    public void loginSystem() {
        Admin admin = new Admin();
        Customer customer = new Customer();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukan username : ");
        username = scanner.nextLine();
        System.out.print("Masukan password : ");
        password = scanner.nextLine();

        if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
            System.out.println("Login berhasil sebagai admin.");
            admin.menuAdmin();
        } else if (username.equals(customer.getUsername()) && password.equals(customer.getPassword())) {
            customer.menuCustomer();
        } else {
            System.out.println("Username dan password tidak sesuai dengan database kami.");
            System.out.println("Silahkan ulangi.");
            loginSystem();
        }
    }
}
