import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Login logins = new Login();
        ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();
        ArrayList<Pesanan> listPesanan = new ArrayList<>();
        logins.loginSystem(restaurantList, listPesanan);
        }
    }
