package com.mosh.demo2.service;

import com.mosh.demo2.entity.RoleRight;
import com.mosh.demo2.entity.right.Right;

import java.util.List;

/**
 * (RoleRight)表服务接口
 *
 * @author makejava
 * @since 2021-09-24 21:44:34
 */
public interface RoleRightService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RoleRight queryById(Integer id);

    /**
     * 通过实体查询单条数据
     *
     * @param roleRight 实体
     * @return 实例对象
     */
    RoleRight query(RoleRight roleRight);


    /**
     * 通过Right
     *
     * @return 实例对象
     */
    List<Right> queryRight();

    /**
     * @param roleId role id
     * @return list
     */
    List<Right> queryByRoleId(Integer roleId);

    /**
     * 新增数据
     *
     * @param roleRight 实例对象
     * @return 实例对象
     */
    RoleRight insert(RoleRight roleRight);

    /**
     * 修改数据
     *
     * @param roleRight 实例对象
     * @return 实例对象
     */
    RoleRight update(RoleRight roleRight);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 通过实体删除数据
     *
     * @param roleRight 实体
     * @return 是否成功
     */
    boolean delete(RoleRight roleRight);

}
