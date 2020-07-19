package top.humg.ui;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import top.humg.service.AccountService;

public class Client {
    //获取spring的IOC核心容器，并根据id获取对象
    public static void main(String[] args) {
        //立即加载策略
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        AccountService service = (AccountService)context.getBean("accountService");
        context.close();
    }
}
