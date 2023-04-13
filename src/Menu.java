public class Menu {
    int id;

    public int getId() {
        return id;
    }

    String namaMenu;
    double hargaMenu;

    public Menu(int idMenu, String namaMenu, double hargaMenu) {
        this.id = idMenu;
        this.namaMenu = namaMenu;
        this.hargaMenu = hargaMenu;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public double getHargaMenu() {
        return hargaMenu;
    }
}
