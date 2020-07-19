package com.itheima.mybatis.utils;

import com.itheima.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSourceUtils {
    public static Connection getConnection(Configuration config) {

        try {
            //注册驱动
            Class.forName(config.getDriver());
            //获取连接
            return DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
