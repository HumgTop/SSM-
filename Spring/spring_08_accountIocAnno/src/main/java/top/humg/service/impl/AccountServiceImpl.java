package top.humg.service.impl;

import org.springframework.stereotype.Service;
import top.humg.dao.AccountDao;
import top.humg.domain.Account;
import top.humg.service.AccountService;

import javax.annotation.Resource;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    //spring在创建service对象存入容器时，会通过set方法进行依赖注入，
    @Resource(name = "accountDao")
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
