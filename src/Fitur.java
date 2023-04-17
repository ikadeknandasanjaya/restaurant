import java.util.ArrayList;
import java.util.Scanner;

public class Fitur {
    public int hanyaInteger(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Input salah! tidak boleh memasukan selain angka");
            scanner.next();
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }
    public static String hanyaString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        while (input.isEmpty()) {
            System.out.println("Input salah! tidak boleh memasukan kosong");
            System.out.print(prompt);
            input = scanner.nextLine();
        }
        return input;
    }

    public static Restaurant cariRestaurantDenganID(int restaurantId, ArrayList<Restaurant> listRestaurant, ArrayList<Pesanan> listPesanan) {
        for (Restaurant restaurant : listRestaurant) {
            if (restaurant.getIdRestaurant() == restaurantId) {
                return restaurant;
            }
        }
        return null;
    }

    public static Menu cariMenuDenganID(Restaurant restaurant, int menuId, ArrayList<Restaurant> listRestaurant, ArrayList<Pesanan> listPesanan) {
        for (Menu menu : restaurant.getMenuList()) {
            if (menu.idMenu == menuId) {
                return menu;
            }
        }
        return null;
    }
}

