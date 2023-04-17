
public class Pesanan {
    private int idRestaurant;
    private int idMenu;
    private int jumlah;
    private int jarak;
    private double totalHarga;

    public int getIdRestaurant() {
        return idRestaurant;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getJarak() {
        return jarak;
    }

    public double getTotalharga() {
        return totalHarga;
    }

    public Pesanan(int idRestaurant, int idMenu, int jumlah, int jarak, double totalharga) {
        this.idRestaurant = idRestaurant;
        this.idMenu = idMenu;
        this.jumlah = jumlah;
        this.totalHarga = totalharga;
        this.jarak = jarak;
    }
}

