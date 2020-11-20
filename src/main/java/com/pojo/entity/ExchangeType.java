package com.pojo.entity;


import lombok.Data;

import java.util.Date;

/**
 * @author 16477
 */
@Data
public class ExchangeType {
    private Integer id;
    /**
     * 人民币
     */
    private Integer money;
    /**
     * 点数
     */
    private Integer points;
    /**
     * 状态 1=启用  2=停用
     */
    private Integer state;
    /**
     * 发布时间
     */
    private Date publishDate;
}
