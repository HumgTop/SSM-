import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.humg.config.SpringConfiguration;
import top.humg.domain.Account;
import top.humg.service.AccountService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//替换原有运行器
@ContextConfiguration(classes = SpringConfiguration.class)//指定spring的配置类
public class test {
    @Autowired
    private AccountService service;

    @Test
    public void clientTest() {
        List<Account> all = service.findAll();
        System.out.println(all);
        System.out.println(service.findById(2));
    }
}
