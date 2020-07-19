package com.itheima.mybatis.sqlsession.defaults;

import com.itheima.mybatis.cfg.Configuration;
import com.itheima.mybatis.proxy.MapperProxy;
import com.itheima.mybatis.session.SqlSession;
import com.itheima.mybatis.utils.DataSourceUtils;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class DefaultSqlSession implements SqlSession {
    private Configuration config;
    private Connection conn;

    public DefaultSqlSession(Configuration config) {
        this.config=config;
        conn= DataSourceUtils.getConnection(config);
    }

    /**
     * 创建dao接口的代理对象，对dao接口的方法进行增强（与数据库连接，执行SQL语句，封装结果集并返回）
     *
     * @param daoInterfaceClass dao的接口字节码对象
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        System.out.println("正在调用getmapper方法");
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(), new Class[]{daoInterfaceClass}, new MapperProxy(config.getMappers(),conn));
    }

    @Override
    public void close() {
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
