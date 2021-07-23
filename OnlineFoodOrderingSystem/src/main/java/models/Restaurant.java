package models;

import java.util.Set;

public class Restaurant {
    String name, id;
    Set<String> serviceablePinCodes;
    String dish;
    Double price;
    int qty;

    public int getUserQty() {
        return userQty;
    }

    public void setUserQty(int userQty) {
        this.userQty = userQty;
    }

    int userQty;
    User owner;
    int totalRating;
    int noOfFeedbacks;

    public void setTotalRating(int totalRating) {
        this.totalRating = totalRating;
    }

    public int getNoOfFeedbacks() {
        return noOfFeedbacks;
    }

    public void setNoOfFeedbacks(int noOfFeedbacks) {
        this.noOfFeedbacks = noOfFeedbacks;
    }

    public Restaurant(String name, Set<String> serviceablePinCodes, String dish, Double price, int initialQty, User owner) {
        this.name = name;
        this.serviceablePinCodes = serviceablePinCodes;
        this.dish = dish;
        this.price = price;
        this.qty = initialQty;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<String> getServiceablePinCodes() {
        return serviceablePinCodes;
    }

    public void setServiceablePinCodes(Set<String> serviceablePinCodes) {
        this.serviceablePinCodes = serviceablePinCodes;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", serviceablePinCodes=" + serviceablePinCodes +
                ", dish='" + dish + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", userQty=" + userQty +
                ", owner=" + owner +
                ", totalRating=" + totalRating +
                ", noOfFeedbacks=" + noOfFeedbacks +
                '}';
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public int getTotalRating() {
        return totalRating;
    }
}
