public class Restaurant {
    private String namaRestaurant;

    private String alamatRestaurant;

    public void setNamaRestaurant(String namaRestaurant) {
        this.namaRestaurant = namaRestaurant;
    }

    public void setAlamatRestaurant(String alamatRestaurant) {
        this.alamatRestaurant = alamatRestaurant;
    }

    public String getNamaRestaurant() {
        return namaRestaurant;
    }

    public String getAlamatRestaurant() {
        return alamatRestaurant;
    }

    public Restaurant(String namaRestaurant, String alamatRestaurant) {
        this.namaRestaurant = namaRestaurant;
        this.alamatRestaurant = alamatRestaurant;
    }
}
