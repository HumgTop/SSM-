package top.humg.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.humg.dao.AccountDao;
import top.humg.domain.Account;

import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private JdbcTemplate jdbc;//在bean.xml中设置依赖注入

    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

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
