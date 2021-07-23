package service.factory;

import service.ExpenseService;
import service.ExpenseServiceImpl;

public class ExpenseServiceFactory {

    public static ExpenseService getExpenseService(){
        return ExpenseServiceImpl.getInstance();
    }
}
