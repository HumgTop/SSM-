package com.itheima.mybatis.sqlsession.defaults;

import com.itheima.mybatis.cfg.Configuration;
import com.itheima.mybatis.session.SqlSession;
import com.itheima.mybatis.session.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration config;

    public DefaultSqlSessionFactory(Configuration config) {
        this.config=config;
    }

    /**
     * 创建一个新的数据库操作对象
     * @return DefaultSqlSession
     */
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(config);
    }
}
