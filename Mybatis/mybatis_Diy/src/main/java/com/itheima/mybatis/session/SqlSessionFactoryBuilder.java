package com.itheima.mybatis.session;

import com.itheima.mybatis.cfg.Configuration;
import com.itheima.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.itheima.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {
    /**
     * 根据输入流构建SQLSessionFactory工厂
     * @param inputStream 配置文件的输入流
     * @return
     */
    public SqlSessionFactory build(InputStream inputStream){
        //加载配置文件
        Configuration configuration = XMLConfigBuilder.loadConfiguration(inputStream);
        return new DefaultSqlSessionFactory(configuration);
    }
}
