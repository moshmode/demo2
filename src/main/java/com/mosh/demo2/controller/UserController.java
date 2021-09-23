package com.mosh.demo2.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mosh.demo2.annotation.UserLoginToken;
import com.mosh.demo2.entity.Menu.MulMenu;
import com.mosh.demo2.entity.User;
import com.mosh.demo2.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2021-09-09 12:17:05
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @Resource
    private List<MulMenu> admin;


    //登录
    @PostMapping("/login")

    public String login(User user) {
        JsonObject jsonObject = new JsonObject();
        Gson gson = new Gson();
        User userForBase = userService.queryByName(user.getName());

        if (userForBase == null) {
            jsonObject.addProperty("message", "登录失败,用户不存在");
            return gson.toJson(jsonObject);
        }
        if (!userForBase.getPassword().equals(user.getPassword())) {
            jsonObject.addProperty("message", "登录失败,密码错误");
            return gson.toJson(jsonObject);
        }

        String token = userForBase.userToken();
        jsonObject.addProperty("token", token);
        jsonObject.add("user", gson.toJsonTree(userForBase));
        return gson.toJson(jsonObject);


    }

    @UserLoginToken
    @GetMapping("/menu")
    public List<MulMenu> getMenu() {
        return admin;
    }

    @UserLoginToken
    @GetMapping("/add")
    public String addUser(User user) {
        if (user.getRight() == null || user.getRight() > 1 || user.getRight() < 0) {
            user.setRight(1);
        }
        try {
            userService.insert(user);
        } catch (Exception e) {
            return "failure";
        }
        return "success";
    }

    @UserLoginToken
    @GetMapping("/list")
    public List<User> userList(@RequestParam("pageNow") Integer pageNow,
                               @RequestParam("pageSize") Integer pageSize) {
        List<User> users;
        try {
            users = userService.queryByPage(pageNow, pageSize);
        } catch (Exception e) {
            return null;
        }
        return users;
    }


}

