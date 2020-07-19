package top.humg.service.impl;

import top.humg.dao.AccountDao;
import top.humg.factory.BeanFactory;
import top.humg.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private static AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");
    private int i = 1;

    public void add() {
        accountDao.add();
        System.out.println(i);
        i++;
    }
}
