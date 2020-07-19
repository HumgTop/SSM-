package top.humg.dao.impl;

import org.springframework.stereotype.Repository;
import top.humg.dao.AccountDao;

@Repository("accountDao1")
public class AccountDaoImpl implements AccountDao {
    public void add() {
        System.out.println("dao层：对象已保存");
    }
}
