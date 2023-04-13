public class Pesanan {
    int restaurantId;
    int menuId;
    int quantity;
    double totalPrice;

    public Pesanan(int restaurantId, int menuId, int quantity, double totalPrice) {
        this.restaurantId = restaurantId;
        this.menuId = menuId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public int getRestaurantId() {
        return this.restaurantId;
    }

    public int getMenuId() {
        return this.menuId;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }
}

