package top.humg.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import top.humg.dao.AccountDao;
import top.humg.domain.Account;

import java.util.List;

public class AccountDaoImpl2 extends JdbcDaoSupport implements AccountDao {
    //getJdbcTemplate方法需要DataSource参数，所以在bean.xml中为其注入依赖

    @Override
    public List<Account> findAll() {
        System.out.println("这是继承了JDBCTemplateSupport的Dao实现类");
        return getJdbcTemplate().query("select * from account", new BeanPropertyRowMapper<>(Account.class));
    }

    @Override
    public Account findById(int id) {
        return null;
    }

    @Override
    public Account findByName(String name) {
        name = "%" + name + "%";
        return getJdbcTemplate().queryForObject("select * from account where name like ? ", new BeanPropertyRowMapper<>(Account.class), name);
    }

    @Override
    public void updateAccount(Account account) {

    }
}
