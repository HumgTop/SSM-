package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

public interface IAccountDao {
    List<Account> findAll();

    /**
     * 一个用户可能有多个账户
     * @param uid
     * @return
     */
    List<Account> findByUid(Integer uid);
}
