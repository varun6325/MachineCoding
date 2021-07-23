import controller.ExpenseController;
import controller.GroupController;
import controller.UserController;
import model.Group;
import model.User;
import service.ExpenseService;
import service.GroupService;
import service.UserService;
import service.factory.ExpenseServiceFactory;
import service.factory.GroupServiceFactory;
import service.factory.UserServiceFactory;

import java.util.*;

public class Driver {
    public static void main(String[] args){
        UserController userController = new UserController(UserServiceFactory.getUserService());
        GroupController groupController = new GroupController(GroupServiceFactory.getGroupService(), UserServiceFactory.getUserService());
        ExpenseController expenseController = new ExpenseController(ExpenseServiceFactory.getExpenseService());
        User user1 = userController.addUser("varun");
        User user2 = userController.addUser("bharat");
        User user3 = userController.addUser("jatin");
        User user4 = userController.addUser("charu");
        System.out.println(user1.getId() + " " + user1.getName());
        List<String> members = new ArrayList<>();
        members.add(user1.getId());
        members.add(user2.getId());
        members.add(user3.getId());
        members.add(user4.getId());
        Group group1 = groupController.addGroup("group1", members);
        Map<String, Double> paidBy = new HashMap<>();
        Map<String, Double> paidTo = new HashMap<>();
        paidBy.put(user1.getId(), 550.0);
        paidBy.put(user2.getId(), 1250.0);
        paidTo.put(user1.getId(), 250.0);
        paidTo.put(user2.getId(), 550.0);
        paidTo.put(user3.getId(), 500.0);
        paidTo.put(user4.getId(), 500.0);
        expenseController.addExpense("expense1", 1500.0, paidBy, paidTo, group1.getId());
        System.out.println(userController.getPendingAmountForUser(user1.getId()));
        System.out.println(userController.getPendingAmountForUser(user2.getId()));
        System.out.println(userController.getPendingAmountForUser(user3.getId()));
        System.out.println(userController.getPendingAmountForUser(user4.getId()));
        List<String> balances = groupController.getBalances(group1);
        for(String balance : balances)
            System.out.println(balance);
    }
}
