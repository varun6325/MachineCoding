package service;

import model.User;

public interface UserService {
    User addUser(String name) throws IllegalArgumentException;
    public User getUser(String userId);
    void removeUser(String userId) throws IllegalArgumentException;
    double getPendingAmountForUser(String userId);
}
