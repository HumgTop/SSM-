package top.humg.factory;

import top.humg.service.AccountService;
import top.humg.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {
    private AccountService accountService;//依赖注入后就是AccountService的实现类对象
    private TransactionManager txManager;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    /**
     * @return 返回service的代理对象
     */
    public AccountService getAccountService() {
        return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result = null;
                        try {
                            //开启事务
                            txManager.beginTransaction();
                            System.out.println("事务已开启");
                            //调用原有方法
                            result = method.invoke(accountService, args);
                            //提交事务
                            txManager.commit();
                            System.out.println("事务提交成功");
                            //返回结果
                            return result;
                        } catch (Exception e) {
                            //发生异常回滚操作
                            txManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            txManager.release();
                        }

                    }
                });
    }
}
