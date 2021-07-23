package controllers;

import models.FeedBack;
import models.Order;
import models.Restaurant;
import models.User;
import services.FeedBackService;
import services.OrderService;
import services.RestaurantService;
import services.UserService;

import java.util.Set;

public class FoodOrderingController {
    UserService userService;
    RestaurantService restaurantService;
    OrderService orderService;
    FeedBackService feedBackService;
    User loginUser;
    public FoodOrderingController(UserService userService, RestaurantService restaurantService, OrderService orderService, FeedBackService feedBackService){
        this.userService = userService;
        this.restaurantService = restaurantService;
        this.orderService = orderService;
        this.feedBackService = feedBackService;
    }

    public User registerUser(String name, User.Gender gender, String phNo, String pinCode){
        try {
            User user = userService.addUser(name, gender, phNo, pinCode);
            return user;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public void loginUser(String userName){
        this.loginUser = userService.getUser(userName);
    }
    public void checkLoginUser() throws Exception{
        if(loginUser == null)
            throw new Exception("no logged in user");
    }
    public Restaurant registerRestaurant(String restaurantName, Set<String> pincodes, String dish, Double price, int initialQty){
        if(loginUser == null)
            return null;
        Restaurant restaurant = null;
        try{
            restaurant = restaurantService.addRestaurant(restaurantName, pincodes, dish, price, initialQty, loginUser);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return restaurant;
    }
    public void updateQuantity(String restaurantName, int qtyToAdd){
        if(loginUser == null)
            return;
        try{
            restaurantService.updateQty(restaurantName, qtyToAdd);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public FeedBack rateRestaurant(String restaurantName, int rating, String comment){
        if(loginUser == null)
            return null;
        try {
            return feedBackService.rateRestaurant(restaurantName, loginUser.getName(), rating, comment);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    public Set<Restaurant> showRestaurantsByDish(String dish){
        if(loginUser == null)
            return null;
        Set<Restaurant> restaurants = restaurantService.getRestaurants(dish, loginUser);
        System.out.println("----------------------------------showing restaurants------------------------");
        for(Restaurant restaurant : restaurants)
            System.out.println(restaurant);
        return restaurants;
    }

    public Order placeOrder(String restaurantName, int qty){
        if(loginUser == null)
            return null;
        try {
            return orderService.placeOrder(restaurantName, loginUser.getName(), qty);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
