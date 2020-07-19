import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.humg.service.AccountService;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class test {
    //依赖注入
    @Resource(name = "proxyAccountService")
    private AccountService service;

    @Test
    public void transferTest(){
        service.transfer("aaa","bbb",(float)500);
    }
}
