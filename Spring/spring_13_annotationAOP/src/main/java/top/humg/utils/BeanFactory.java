package top.humg.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.humg.service.AccountService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component("beanFactory")
@Aspect//配置为切面类
public class BeanFactory {
    @Autowired
    private TransactionManager txManager;

    //定义切入点方法
    @Pointcut("execution(* top.humg.service.impl.*.*(..))")
    private void pointCut(){}

    //当调用pointcut方法时，执行环绕通知
    @Around("pointCut()")
    public Object transactionManager(ProceedingJoinPoint pjp) {
        Object result = null;
        try {
            //开启事务
            txManager.beginTransaction();
            System.out.println("事务已开启");
            //调用原有方法
            Object[] args = pjp.getArgs();
            result = pjp.proceed(args);
            //提交事务
            txManager.commit();
            System.out.println("事务提交成功");
            //返回结果
            return result;
        } catch (Throwable e) {
            //发生异常回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            txManager.release();
        }
    }
}
