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

/**
 * 如果使用注解来控制事务，需要使用环绕通知。
 * 因为@After会比@AfterReturning先执行
 */
@Component("txAdvice")
@Aspect//配置为切面类
public class TxAdvice {
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
            //前置通知：开启事务
            txManager.beginTransaction();
            System.out.println("事务已开启");
            //调用原有方法
            Object[] args = pjp.getArgs();//获取参数
            result = pjp.proceed(args);//执行方法
            //后置通知：提交事务
            txManager.commit();
            System.out.println("事务提交成功");
            //返回结果
            return result;
        } catch (Throwable e) {
            //异常通知：发生异常回滚操作
            System.out.println("发生异常，已回滚");
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //最终通知：释放连接
            System.out.println("资源已释放");
            txManager.release();
        }
    }
}
