package com.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Payment {
    private Integer id;
    /**
     * 用户id
     */
    private String uuid;
    /**
     * 支付日期
     */
    private Date payDate;
    /**
     * 支付周期
     */
    private String period;
    /**
     * 支付金额
     */
    private Integer money;
    /**
     * 支付状态 1=申请，2=审批，3=已支付，4=取消
     */
    private Integer state;
    /**
     * 审批人id
     */
    private Integer approveId;
    /**
     * 审批日期
     */
    private Date approveDate;
}
