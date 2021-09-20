package com.mosh.demo2.dao;

import com.mosh.demo2.entity.UserBucket;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (UserBucket)表数据库访问层
 *
 * @author makejava
 * @since 2021-09-09 12:31:08
 */
@Mapper
public interface UserBucketDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserBucket queryById(Integer id);

    /**
     * 统计总行数
     *
     * @param userBucket 查询条件
     * @return 总行数
     */
    long count(UserBucket userBucket);

    /**
     * 新增数据
     *
     * @param userBucket 实例对象
     * @return 影响行数
     */
    int insert(UserBucket userBucket);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserBucket> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UserBucket> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserBucket> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<UserBucket> entities);

    /**
     * 修改数据
     *
     * @param userBucket 实例对象
     * @return 影响行数
     */
    int update(UserBucket userBucket);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

