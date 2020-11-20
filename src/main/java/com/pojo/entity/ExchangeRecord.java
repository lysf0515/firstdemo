package com.pojo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 16477
 */
@Data
public class ExchangeRecord {
    private Integer userId;
    /**
     * 人民币
     */
    private Integer money;
    /**
     * 点数
     */
    private Integer point;
    /**
     * 兑换标准
     */
    private Integer exchangeTypeId;
    /**
     * 兑换时间
     */
    private Date exchangeDate;
}
