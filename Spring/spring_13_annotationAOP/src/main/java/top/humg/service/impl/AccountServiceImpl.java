package top.humg.service.impl;

import org.springframework.stereotype.Service;
import top.humg.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    public void saveAccount() {
        System.out.println("执行了保存方法");
    }

    public void updateAccount(int id) {
        System.out.println("更新了用户：" + id);
    }

    public int deleteAccount() {
        System.out.println("执行了删除");
        return 1;
    }
}
