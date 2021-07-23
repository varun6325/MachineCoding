package models;

public class Order {
    Restaurant restaurant;
    User user;
    int qty;
    String id;
    int count = 0;

    public Order(Restaurant restaurant, User user, int qty) {
        this.restaurant = restaurant;
        this.user = user;
        this.qty = qty;
        count++;
        id = "Order-"+count;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "restaurant=" + restaurant +
                ", user=" + user +
                ", qty=" + qty +
                ", id='" + id + '\'' +
                ", count=" + count +
                '}';
    }
}
