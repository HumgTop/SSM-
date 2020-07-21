package top.humg.service;

import top.humg.domain.Account;

public interface AccountService {
    Account findAccountById(int id);

    /**
     * @param sourceName 转出账户
     * @param targetName 转入账户
     * @param money      转账金额
     */
    void transfer(String sourceName, String targetName, Float money);
}
