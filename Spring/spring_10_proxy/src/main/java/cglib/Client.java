package cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();

        Producer proxy = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             *
             * @param o
             * @param method
             * @param objects
             * @param methodProxy
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                if (method.getName().equals("sellProduct")) {
                    //增强参数
                    Float money = (Float) objects[0] * 0.5f;
                    //增强方法体
                    System.out.println("增强方法体");
                    method.invoke(producer, money);
                }
                return null;
            }
        });

        proxy.sellProduct(1000f);
    }
}
