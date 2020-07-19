package com.itheima.mybatis.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//描述注解被保留到的阶段
@Target(ElementType.METHOD)//描述注解作用的位置
public @interface Select {
    /**
     * 配置SQL语句
     * @return
     */
    String value();
}
