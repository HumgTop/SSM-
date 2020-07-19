package com.itheima.dao;

import com.itheima.domain.Role;

import java.util.List;

public interface IRoleDao {
    /**
     * 查询所有的职位
     * @return
     */
    List<Role> findAll();
}
