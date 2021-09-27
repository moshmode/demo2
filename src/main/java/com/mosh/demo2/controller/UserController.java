package com.mosh.demo2.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mosh.demo2.annotation.AdminToken;
import com.mosh.demo2.annotation.UserLoginToken;
import com.mosh.demo2.entity.right.MulRight;
import com.mosh.demo2.entity.User;
import com.mosh.demo2.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description
 *
 * @author mosh
 * @date 2021/8/27 11:47
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

//    @Resource
//    private List<MulRight> admin;


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

//    @UserLoginToken
//    @GetMapping("/menu")
//    public List<MulRight> getMenu() {
//        return admin;
//    }

    @UserLoginToken
    @GetMapping("/search")
    public User searchUser(@RequestParam("name") String name) {
        return userService.queryByName(name);
    }

    @UserLoginToken
    @GetMapping("/count")
    public long getCount() {
        return userService.count(new User());
    }


    @AdminToken
    @PostMapping("/addUser")
    public String addUser(User user) {
        if (user.getRole() == null || user.getRole() > 1 || user.getRole() < 0) {
            user.setRole(1);
        }
        try {
            userService.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
            String message = "add failure";
            return new Gson().toJson(message);
        }
        return "add success";
    }

    @AdminToken
    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") Integer id) {
        try {
            userService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            String message = "add failure";
            return new Gson().toJson(message);
        }
        return "delete success";
    }

    @AdminToken
    @PostMapping("/editUser")
    public String editUser(User user) {
        try {
            userService.update(user);
        } catch (Exception e) {
            e.printStackTrace();
            String message = "add failure";
            return new Gson().toJson(message);
        }

        return "update success";
    }

    @AdminToken
    @GetMapping("/listUser")
    public List<User> listUser(@RequestParam("pageNow") Integer pageNow,
                               @RequestParam("pageSize") Integer pageSize) {
        List<User> users;
        try {
            users = userService.queryByPage(pageNow, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return users;
    }


}

