package controller;

import model.Group;
import model.User;
import service.GroupService;
import service.UserService;

import java.util.*;

public class GroupController {
    private GroupService groupService;
    private UserService userService;

    public GroupController(GroupService groupService, UserService userService) {
        this.groupService = groupService;
        this.userService = userService;
    }

    public Group addGroup(String name, List<String> userIds){
        try{
            Group group = groupService.addGroup(name, new HashSet<>());
            for(String userId : userIds){
                User user = userService.getUser(userId);
                if(user != null)
                    groupService.addUserToGroup(group.getId(), user);
                else
                    System.out.println("no user exists with user id " + userId);
            }
            return group;
        }catch(IllegalArgumentException ex){
            System.out.println(ex);
            return null;
        }
    }
    public Group getGroup(String groupId) {
        return groupService.getGroup(groupId);
    }
    public List<String> getBalances(Group group){
        Map<String, Double> pendingBalances = groupService.getPendingAmountOfUsersInGroup(group.getId());
        Pair pairs[] = new Pair[pendingBalances.size()];
        int i = 0;
        for(Map.Entry<String, Double> entry : pendingBalances.entrySet()){
            pairs[i] = new Pair(entry.getKey(), entry.getValue());
            i++;
        }
        Arrays.sort(pairs, (a,b) -> {
            Pair pairA = a;
            Pair pairB = b;
            return pairA.second < pairB.second ? -1 : 1;
        });
        i = 0;
        int j = pairs.length-1;
        List<String> balances = new ArrayList<>();
        while(i <= j){
            if(pairs[i].second == 0.0 || pairs[j].second == 0.0)
                break;
            double toBePaid = Math.abs(pairs[i].second);
            double toBeReceived = pairs[j].second;
            if(toBePaid >= toBeReceived){
                balances.add(pairs[i].first + " owes " + pairs[j].first + " " + toBeReceived + " Rs");
                j--;
                if(toBePaid == toBeReceived)
                    i++;
                else
                    pairs[i] = new Pair(pairs[i].first, toBeReceived-toBePaid);
            }else{
                balances.add(pairs[i].first + " owes " + pairs[j].first + " " + toBePaid + " Rs");
                i++;
                pairs[j] = new Pair(pairs[j].first, toBeReceived-toBePaid);

            }
        }
        return balances;
    }
    class Pair{
        final String first;
        Double second;
        Pair(String first, Double second){
            this.first = first;
            this.second = second;
        }
    }
}
