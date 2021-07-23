package model;

import java.util.List;
import java.util.Set;

public class Group {
    String id;
    String name;
    Set<User> members;

    public Group(String id, String name, Set<User> members) {
        this.id = id;
        this.name = name;
        this.members = members;
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

    public Set<User> getMembers() {
        return members;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }
    public void addUser(User user){
        members.add(user);
    }
}
