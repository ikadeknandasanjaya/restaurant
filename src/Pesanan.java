import java.util.ArrayList;

public class Pesanan {
    int idRestaurant;
    int idMenu;
    int jumlah;
    int jarak;
    double totalharga;

    public Pesanan(int idRestaurant, int idMenu, int jumlah, int jarak, double totalharga) {
        this.idRestaurant = idRestaurant;
        this.idMenu = idMenu;
        this.jumlah = jumlah;
        this.totalharga = totalharga;
        this.jarak = jarak;
    }
}

