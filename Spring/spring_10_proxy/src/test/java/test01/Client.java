package test01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        TestImpl testImpl = new TestImpl();
        Test proxy = (Test) Proxy.newProxyInstance(testImpl.getClass().getClassLoader(), testImpl.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //testImpl中所有被调用方法的返回值都为55，原有方法定义的返回值被覆盖
                return 55;
            }
        });

        System.out.println(proxy.printNum(1));
    }
}
