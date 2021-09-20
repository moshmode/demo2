package com.mosh.demo2.controller;

import com.mosh.demo2.entity.UserBucket;
import com.mosh.demo2.service.UserBucketService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (UserBucket)表控制层
 *
 * @author makejava
 * @since 2021-09-09 12:31:08
 */
@RestController
@RequestMapping("userBucket")
public class UserBucketController {
    /**
     * 服务对象
     */
    @Resource
    private UserBucketService userBucketService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<UserBucket> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.userBucketService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param userBucket 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<UserBucket> add(UserBucket userBucket) {
        return ResponseEntity.ok(this.userBucketService.insert(userBucket));
    }

    /**
     * 编辑数据
     *
     * @param userBucket 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<UserBucket> edit(UserBucket userBucket) {
        return ResponseEntity.ok(this.userBucketService.update(userBucket));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.userBucketService.deleteById(id));
    }

}

