package com.mosh.demo2.dao;

import com.mosh.demo2.entity.RoleRight;
import com.mosh.demo2.entity.right.Right;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (RoleRight)表数据库访问层
 *
 * @author makejava
 * @since 2021-09-24 21:44:34
 */
@Mapper
public interface RoleRightDao {

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
    List<RoleRight> queryByRoleId(Integer roleId);


    /**
     * 统计总行数
     *
     * @param roleRight 查询条件
     * @return 总行数
     */
    long count(RoleRight roleRight);

    /**
     * 新增数据
     *
     * @param roleRight 实例对象
     * @return 影响行数
     */
    int insert(RoleRight roleRight);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<RoleRight> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<RoleRight> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<RoleRight> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<RoleRight> entities);

    /**
     * 修改数据
     *
     * @param roleRight 实例对象
     * @return 影响行数
     */
    int update(RoleRight roleRight);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 通过实体删除数据
     *
     * @param roleRight 实体
     * @return 是否成功
     */
    int delete(RoleRight roleRight);

}

