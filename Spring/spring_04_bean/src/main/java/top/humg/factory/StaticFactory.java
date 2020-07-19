package top.humg.factory;

import top.humg.service.impl.AccountServiceImpl;

public class StaticFactory {
    public static AccountServiceImpl getAccountService(){
        return new AccountServiceImpl();
    }
}

