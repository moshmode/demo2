package com.mosh.demo2.entity;

import com.mosh.demo2.entity.right.Right;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


/**
 * (Role)实体类
 *
 * @author makejava
 * @since 2021-09-24 21:32:24
 */
@Data
public class Role {

    private Integer id;

    private String name;

    private List<Right> rightList = new ArrayList<>();

}

