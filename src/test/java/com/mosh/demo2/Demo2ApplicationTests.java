package com.mosh.demo2;

import com.mosh.demo2.entity.User;
import com.mosh.demo2.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class Demo2ApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        User user = userService.queryById(1);
        System.out.println(user);
    }



}
