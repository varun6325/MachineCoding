package models;

public class FeedBack {
    Restaurant restaurant;
    User user;
    String comment;
    int rating;

    @Override
    public String toString() {
        return "FeedBack{" +
                "restaurant=" + restaurant +
                ", user=" + user +
                ", comment='" + comment + '\'' +
                ", rating=" + rating +
                '}';
    }

    public FeedBack(Restaurant restaurant, User user, String comment, int rating) {
        this.restaurant = restaurant;
        this.user = user;
        this.comment = comment;
        this.rating = rating;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
