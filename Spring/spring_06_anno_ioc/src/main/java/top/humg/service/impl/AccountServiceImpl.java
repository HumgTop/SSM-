package top.humg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import top.humg.dao.AccountDao;
import top.humg.dao.impl.AccountDaoImpl;
import top.humg.service.AccountService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.annotation.Resources;

@Service("accountService")//把当前对象存入容器中,可使用accountService为key获取对象
@Scope("singleton")
public class AccountServiceImpl implements AccountService {
//    @Autowired
////    @Qualifier("accountDao")
    @Resource(name = "accountDao1")
    private AccountDao accountDao;

    public AccountServiceImpl(){
        System.out.println("对象已创建");
    }

    @PostConstruct
    public void init(){
        System.out.println("调用初始化方法");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("调用销毁方法");
    }

    public void add() {
        accountDao.add();
    }
}
