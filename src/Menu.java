public class Menu {
    private int idMenu;
    private String namaMenu;

    private String tipeMenu;
    private double price;

    public int getIdMenu() {
        return idMenu;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public String getTipeMenu() {
        return tipeMenu;
    }

    public double getPrice() {
        return price;
    }

    public Menu(int idMenu, String namaMenu, String tipeMenu, double price) {
        this.idMenu = idMenu;
        this.namaMenu = namaMenu;
        this.tipeMenu = tipeMenu;
        this.price = price;
    }
}