package service.factory;

import service.GroupService;
import service.GroupServiceImpl;
import service.UserService;
import service.UserServiceImpl;

public class UserServiceFactory {

    public static UserService getUserService(){
        return UserServiceImpl.getInstance();
    }
}
