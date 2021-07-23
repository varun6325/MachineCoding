package controller;

import model.Expense;
import service.ExpenseService;

import java.util.Map;

public class ExpenseController {
    private ExpenseService expenseService;
    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }
    public Expense addExpense(String name, double amount, Map<String, Double> paidBy, Map<String, Double> paidTo, String groupId){
        try{
            Expense expense = expenseService.addExpense(name, amount, paidBy, paidTo, groupId);

            return expense;
        }catch(IllegalArgumentException ex){
            System.out.println(ex);
            return null;
        }
    }
}
