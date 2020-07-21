import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.humg.dao.AccountDao;
import top.humg.domain.Account;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class JdbcTestDao {
    @Resource(name = "accountDao2")//自动依赖注入（因为JdbcTest没有在xml中配置，所以使用注解）
    private AccountDao accountDao;

    @Test
    public void testFindAll() {
        List<Account> all = accountDao.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindByName(){
        Account account = accountDao.findByName("刘");
        System.out.println(account);
    }
}
