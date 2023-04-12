import java.util.ArrayList;

public class Restaurant {

    private String name;
    public String address;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    ArrayList<Menu> makananList = new ArrayList<>();
    ArrayList<Menu> minumanList = new ArrayList<>();

    public ArrayList<Menu> getMakananList() {
        return makananList;
    }

    public ArrayList<Menu> getMinumanList() {
        return minumanList;
    }

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
        makananList = new ArrayList<>();
        minumanList = new ArrayList<>();
    }

    public void tambahMakanan(Menu menu) {
        makananList.add(menu);
    }
    public void tambahMinuman (Menu menu) {
        minumanList.add(menu);
    }
}

