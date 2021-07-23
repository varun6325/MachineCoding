package services;

import exceptions.DoesNotExistException;
import models.Order;
import models.Restaurant;
import models.User;

import java.util.HashMap;
import java.util.Map;

public class OrderService {
    public static OrderService orderService;
    Map<String, Order> orders = new HashMap<>();
    Map<String, Order> userToOrderMapping = new HashMap();
    private OrderService(){}
    public static OrderService getInstance(){
        if(orderService == null)
            orderService = new OrderService();
        return orderService;
    }
    public Order placeOrder(String restaurantName, String userName, int qty) throws DoesNotExistException, Exception{
        Restaurant restaurant = RestaurantService.getInstance().getRestaurant(restaurantName);
        if(restaurant == null)
            throw new DoesNotExistException("no restaurant exists with name " + restaurantName);
        User user = UserService.getInstance().getUser(userName);
        if(user == null)
            throw new DoesNotExistException("no user exists with name " + userName);
        if(restaurant.getQty()-restaurant.getUserQty() >= qty){
            Order order = new Order(restaurant, user, qty);
            restaurant.setUserQty(restaurant.getUserQty() + qty);
            orders.put(order.getId(), order);
            userToOrderMapping.put(userName, order);
            return order;
        }else
            throw new Exception("no of required qty are greater than what is present in the restaurant");

    }

}
