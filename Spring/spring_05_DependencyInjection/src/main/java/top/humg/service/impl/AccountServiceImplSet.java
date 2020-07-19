package top.humg.service.impl;

import top.humg.service.AccountService;

import java.util.Date;

public class AccountServiceImplSet implements AccountService {
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void add() {
        System.out.println("service中的add方法被执行了--" + name + "--" + age + "--" + birthday);
    }

}
