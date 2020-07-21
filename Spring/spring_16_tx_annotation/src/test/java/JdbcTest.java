import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.humg.domain.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class JdbcTest {
    @Autowired//自动依赖注入（因为JdbcTest没有在xml中配置，所以使用注解）
    private JdbcTemplate jdbcTemplate;

    //定义一个RowMapper的实现类
    private static class AccountRowMapper implements RowMapper<Account> {
        /**
         * 把结果集中的数据封装到Account中，然后由spring把每个Account添加到集合中
         *
         * @param rs     查询数据库返回的结果集
         * @param rowNum
         * @return 封装好的一个account对象
         * @throws SQLException
         */
        public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
            Account account = new Account();
            account.setId(rs.getInt("id"));
            account.setName(rs.getString("name"));
            account.setMoney(rs.getFloat("money"));
            return account;
        }
    }

    @Test
    public void test1() {
        jdbcTemplate.execute("insert into account (name, money) values ('刘均华', 2000)");
    }

    @Test
    public void testQuery() {
        List<Account> all = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        for (Account account : all) {
            System.out.println(account);
        }
    }

    @Test
    public void testQuery1() {
        List<Account> all = jdbcTemplate.query("select * from account", new AccountRowMapper());
        for (Account account : all) {
            System.out.println(account);
        }
    }

    @Test
    public void testQuery2() {
        Integer total = jdbcTemplate.queryForObject("select count(*) from account ", Integer.class);
        System.out.println(total);
    }

    @Test
    public void testUpdate() {
        jdbcTemplate.update("update account set name = ? where name = '艾伦'", "alan");
        System.out.println("更新用户完成");
    }

    @Test
    public void testDel() {
        jdbcTemplate.update("delete from account where name = 'alan'");
    }
}
