package top.humg.service.impl;

import top.humg.service.AccountService;

import java.util.Date;

public class AccountServiceImpl implements AccountService {
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl() {
    }

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void add() {
        System.out.println("service中的add方法被执行了--" + name + "--" + age + "--" + birthday);
    }

}
