package top.humg.service;

import top.humg.domain.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();

    Account findById(int id);

    /**
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money      转账金额
     */
    void transfer(String sourceName, String targetName, Float money);
}
