package top.humg.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import top.humg.config.SpringConfiguration;
import top.humg.domain.Account;
import top.humg.service.AccountService;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        //通过读取被@Configuration注解的类字节码文件来获取容器对象
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService service = (AccountService) context.getBean("accountService");
        List<Account> all = service.findAll();
        System.out.println(all);
        System.out.println(service.findById(2));
    }
}
