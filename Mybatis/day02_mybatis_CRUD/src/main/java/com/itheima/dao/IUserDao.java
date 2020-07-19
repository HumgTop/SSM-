package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;

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
    List<User> findAll();

    /**
     * 将user对象存入数据库中
     *
     * @param user 待存入数据库的user对象
     */
    void add(User user);

    /**
     * 对user对象的部分属性进行更新
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除数据库中的一个用户
     *
     * @param id
     */
    void delUser(Integer id);

    /**
     * 通过id查询数据库，返回User对象
     *
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 根据用户名模糊查询
     *
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 根据vo中的条件查询用户
     *
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);
}
