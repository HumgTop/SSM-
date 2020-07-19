package top.humg.service.impl;

import top.humg.service.AccountService;

public class AccountServiceImpl implements AccountService {

    public AccountServiceImpl(){
        System.out.println("对象已创建");
    }

    public void add() {
        System.out.println("x");
    }

    public void init(){
        System.out.println("对象初始化了");
    }

    public void destroy(){
        System.out.println("对象被销毁");
    }
}
