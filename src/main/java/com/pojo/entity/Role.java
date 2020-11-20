package com.pojo.entity;

import lombok.Data;

import java.util.List;

@Data
public class Role {
    /**
     * 角色id
     */
    private Integer id;
    /**
     * 角色名称
     */
    private String name;
    List<User> userList;
}
