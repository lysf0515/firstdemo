package com.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 16477
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    /**
     * 分类id
     */
    private Integer id;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 排序编号
     */
    private Integer orderNum;
}
