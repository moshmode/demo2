package com.mosh.demo2.service.impl;

import com.mosh.demo2.entity.UserBucket;
import com.mosh.demo2.dao.UserBucketDao;
import com.mosh.demo2.service.UserBucketService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (UserBucket)表服务实现类
 *
 * @author makejava
 * @since 2021-09-09 12:31:09
 */
@Service("userBucketService")
public class UserBucketServiceImpl implements UserBucketService {
    @Resource
    private UserBucketDao userBucketDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserBucket queryById(Integer id) {
        return this.userBucketDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param userBucket 实例对象
     * @return 实例对象
     */
    @Override
    public UserBucket insert(UserBucket userBucket) {
        this.userBucketDao.insert(userBucket);
        return userBucket;
    }

    /**
     * 修改数据
     *
     * @param userBucket 实例对象
     * @return 实例对象
     */
    @Override
    public UserBucket update(UserBucket userBucket) {
        this.userBucketDao.update(userBucket);
        return this.queryById(userBucket.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userBucketDao.deleteById(id) > 0;
    }
}
