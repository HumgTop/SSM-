package top.humg.service.impl;

import top.humg.dao.AccountDao;
import top.humg.domain.Account;
import top.humg.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account findAccountById(int id) {
        return accountDao.findById(id);
    }

    @Override
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
