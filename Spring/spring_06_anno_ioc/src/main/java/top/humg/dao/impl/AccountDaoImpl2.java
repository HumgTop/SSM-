package top.humg.dao.impl;

import org.springframework.stereotype.Repository;
import top.humg.dao.AccountDao;

@Repository
public class AccountDaoImpl2 implements AccountDao {
    public void add() {
        System.out.println("dao层：对象已保存");
    }
}
