package com.mosh.demo2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

/**
 * (RoleRight)实体类
 *
 * @author makejava
 * @since 2021-09-24 21:44:34
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class RoleRight {

    private Integer id;

    @NotNull
    private Integer roleId;

    @NotNull
    private Integer rightId;


}

