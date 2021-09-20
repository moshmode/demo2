package com.mosh.demo2.service;

import com.mosh.demo2.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2021-09-09 12:17:08
 */
@Service
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);

    /**
     * 通过ID查询单条数据
     *
     * @param name 用户名
     * @return 实例对象
     */
    User queryByName(String name);

    /**
     * 查询多条记录
     *
     * @param pageNow 当前页
     * @param pageSize 页大小
     * @return 实例集合
     */
    List<User> queryByPage(Integer pageNow, Integer pageSize);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
