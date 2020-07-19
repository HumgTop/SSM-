package com.itheima.mybatis.session;

/**
 * 和数据库交互的核心类
 *
 */
public interface SqlSession {

    /**
     * 根据参数创建代理对象
     * @param daoInterfaceClass dao的接口字节码对象
     * @param <T>
     * @return 代理对象
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 释放资源
     */
    void close();
}
