package top.humg.utils;

/**
 * 用于记录日志的工具类，提供公共代码
 */
public class Logger {
    //打印日志，在切入点方法前执行（前置通知）
    public void beforePrintLog() {
        System.out.println("printLog方法已经执行了");
    }

    //后置通知
    public void afterPrintLog() {
        System.out.println("printLog方法已经执行了");
    }
}
