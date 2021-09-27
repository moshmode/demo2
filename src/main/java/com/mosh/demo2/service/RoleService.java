package com.mosh.demo2.service;

import com.mosh.demo2.entity.Role;

import java.util.List;


/**
 * (Role)表服务接口
 *
 * @author makejava
 * @since 2021-09-24 21:32:28
 */
public interface RoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Role queryById(Integer id);

    /**
     * select all
     *
     * @return 实例对象
     */
    List<Role> queryAll();


    /**
     * 新增数据
     *
     * @param name 实例对象名字
     * @return 实例对象
     */
    int insert(String name);

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    Role update(Role role);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
