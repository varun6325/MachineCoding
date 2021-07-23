package service;

import model.Expense;
import model.Group;
import model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ExpenseService {
    Expense addExpense(String name, Double amount, Map<String, Double> paidBy, Map<String, Double> paidTo, String groupId);
    List<Expense> getExpenses(User user);
    List<Expense> getExpenses(Group group);
}
