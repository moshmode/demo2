package com.mosh.demo2.service.impl;

import com.mosh.demo2.entity.User;
import com.mosh.demo2.dao.UserDao;
import com.mosh.demo2.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2021-09-09 12:17:08
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param name 用户名
     * @return 实例对象
     */
    @Override
    public User queryByName(String name) {
        return this.userDao.queryByName(name);
    }

    @Override
    public long count(User user) {
        return userDao.count(user);
    }

    /**
     * 查询多条记录
     *
     * @param pageNow  当前页
     * @param pageSize 页大小
     * @return 实例集合
     */
    @Override
    public List<User> queryByPage(Integer pageNow, Integer pageSize) {
        return userDao.queryByPage((pageNow - 1) * pageSize, pageSize);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userDao.deleteById(id) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param name 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteByName(String name) {
        return this.userDao.deleteByName(name) > 0;
    }
}
