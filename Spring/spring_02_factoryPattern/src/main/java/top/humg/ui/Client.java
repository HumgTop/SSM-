package top.humg.ui;

import top.humg.factory.BeanFactory;
import top.humg.service.AccountService;

public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            //此处的service对象始终是同一个（单例模式）：在程序运行期间该service对象始终存在
            AccountService service= (AccountService) BeanFactory.getBean("accountService");
            service.add();
        }
    }
}
