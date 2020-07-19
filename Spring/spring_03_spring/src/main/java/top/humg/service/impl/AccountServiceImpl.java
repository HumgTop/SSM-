package top.humg.service.impl;

import top.humg.service.AccountService;

public class AccountServiceImpl implements AccountService {

    public AccountServiceImpl(){
        System.out.println("对象已创建");
    }

    public void add() {
        System.out.println("service中方法被调用");
    }
}
