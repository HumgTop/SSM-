package top.humg.service;

import top.humg.domain.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();

    Account findById(int id);
}
