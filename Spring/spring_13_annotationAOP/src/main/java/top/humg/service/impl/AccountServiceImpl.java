package top.humg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.humg.dao.AccountDao;
import top.humg.domain.Account;
import top.humg.service.AccountService;

import javax.annotation.Resource;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    //spring在创建service对象存入容器时，会通过set方法进行依赖注入，
    @Autowired
    private AccountDao accountDao;

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findById(int id) {
        return accountDao.findById(id);
    }

    public void transfer(String sourceName, String targetName, Float money) {
        //获取账户
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);

        //转账操作
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);

        //保存账户
        accountDao.update(source);
        accountDao.update(target);
    }
}
