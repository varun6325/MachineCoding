package service;

import model.Expense;
import model.Group;
import model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupServiceImpl implements GroupService {
    Map<String, Group> groups = new HashMap<>();
    int counter = 0;

    static GroupService groupService;
    private GroupServiceImpl(){}
    public static GroupService getInstance(){
        if(groupService == null)
            groupService = new GroupServiceImpl();
        return groupService;
    }
    @Override
    public Group addGroup(String name, Set<User> members){
        counter++;
        String groupId = "group"+counter;
        Group group = new Group(groupId, name, members);
        System.out.println("group added : " + groupId);
        groups.put(groupId, group);
        return group;
    }
    public Map<String, Double> getPendingAmountOfUsersInGroup(String groupID){
        ExpenseService expenseService = ExpenseServiceImpl.getInstance();
        List<Expense> expenseList = expenseService.getExpenses(groups.get(groupID));
        Map<String, Double> pendingAmountsForUsers = new HashMap<>();
        for(User user : groups.get(groupID).getMembers()){
            pendingAmountsForUsers.put(user.getId(), 0.0);
        }
        for(Expense expense : expenseList){
            for(Map.Entry<String, Double> entry : expense.getPaidBy().entrySet()){
                pendingAmountsForUsers.put(entry.getKey(), pendingAmountsForUsers.get(entry.getKey())+entry.getValue());
            }
            for(Map.Entry<String, Double> entry : expense.getPaidTo().entrySet()){
                pendingAmountsForUsers.put(entry.getKey(), pendingAmountsForUsers.get(entry.getKey())-entry.getValue());
            }
        }
        return pendingAmountsForUsers;
    }
    @Override
    public void removeGroup(String groupId){
        if(!groups.containsKey(groupId))
            throw new IllegalArgumentException("groupId " + groupId + " does not exists");
        Map<String, Double> pendingAmountOfUsersInGroup = getPendingAmountOfUsersInGroup(groupId);
        for(Map.Entry<String, Double> pending : pendingAmountOfUsersInGroup.entrySet()){
            if(pending.getValue() != 0.0){
                throw new IllegalArgumentException("amount pending in this group " + groupId);
            }
        }
        groups.remove(groupId);
    }


    @Override
    public void addUserToGroup(String groupId, User user){
        if(!groups.containsKey(groupId))
            throw new IllegalArgumentException("groupId " + groupId + " does not exists");
        if(groups.get(groupId).getMembers().contains(user))
            throw new IllegalArgumentException("user id " + user.getId() + "already exists in the group " + groupId);
        groups.get(groupId).addUser(user);
    }

    @Override
    public void removeUserFromGroup(String groupId, User user) {
        if(!groups.containsKey(groupId))
            throw new IllegalArgumentException("groupId " + groupId + " does not exists");
        if(!groups.get(groupId).getMembers().contains(user))
            throw new IllegalArgumentException("user id " + user.getId() + "does not exist in this group " + groupId );
        groups.get(groupId).getMembers().remove(user);
    }

    @Override
    public Group getGroup(String groupdId){
        return groups.getOrDefault(groupdId, null);
    }
}
