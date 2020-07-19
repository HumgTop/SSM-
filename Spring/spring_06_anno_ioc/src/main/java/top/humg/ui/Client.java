package top.humg.ui;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.humg.service.AccountService;

public class Client {
    //获取spring的IOC核心容器，并根据id获取对象
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        AccountService service = (AccountService)context.getBean("accountService");
        service.add();
        context.close();
    }
}
