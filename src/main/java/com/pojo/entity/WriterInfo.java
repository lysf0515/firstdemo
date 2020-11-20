package com.pojo.entity;


import lombok.Data;

@Data
public class WriterInfo {

  private Integer id;
  /**
   * 用户id
   */
  private Integer userId;
  /**
   * 真实名字
   */
  private String realName;
  /**
   * 身份证号
   */
  private String idcard;
  /**
   * 家庭地址
   */
  private String address;
  /**
   * 银行卡号
   */
  private String bankCard;
  /**
   * 开户行名称
   */
  private String bankName;
  /**
   * 支付宝号
   */
  private String alipay;
  /**
   * 微信号
   */
  private String weixin;
  /**
   * 笔名
   */
  private String penName;


}
