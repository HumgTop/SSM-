package com.itheima.mybatis.proxy;

import com.itheima.mybatis.cfg.Mapper;
import com.itheima.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {
    //mappers中包含了dao接口中的方法名，和SQL语句以及查询结果返回的类型
    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String, Mapper> mappers,Connection conn) {
        this.mappers = mappers;
        this.conn=conn;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //获取方法名
        String methodName = method.getName();
        //获取方法所在类名
        String classname = method.getDeclaringClass().getName();
        //组合key
        String key = classname + "." + methodName;
        //获取mapper对象
        Mapper mapper = mappers.get(key);
        //判断是否有mapper
        if (mapper == null) {
            throw new IllegalArgumentException("传入的参数有误!");
        }
        return new Executor().selectList(mapper,conn);//也是代理对象调用方法得到的返回对象
    }
}
