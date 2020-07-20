package top.humg.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.humg.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AOPTest {
    @Autowired
    private AccountService service;

    @Test
    public void test1() {
        //这是新分支，新的分支哦
//        service.saveAccount();
        service.updateAccount(12);//使用环绕通知插入
    }
}
