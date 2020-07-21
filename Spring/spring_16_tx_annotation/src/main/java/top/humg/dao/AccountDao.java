package top.humg.dao;

import top.humg.domain.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();

    Account findById(int id);

    /**
     * mo
     * @param name
     * @return
     */
    Account findByName(String name);

    void updateAccount(Account account);
}
