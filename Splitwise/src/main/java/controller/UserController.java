package controller;

import model.User;
import service.UserService;

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User addUser(String name){
        try{
            return userService.addUser(name);
        }catch(IllegalArgumentException ex){
            System.out.println(ex);
            return null;
        }
    }
    public User getUser(String userId){
        return userService.getUser(userId);
    }
    public boolean removeUser(String userId){
        try{
            userService.removeUser(userId);
            return true;
        }catch (IllegalArgumentException ex){
            System.out.println(ex);
            return false;
        }
    }
    public double getPendingAmountForUser(String userId){
        return userService.getPendingAmountForUser(userId);
    }


    }
