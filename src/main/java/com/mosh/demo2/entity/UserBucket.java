package com.mosh.demo2.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (UserBucket)实体类
 *
 * @author makejava
 * @since 2021-09-09 12:31:08
 */
@Data
public class UserBucket{
    
    private Integer id;
    
    private Integer userId;
    
    private String privateBucket;
    
    private String groupBucket;

}

