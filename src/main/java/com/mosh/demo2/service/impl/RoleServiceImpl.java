package com.mosh.demo2.service.impl;

import com.mosh.demo2.entity.Role;
import com.mosh.demo2.dao.RoleDao;
import com.mosh.demo2.entity.RoleRight;
import com.mosh.demo2.entity.right.Right;
import com.mosh.demo2.service.RoleRightService;
import com.mosh.demo2.service.RoleService;
import com.mosh.demo2.util.SpringUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

/**
 * (Role)表服务实现类
 *
 * @author makejava
 * @since 2021-09-24 21:32:28
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;

    @Resource
    RoleRightService roleRightService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Role queryById(Integer id) {
        return this.roleDao.queryById(id);
    }

    /**
     * select all
     *
     * @return 实例对象
     */
    public List<Role> queryAll() {
        return roleDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param name 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(String name) {
        return this.roleDao.insert(name);
    }

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role update(Role role) {
        this.roleDao.update(role);
        return this.queryById(role.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.roleDao.deleteById(id) > 0;
    }
}
