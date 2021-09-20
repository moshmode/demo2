package com.mosh.demo2.entity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.Data;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2021-09-09 12:17:07
 */
@Data
public class User {

    private Integer id;

    private String name;

    private String password;

    private String email;

    public String getToken() {
        return JWT.create().withAudience(String.valueOf(this.id)).sign(Algorithm.HMAC256(this.password));
    }

}

