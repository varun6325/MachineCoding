package service;

import model.Group;
import model.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface GroupService {
    Group addGroup(String name, Set<User> members) throws IllegalArgumentException;
    void removeGroup(String groupId) throws IllegalArgumentException;
    void addUserToGroup(String groupId, User user) throws IllegalArgumentException;
    void removeUserFromGroup(String groupId, User user) throws IllegalArgumentException;
    Group getGroup(String groupId);
    Map<String, Double> getPendingAmountOfUsersInGroup(String groupID);
}
