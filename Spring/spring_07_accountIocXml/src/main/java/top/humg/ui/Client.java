package top.humg.ui;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.humg.domain.Account;
import top.humg.service.AccountService;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        AccountService service=(AccountService) new ClassPathXmlApplicationContext("bean.xml").getBean("accountService");
        List<Account> all = service.findAll();
        System.out.println(all);
        System.out.println(service.findById(2));
    }
}
