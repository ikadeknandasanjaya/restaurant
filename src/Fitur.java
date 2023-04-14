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
//    public static void lihatRestaurant(ArrayList<Restaurant> listRestaurant, ArrayList<Pesanan> listPesanan) {
//        System.out.println("Restaurant List:");
//        System.out.println("Restaurant ID\t\tRestaurant Name\t\tAddress");
//        for (Restaurant restaurant : listRestaurant) {
//            System.out.println(restaurant.idRestaurant + "\t\t" + restaurant.namaRestaurant + "\t\t" + restaurant.address);
//        }
//    }

    public static Restaurant cariRestaurantDenganID(int restaurantId, ArrayList<Restaurant> listRestaurant, ArrayList<Pesanan> listPesanan) {
        for (Restaurant restaurant : listRestaurant) {
            if (restaurant.idRestaurant == restaurantId) {
                return restaurant;
            }
        }
        return null;
    }

    public static Menu cariMenuDenganID(Restaurant restaurant, int menuId, ArrayList<Restaurant> listRestaurant, ArrayList<Pesanan> listPesanan) {
        for (Menu menu : restaurant.menuList) {
            if (menu.idMenu == menuId) {
                return menu;
            }
        }
        return null;
    }
}
