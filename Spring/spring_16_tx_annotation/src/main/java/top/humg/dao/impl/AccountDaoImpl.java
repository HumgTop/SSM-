package top.humg.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import top.humg.dao.AccountDao;
import top.humg.domain.Account;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbc;//在bean.xml中设置依赖注入

    @Override
    public List<Account> findAll() {
        return jdbc.query("select * from account", new BeanPropertyRowMapper<>(Account.class));
    }

    @Override
    public Account findById(int id) {
        return null;
    }

    @Override
    public Account findByName(String name) {
        name = "%" + name + "%";
        return jdbc.queryForObject("select * from account where name like ? ", new BeanPropertyRowMapper<>(Account.class), name);
    }

    @Override
    public void updateAccount(Account account) {
        jdbc.update("update account set money = ? where id = ? ", account.getMoney(), account.getId());
    }
}
