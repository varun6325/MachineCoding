package service.factory;

import model.Group;
import service.ExpenseService;
import service.ExpenseServiceImpl;
import service.GroupService;
import service.GroupServiceImpl;

public class GroupServiceFactory {

    public static GroupService getGroupService(){
        return GroupServiceImpl.getInstance();
    }
}
