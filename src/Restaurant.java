import java.util.ArrayList;

public class Restaurant {
    private int idRestaurant;
    private String namaRestaurant;
    private String address;
    private ArrayList<Menu> menuList;

    public int getIdRestaurant() {
        return idRestaurant;
    }

    public String getNamaRestaurant() {
        return namaRestaurant;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<Menu> getMenuList() {
        return menuList;
    }

    public Restaurant(int restaurantId, String restaurantName, String address) {
        this.idRestaurant = restaurantId;
        this.namaRestaurant = restaurantName;
        this.address = address;
        this.menuList = new ArrayList<>();
    }
}

