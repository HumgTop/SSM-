import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.humg.domain.Account;
import top.humg.service.AccountService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class ServiceMethodTest {
    @Autowired//自动依赖注入（因为本类没有在xml中配置，所以使用注解）
    private AccountService service;

    @Test
    public void testTransfer(){
        service.transfer("胡民港","刘均华",100f);
    }
}
