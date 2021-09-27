package com.mosh.demo2.controller;

import com.google.gson.Gson;
import com.mosh.demo2.annotation.AdminToken;
import com.mosh.demo2.entity.RoleRight;
import com.mosh.demo2.service.RoleRightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (RoleRight)表控制层
 *
 * @author makejava
 * @since 2021-09-24 21:44:34
 */
@RestController
@RequestMapping("roleRight")
public class RoleRightController {
    /**
     * 服务对象
     */
    @Resource
    private RoleRightService roleRightService;


    /**
     * 查询所有Right
     *
     * @return 实例对象
     */
    @AdminToken
    @GetMapping("/listRight")
    public String listRight() {
        return new Gson().toJson(roleRightService.queryRight());
    }


    /**
     * 查询数据
     *
     * @param roleId 角色id
     * @return 查询结果
     */
    @AdminToken
    @GetMapping("/listRoleRight")
    public String listRoleRight(@RequestParam("roleId") Integer roleId) {
        return new Gson().toJson(roleRightService.queryByRoleId(roleId));
    }

    /**
     * 新增数据
     *
     * @param roleRight 实体
     * @return 新增结果
     */
    @AdminToken
    @PostMapping("/addRoleRight")
    public ResponseEntity<RoleRight> addRoleRight(RoleRight roleRight) {
        return ResponseEntity.ok(this.roleRightService.insert(roleRight));
    }


    /**
     * 删除数据
     *
     * @param roleRight 实体
     * @return 删除是否成功
     */
    @AdminToken
    @GetMapping("/deleteRoleRight")
    public ResponseEntity<Boolean> deleteRoleRight(RoleRight roleRight) {
        return ResponseEntity.ok(this.roleRightService.delete(roleRight));
    }

}

