package top.humg.dao;

import top.humg.domain.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();

    Account findById(int id);

    /**
     * 根据名称查询账户
     * @param name 账户名称
     * @return 有唯一结果就返回，无结果返回null。超过一个结果抛出异常
     */
    Account findAccountByName(String name);

    void update(Account account);
}
