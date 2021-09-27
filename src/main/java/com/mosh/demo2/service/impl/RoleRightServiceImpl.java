package com.mosh.demo2.service.impl;

import com.mosh.demo2.entity.RoleRight;
import com.mosh.demo2.dao.RoleRightDao;
import com.mosh.demo2.entity.right.Right;
import com.mosh.demo2.service.RoleRightService;
import com.mosh.demo2.util.SpringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

/**
 * (RoleRight)表服务实现类
 *
 * @author makejava
 * @since 2021-09-24 21:44:34
 */
@Service("roleRightService")
public class RoleRightServiceImpl implements RoleRightService {
    @Resource
    private RoleRightDao roleRightDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RoleRight queryById(Integer id) {
        return this.roleRightDao.queryById(id);
    }

    /**
     * 通过实体查询单条数据
     *
     * @param roleRight 实体
     * @return 实例对象
     */
    public RoleRight query(RoleRight roleRight) {
        return this.roleRightDao.query(roleRight);
    }

    /**
     * 通过Right
     *
     * @return 实例对象
     */
    public List<Right> queryRight() {
        return roleRightDao.queryRight();
    }


    /**
     * @param roleId role id
     * @return list
     */
    public List<Right> queryByRoleId(Integer roleId) {

        List<RoleRight> roleRights = roleRightDao.queryByRoleId(roleId);
        List<Right> rightList = new ArrayList<>();
        List<Right> rightList1 = new ArrayList<>();
        List<Right> rightList2 = new ArrayList<>();


        for (RoleRight roleRight : roleRights) {
            int rightId = roleRight.getRightId();
            if (rightId < 10) {
                rightList.add((Right) SpringUtil.getBean(Integer.toString(rightId)));
            } else if (rightId < 100) {
                rightList1.add((Right) SpringUtil.getBean(Integer.toString(rightId)));
            } else {
                rightList2.add((Right) SpringUtil.getBean(Integer.toString(rightId)));
            }

        }
        try {
            for (Right right1 : rightList1) {
                for (Right right2 : rightList2) {
                    if (right2.getId() / 10 == right1.getId()) {
                        right1.addChildren(right2);
                    }
                }
            }
        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }

        try {
            for (Right right : rightList) {
                for (Right right1 : rightList1) {
                    if (right1.getId() / 10 == right.getId()) {
                        right.addChildren(right1);
                    }
                }
            }
        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }
        return rightList;
    }


    /**
     * 新增数据
     *
     * @param roleRight 实例对象
     * @return 实例对象
     */
    @Override
    public RoleRight insert(RoleRight roleRight) {
        this.roleRightDao.insert(roleRight);
        return roleRight;
    }

    /**
     * 修改数据
     *
     * @param roleRight 实例对象
     * @return 实例对象
     */
    @Override
    public RoleRight update(RoleRight roleRight) {
        this.roleRightDao.update(roleRight);
        return this.queryById(roleRight.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.roleRightDao.deleteById(id) > 0;
    }

    /**
     * 通过实体删除数据
     *
     * @param roleRight 实体
     * @return 是否成功
     */
    public boolean delete(RoleRight roleRight) {
        return this.roleRightDao.delete(roleRight) > 0;
    }
}
