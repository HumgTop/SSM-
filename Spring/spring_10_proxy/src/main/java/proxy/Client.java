package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        final ProducerImpl producer = new ProducerImpl();

        Producer producerProxy = (Producer) Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 执行被代理对象的任何接口方法都会经过该方法
                     * @param proxy 代理对象的引用
                     * @param method 当前执行的方法对象
                     * @param args 当前执行方法的参数
                     * @return 方法增强后的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //提供增强的代码
                        Object result = null;

//                        1.获取方法执行的参数
                        Float money = (Float) args[0];
//                        2.判断当前方法是不是销售
                        if ("sellProduct".equals(method.getName())) {
                            return method.invoke(producer, money * 0.7f);//参数增强
                        }
                        return null;
                    }
                });

        producerProxy.sellProduct(1000f);
    }
}
