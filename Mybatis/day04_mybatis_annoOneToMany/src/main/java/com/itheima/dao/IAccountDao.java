package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.AccountUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IAccountDao {
    List<Account> findAll();

    /**
     * 查询所有账户，并且带有用户和地址信息
     *
     * @return
     */
//    List<AccountUser> findAllAccount();


    List<Account> findAllAccount();

    @Select("select * from account where uid = #{uid}")
    List<Account> findByUid(Integer uid);
}
