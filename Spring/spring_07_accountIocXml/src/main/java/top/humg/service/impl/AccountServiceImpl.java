package top.humg.service.impl;

import top.humg.dao.AccountDao;
import top.humg.domain.Account;
import top.humg.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    //spring在创建service对象存入容器时，会通过set方法进行依赖注入，
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
        System.out.println("注入成功");
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findById(int id) {
        return accountDao.findById(id);
    }
}
