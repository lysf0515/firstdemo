package com.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author 16477
 */
@Data
@NoArgsConstructor
public class User {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 姓名
     */
    @NonNull private String name;
    private Integer roleId;
    /**
     * 电话
     */
    @NonNull private String phone;
    /**
     * 邮箱
     */
    @NonNull private String email;
    /**
     * 状态，1=注册，2=激活，3=注销，0=内置
     */
    private Integer state;
    /**
     * 微信号
     */
    private String weixin;
    /**
     * qq号
     */
    private String qq;
    /**
     * 用户的系统编号
     */
    private String uuid;
    /**
     * 密码
     */
    @NonNull private String password;
//    private Role role;
//    private WriterInfo writerInfo;
}
