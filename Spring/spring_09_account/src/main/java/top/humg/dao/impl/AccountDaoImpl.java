package top.humg.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import top.humg.dao.AccountDao;
import top.humg.domain.Account;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private QueryRunner runner;//依赖注入

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public List<Account> findAll() {
        try {
            //BeanListHandler:对结果集进行封装
            return runner.query("select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public Account findById(int id) {
        try {
            return runner.query("select * from account where id = ? ", new BeanHandler<Account>(Account.class), id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public Account findAccountByName(String name) {
        try {
            List<Account> all = runner.query("select * from account where name = ? ", new BeanListHandler<Account>(Account.class), name);
            if (all == null || all.size() == 0) {
                return null;
            } else if (all.size() > 1) {
                throw new RuntimeException("结果集不为1，数据有问题");
            } else
                return all.get(0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public void update(Account account) {
        try {
            runner.update("update account set name = ?, money = ? where id = ? ", account.getName(), account.getMoney(), account.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
