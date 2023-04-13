import java.util.ArrayList;

public class Restaurant {

    int id;

    private String name;
    public String address;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<Menu> getMenuList() {
        return menuList;
    }

    ArrayList<Menu> menuList = new ArrayList<>();


    public Restaurant(String name, String address, int id) {
        this.name = name;
        this.address = address;
        this.id = id;
        menuList = new ArrayList<>();
    }

    public void tambahMenu(Menu menu) {
        menuList.add(menu);
    }
}

