package services;

import exceptions.AlreadyExistsException;
import models.Restaurant;
import models.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    Map<String, User> users = new HashMap<>();
    int count = 0;
    static UserService userService;
    private UserService(){}
    public static UserService getInstance(){
        if(userService == null)
            userService = new UserService();
        return userService;
    }


    public User addUser(String name, User.Gender gender, String phNo, String pinCode) throws AlreadyExistsException{
        if(users.containsKey(name))
            throw new AlreadyExistsException("User already exists");
        User user = new User(name, gender, phNo, pinCode);
        count++;
        user.setId("User-"+count);
        users.put(name, user);
        return user;
    }
    public User getUser(String name){
        return users.get(name);
    }
    public boolean isOwner(String name, String restaurantName){
        Restaurant restaurant = RestaurantService.getInstance().getRestaurant(restaurantName);
        if(users.containsKey(name) && restaurant != null){
            if(users.get(name).getId() == restaurant.getOwner().getId())
                return true;
            return false;
        }
        return false;
    }
}
