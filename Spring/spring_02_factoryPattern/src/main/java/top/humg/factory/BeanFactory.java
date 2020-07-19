package top.humg.factory;

import top.humg.dao.impl.AccountDaoImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个创建Bean对象的工厂
 * Bean：在计算机英语中，有可重用组件的含义。
 * JavaBean>实体类
 */
public class BeanFactory {
    private static final Properties pro;

    private static final Map<String, Object> beans;//定义一个容器存储得到的bean对象

    static {
        pro = new Properties();
        try {
            pro.load(BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties"));
            //实例化容器
            beans=new HashMap<String, Object>();
            //取出配置文件的所有key
            Enumeration<Object> keys = pro.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = pro.getProperty(key);
                //反射创建对象
                Class<?> beanClass = Class.forName(beanPath);
                Object value_bean = beanClass.newInstance();
                //把对象存入map集合中
                beans.put(key,value_bean);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        }
    }

    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }
}
