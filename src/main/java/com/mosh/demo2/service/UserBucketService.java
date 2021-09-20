package com.mosh.demo2.service;

import com.mosh.demo2.entity.UserBucket;
import org.springframework.stereotype.Service;


/**
 * (UserBucket)表服务接口
 *
 * @author makejava
 * @since 2021-09-09 12:31:09
 */
@Service
public interface UserBucketService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserBucket queryById(Integer id);


    /**
     * 新增数据
     *
     * @param userBucket 实例对象
     * @return 实例对象
     */
    UserBucket insert(UserBucket userBucket);

    /**
     * 修改数据
     *
     * @param userBucket 实例对象
     * @return 实例对象
     */
    UserBucket update(UserBucket userBucket);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
