package top.humg.ui;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import top.humg.service.AccountService;

public class Client {
    //获取spring的IOC核心容器，并根据id获取对象
    public static void main(String[] args) {
//        //获取核心容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        //根据id获取AccountService实现类对象
//        AccountService service = (AccountService) ac.getBean("accountService");
//        AccountDao accountDao = ac.getBean("accountDao", AccountDao.class);
//        System.out.println(service);
//        System.out.println(accountDao);
//        service.add();

        //演示BeanFactory的延迟加载策略
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("bean.xml"));
        AccountService service = (AccountService)factory.getBean("accountService");
        service.add();
    }
}
