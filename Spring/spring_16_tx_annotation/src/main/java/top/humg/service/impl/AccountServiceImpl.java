package top.humg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.humg.dao.AccountDao;
import top.humg.domain.Account;
import top.humg.service.AccountService;
@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)//为该类中的方法加上spring的事务控制
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public Account findAccountById(int id) {
        return accountDao.findById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void transfer(String sourceName, String targetName, Float money) {
        Account source = accountDao.findByName(sourceName);
        Account target = accountDao.findByName(targetName);

        System.out.printf("转出账户余额：%f%n转入账户余额%f%n", source.getMoney(), target.getMoney());

        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);
        accountDao.updateAccount(source);
        int i=1/0;
        accountDao.updateAccount(target);

        System.out.println("转账完成！");
        System.out.printf("转出账户余额：%f%n转入账户余额%f%n", source.getMoney(), target.getMoney());
    }
}
