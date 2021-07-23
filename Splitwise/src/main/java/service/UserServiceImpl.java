package service;

import model.Expense;
import model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    Map<String, User> users = new HashMap<String, User>();
    int counter = 0;

    static UserService userService;
    private UserServiceImpl(){}
    public static UserService getInstance(){
        if(userService == null)
            userService = new UserServiceImpl();
        return userService;
    }

    @Override
    public User addUser(String name) throws IllegalArgumentException{
        counter++;
        String userId = "user"+counter;
        User user = new User(userId, name);
        System.out.println("user added : " + userId);
        users.put(userId, user);
        return user;
    }

    @Override
    public User getUser(String userId){
        return users.getOrDefault(userId, null);
    }

    public double getPendingAmountForUser(String userId){
        ExpenseService expenseService = ExpenseServiceImpl.getInstance();
        List<Expense> expenseList = expenseService.getExpenses(users.get(userId));
        double amount = 0;
        for(Expense expense : expenseList){
            amount += expense.getPaidBy().getOrDefault(userId, 0.0);
            amount -= expense.getPaidTo().getOrDefault(userId, 0.0);
        }
        return amount;
    }
    @Override
    public void removeUser(String userId) throws IllegalArgumentException {
        if(users.containsKey(userId)){
            double amountPending = getPendingAmountForUser(userId);
            if(amountPending == 0.0){
                System.out.println("removing user : " + userId);
                users.remove(userId);
            }else{
                System.out.println("Cannot remove user " + userId + " as pending amount is not 0.0");
                throw new IllegalArgumentException("Cannot remove user " + userId + " as pending amount is not 0.0");
            }
        }else
            System.out.println("User id : " + userId + " is not present");
    }
}
