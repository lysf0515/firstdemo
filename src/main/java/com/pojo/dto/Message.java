package com.pojo.dto;

import lombok.Data;

/**
 * 与layUI适配
 * @author 16477
 * @param <T>
 */
@Data
public class Message<T> {
    /**
     * 表示成功与失败
     * 成功返回true，失败返回false
     */
    String success;
    /**
     * 返回错误码
     * 登录错误：1xxx
     * 数据库错误：2xxx
     */
    private String code;
    /**
     * 返回消息内容
     */
    private String msg;
    /**
     * 返回总页数
     */
    private Long count;
    /**
     * 返回的json数据
     */
    T data;

    /**
     * 返回操作成功的消息对象，一个参数
     * @param data  返回的数据
     * @param <T>   泛型类型
     * @return 返回Message类型
     */
    public static <T> Message<T> successMessage(Long count, T data){
        Message<T> message=new Message<>();
        message.setSuccess("true");
        message.setCode("0");
        message.setCount(count);
        message.setData(data);
        return message;
    }

    /**
     * 返回操作失败的消息对象
     * @param code  错误码
     * @param msg   返回消息内容
     * @param <T>   泛型参数
     * @return
     */
    public static <T> Message<T> errorMessage(String code,String msg){
        Message<T> message=new Message<>();
        message.setSuccess("false");
        message.setCode(code);
        message.setMsg(msg);
        return message;
    }
}
