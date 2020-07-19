package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * <p>
 * 用户的持久层接口
 */
@CacheNamespace(blocking = true)//开启二级缓存
public interface IUserDao {

    /**
     * 查询所有操作
     *
     * @return
     */
    @Select("select * from user")
    @Results(id="userMap", value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "address",property = "address"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "birthday",property = "birthday"),
            @Result(column = "id",property = "accounts",many = @Many(select = "com.itheima.dao.IAccountDao.findByUid",
                    fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    /**
     * 通过id查询数据库，返回User对象
     *
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    @ResultMap("userMap")
    User findById(Integer id);
}
