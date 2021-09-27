package com.mosh.demo2.entity.config;

import com.mosh.demo2.entity.right.FinalRight;
import com.mosh.demo2.entity.right.Right;
import com.mosh.demo2.entity.right.MulRight;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description
 *
 * @author mosh
 * @date 2021/9/20 21:52
 */
@Component
@Configuration(proxyBeanMethods = false)
public class BeanConfig {

    @Bean("1")
    @Scope("prototype")
    public Right users() {
        return new MulRight(1, "用户管理", "users");
    }

    @Bean("2")
    @Scope("prototype")
    public Right rights() {
        return new MulRight(2, "权限管理", "rights");
    }

    @Bean("3")
    @Scope("prototype")
    public Right goods() {
        return new MulRight(3, "商品管理", "goods");
    }

    @Bean("4")
    @Scope("prototype")
    public Right orders() {
        return new MulRight(4, "订单管理", "orders");
    }

    @Bean("5")
    @Scope("prototype")
    public Right reports() {
        return new MulRight(5, "数据统计", "reports");
    }

    @Bean("11")
    @Scope("prototype")
    public Right userList() {
        return new MulRight(11, "用户列表", "userList");
    }

    @Bean("21")
    @Scope("prototype")
    public Right rightList() {
        return new MulRight(21, "权限列表", "rightList");
    }

    @Bean("22")
    @Scope("prototype")
    public Right roleList() {
        return new MulRight(22, "角色列表", "roleList");
    }

    @Bean("31")
    @Scope("prototype")
    public Right goodsList() {
        return new MulRight(31, "商品列表", "goodsList");
    }

    @Bean("32")
    @Scope("prototype")
    public Right classifyParams() {
        return new MulRight(32, "分类参数", "classifyParams");
    }

    @Bean("33")
    @Scope("prototype")
    public Right classifyGoods() {
        return new MulRight(33, "商品分类", "classifyGoods");
    }

    @Bean("41")
    @Scope("prototype")
    public Right ordersList() {
        return new MulRight(41, "订单列表", "ordersList");
    }

    @Bean(name = {"111", "listUser"})
    @Scope("prototype")
    public Right listUser() {
        return new FinalRight(111, "查看用户列表", "listUser");
    }

    @Bean(name = {"112", "editUser"})
    @Scope("prototype")
    public Right editUser() {
        return new FinalRight(112, "编辑用户", "editUser");
    }

    @Bean(name = {"113", "addUser"})
    @Scope("prototype")
    public Right addUser() {
        return new FinalRight(113, "增加用户", "addUser");
    }

    @Bean(name = {"114", "deleteUser"})
    @Scope("prototype")
    public Right deleteUser() {
        return new FinalRight(114, "删除用户", "deleteUser");
    }

    @Bean(name = {"211", "listRight"})
    @Scope("prototype")
    public Right listRight() {
        return new FinalRight(211, "查看权限列表", "listRight");
    }

    @Bean(name = {"221", "listRole"})
    @Scope("prototype")
    public Right listRole() {
        return new FinalRight(221, "查看角色列表", "listRole");
    }

    @Bean(name = {"222", "listRoleRight"})
    @Scope("prototype")
    public Right listRoleRight() {
        return new FinalRight(222, "查看角色权限", "listRoleRight");
    }

    @Bean(name = {"223", "editRole"})
    @Scope("prototype")
    public Right editRole() {
        return new FinalRight(223, "编辑角色", "editRole");
    }

    @Bean(name = {"224", "addRole"})
    @Scope("prototype")
    public Right addRole() {
        return new FinalRight(224, "添加角色", "addRole");
    }

    @Bean(name = {"225", "deleteRole"})
    @Scope("prototype")
    public Right deleteRole() {
        return new FinalRight(225, "删除角色", "deleteRole");
    }

    @Bean(name = {"226", "addRoleRight"})
    @Scope("prototype")
    public Right addRoleRight() {
        return new FinalRight(226, "增加角色权限", "addRoleRight");
    }

    @Bean(name = {"227", "deleteRoleRight"})
    @Scope("prototype")
    public Right deleteRoleRight() {
        return new FinalRight(227, "删除角色权限", "deleteRoleRight");
    }

}
