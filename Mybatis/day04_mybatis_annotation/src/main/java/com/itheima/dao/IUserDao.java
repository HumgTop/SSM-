package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * <p>
 * 用户的持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有操作
     *
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 通过id查询数据库，返回User对象
     *
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User findById(Integer id);

    @Insert("insert into user (username,sex,birthday,address) values (#{username},#{sex},#{birthday},#{address})")
    int add(User user);

    //模糊查询
    @Select("select * from user where username like '%${value}%'")
    List<User> findByUsername(String username);
}
