import com.sun.org.apache.xpath.internal.operations.Or;
import controllers.FoodOrderingController;
import models.FeedBack;
import models.Order;
import models.Restaurant;
import models.User;
import services.FeedBackService;
import services.OrderService;
import services.RestaurantService;
import services.UserService;

import java.util.HashSet;
import java.util.Set;

public class Driver {
    public static void main(String[] args){
        FoodOrderingController foodOrderingController = new FoodOrderingController(UserService.getInstance(),
                RestaurantService.getInstance(), OrderService.getInstance(), FeedBackService.getInstance());
        User user1 = foodOrderingController.registerUser("varun", User.Gender.MALE, "98999", "110034");
        User user2 = foodOrderingController.registerUser("bharat", User.Gender.MALE, "98999", "110030");
        User user3 = foodOrderingController.registerUser("jatin", User.Gender.MALE, "98999", "110034");
        User user4 = foodOrderingController.registerUser("charu", User.Gender.FEMALE, "98999", "110030");
        User user5 = foodOrderingController.registerUser("astha", User.Gender.FEMALE, "98999", "110000");
        System.out.println(user1);
        Set<String> pinCodes1 = new HashSet();
        pinCodes1.add("110034");
        pinCodes1.add("110035");
        pinCodes1.add("110036");
        Set<String> pinCodes2 = new HashSet();
        pinCodes2.add("110030");
        pinCodes2.add("110034");

        //Restaurant restaurant = foodOrderingController.registerRestaurant("testRestaurant", pinCodes,"dosa", 100.0 , 10);
        foodOrderingController.loginUser("varun");
        Restaurant restaurant1 = foodOrderingController.registerRestaurant("testRestaurant1", pinCodes1,"dosa", 500.0 , 10);
        Restaurant restaurant2 = foodOrderingController.registerRestaurant("testRestaurant2", pinCodes1,"idli", 100.0 , 20);
        Restaurant restaurant3 = foodOrderingController.registerRestaurant("testRestaurant3", pinCodes1,"dosa", 300.0 , 10);
        Restaurant restaurant4 = foodOrderingController.registerRestaurant("testRestaurant4", pinCodes1,"dosa", 100.0 , 10);
        Restaurant restaurant5 = foodOrderingController.registerRestaurant("testRestaurant5", pinCodes2,"idli", 100.0 , 20);
        Restaurant restaurant6 = foodOrderingController.registerRestaurant("testRestaurant6", pinCodes2,"idli", 100.0 , 10);
        Restaurant restaurant7 = foodOrderingController.registerRestaurant("testRestaurant6", pinCodes2,"dosa", 100.0 , 10);
        System.out.println(restaurant1);
        foodOrderingController.updateQuantity(restaurant1.getName(), 10);
        System.out.println(restaurant1);

        FeedBack feedBack = foodOrderingController.rateRestaurant(restaurant1.getName(), 4, "Average");
        System.out.println(feedBack);
        feedBack = foodOrderingController.rateRestaurant(restaurant3.getName(), 4, "Average");
        feedBack = foodOrderingController.rateRestaurant(restaurant4.getName(), 1, "Average");
        feedBack = foodOrderingController.rateRestaurant(restaurant2.getName(), 4, "Average");
        feedBack = foodOrderingController.rateRestaurant(restaurant5.getName(), 3, "Average");
        feedBack = foodOrderingController.rateRestaurant(restaurant5.getName(), 5, "Average");
        feedBack = foodOrderingController.rateRestaurant(restaurant5.getName(), 5, "Average");

        //foodOrderingController.showRestaurantsByDish("dosa");
        //foodOrderingController.showRestaurantsByDish("idli");
        Order order = foodOrderingController.placeOrder(restaurant1.getName(), 10);
        System.out.println(order);
        foodOrderingController.showRestaurantsByDish("dosa");
        order = foodOrderingController.placeOrder(restaurant1.getName(), 10);
        foodOrderingController.showRestaurantsByDish("dosa");


    }
}
