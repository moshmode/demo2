package com.mosh.demo2;

import com.google.gson.Gson;
import com.mosh.demo2.annotation.UserLoginToken;
import com.mosh.demo2.controller.UserController;
import com.mosh.demo2.dao.RoleRightDao;
import com.mosh.demo2.entity.Role;
import com.mosh.demo2.entity.RoleRight;
import com.mosh.demo2.entity.User;
import com.mosh.demo2.entity.config.BeanConfig;
import com.mosh.demo2.entity.right.Right;
import com.mosh.demo2.service.RoleRightService;
import com.mosh.demo2.service.RoleService;
import com.mosh.demo2.service.UserService;

import com.mosh.demo2.util.SpringUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Method;
import java.util.List;


@SpringBootTest
class Demo2ApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    RoleRightDao roleRightDao;

    @Test
    void contextLoads() {

        User user = new User();
        long count = userService.count(user);
        System.out.println(count);

    }


    @Test
    void demo() {
        RoleRight roleRight = new RoleRight();
        roleRight.setRightId(1);
        System.out.println(roleRight.getRightId());
    }

    @Test
    void demo1() {
        Gson gson = new Gson();
        Role role = roleService.queryById(1);
        System.out.println(gson.toJson(role.getRightList()));
    }

    @Test
    void demo2() {
    }


}
