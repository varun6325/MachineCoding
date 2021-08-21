package service;

import models.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    int counter = 0;
    Map<String, User> users = new HashMap<String, User>();
    private static UserService userService;
    private UserService(){}

    public static UserService getInstance(){
        if(userService == null)
            userService = new UserService();
        return userService;
    }
    public User addUser(String userName, String country, String city, int floorNo, int locationNumber){
        counter++;
        String userId = "User-"+counter;
        User user = new User(userId, userName, country, city, floorNo, locationNumber);
        users.put(userId, user);
        return user;
    }
    public User getUser(String id){
        return users.getOrDefault(id, null);
    }
    public void removeUser(String id){
        users.remove(id);
    }

}
