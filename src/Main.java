import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Admin admins = new Admin();
        Customer customers = new Customer();
        Login logins = new Login();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();

        logins.loginSystem(restaurantList);
        }
//        Package Concept
//        Pengguna
//        Menu
//        tugas.pbo.restaurant.application.App
//        Signin
    }
