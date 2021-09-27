package com.mosh.demo2.controller;

import com.google.gson.Gson;
import com.mosh.demo2.annotation.AdminToken;
import com.mosh.demo2.entity.Role;
import com.mosh.demo2.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Role)表控制层
 *
 * @author makejava
 * @since 2021-09-24 21:32:24
 */
@RestController
@RequestMapping("role")
public class RoleController {
    /**
     * 服务对象
     */
    @Resource
    private RoleService roleService;


    /**
     * 查询role列表
     *
     * @return 单条数据
     */
    @AdminToken
    @GetMapping("/listRole")
    public List<Role> listRole() {
        return roleService.queryAll();
    }


    /**
     * 通过主键编辑单条数据
     *
     * @param role 实例对象
     * @return 编辑情况
     */
    @AdminToken
    @PostMapping("/editRole")
    public String editRole(Role role) {

        try {
            roleService.update(role);
        } catch (Exception e) {
            e.printStackTrace();
            String message = "update failure";
            return new Gson().toJson(message);
        }
        return "update successfully";

    }

    /**
     * 通过主键删除单条数据
     *
     * @param id 主键
     * @return 删除情况
     */
    @AdminToken
    @GetMapping("/deleteRole")
    public String deleteRole(@RequestParam("id") Integer id) {

        try {
            roleService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            String message = "delete failure";
            return new Gson().toJson(message);
        }
        return "delete successfully";
    }
    /**
     * 通过增加单条数据
     *
     * @param name 名字
     * @return 删除情况
     */
    @AdminToken
    @PostMapping("/addRole")
    public String addRole(@RequestParam("name") String name) {

        try {
            roleService.insert(name);
        } catch (Exception e) {
            e.printStackTrace();
            String message = "add failure";
            return new Gson().toJson(message);
        }
        return "add successfully";

    }

}

