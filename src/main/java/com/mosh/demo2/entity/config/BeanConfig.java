package com.mosh.demo2.entity.config;

import com.mosh.demo2.entity.Menu.FinalMenu;
import com.mosh.demo2.entity.Menu.Menu;
import com.mosh.demo2.entity.Menu.MulMenu;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description
 *
 * @author mosh
 * @date 2021/9/20 21:52
 */
@Configuration
public class BeanConfig {

    @Bean
    public List<Menu> admin() throws OperationNotSupportedException {
        ArrayList<Menu> list = new ArrayList<>();

        Menu users = users();
        users.addChildren(userList());

        Menu rights = rights();
        rights.addChildren(rightList());
        rights.addChildren(roleList());

        Menu goods = goods();
        goods.addChildren(goodsList());
        goods.addChildren(classifyParams());
        goods.addChildren(classifyGoods());

        Menu orders = orders();
        orders.addChildren(ordersList());

        Menu reports = reports();


        list.add(users);
        list.add(rights);
        list.add(goods);
        list.add(orders);
        list.add(reports);
        return list;
    }


    public Menu users() {
        return new MulMenu(1, "用户管理", "users");
    }

    public Menu rights() {
        return new MulMenu(2, "权限管理", "rights");
    }

    public Menu goods() {
        return new MulMenu(3, "商品管理", "goods");
    }

    public Menu orders() {
        return new MulMenu(4, "订单管理", "orders");
    }

    public Menu reports() {
        return new MulMenu(5, "数据统计", "reports");
    }

    public Menu userList() {
        return new FinalMenu(11, "用户列表", "userList");
    }

    public Menu rightList() {
        return new FinalMenu(21, "权限列表", "rightList");
    }

    public Menu roleList() {
        return new FinalMenu(22, "角色列表", "roleList");
    }

    public Menu goodsList() {
        return new FinalMenu(31, "商品列表", "goodsList");
    }

    public Menu classifyParams() {
        return new FinalMenu(32, "分类参数", "classifyParams");
    }

    public Menu classifyGoods() {
        return new FinalMenu(33, "商品分类", "classifyGoods");
    }

    public Menu ordersList() {
        return new FinalMenu(41, "订单列表", "ordersList");
    }

}
