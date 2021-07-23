package service;

import model.Expense;
import model.Group;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseServiceImpl implements ExpenseService {
    static ExpenseService expenseService;
    private ExpenseServiceImpl(){}
    public static ExpenseService getInstance(){
        if(expenseService == null)
            expenseService = new ExpenseServiceImpl();
        return expenseService;
    }
    Map<String, Expense> expenses = new HashMap<>();
    int counter = 0;
    @Override
    public Expense addExpense(String name, Double amount, Map<String, Double> paidBy, Map<String, Double> paidTo, String groupId) {
        counter++;
        String expenseId = "expense"+counter;
        Expense expense = new Expense(expenseId, name, amount);
        expense.setGroupId(groupId);
        expense.setPaidBy(paidBy);
        expense.setPaidTo(paidTo);
        expenses.put(expenseId, expense);
        return expense;
    }

    @Override
    public List<Expense> getExpenses(User user) {
        List<Expense> expenseList = new ArrayList<>();
        for(Expense expense : expenses.values()){
            if(expense.getPaidBy().containsKey(user.getId()) || expense.getPaidTo().containsKey(user.getId()))
                expenseList.add(expense);
        }
        return expenseList;
    }

    @Override
    public List<Expense> getExpenses(Group group) {
        List<Expense> expenseList = new ArrayList<>();
        for(Expense expense : expenses.values()){
            if(expense.getGroupId() == group.getId())
                expenseList.add(expense);
        }
        return expenseList;
    }
}
