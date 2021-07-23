package model;

import java.util.HashMap;
import java.util.Map;

public class Expense {
    String id;

    String groupId;
    String name;
    double amount;
    Map<String, Double> paidBy, paidTo;

    public Expense(String id, String name, double amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }


    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Map<String, Double> getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(Map<String, Double> paidBy) {
        this.paidBy = paidBy;
    }

    public Map<String, Double> getPaidTo() {
        return paidTo;
    }

    public void setPaidTo(Map<String, Double> paidTo) {
        this.paidTo = paidTo;
    }
}
