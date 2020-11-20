package com.service;


import com.alibaba.fastjson.JSONObject;
import com.pojo.dto.Message;
import com.pojo.entity.User;
import com.pojo.vo.UserVo;

import java.util.List;

/**
 * 业务逻辑
 * 业务词汇     开发词汇（增删改查）
 *   登录   ->    查询
 *   注册   ->    添加
 *   发布   ->    添加
 * @author 16477
 */
public interface UserService {
    /**
     * 登录功能
     * @param name
     * @param password
     * @return
     */
    User login(String name, String password);

    /**
     * 注册功能
     * @param user
     * @return
     */
    Message<UserVo> register(UserVo user) ;

    /**
     * 查询所有用户清单
     * @param userVo
     * @return
     */
    Message<List<UserVo>> list(UserVo userVo);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    Message<UserVo> update(UserVo user);

    /**
     * 根据id删除单个信息
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 复选操作
     * @param obj
     * @return
     */
    Object delAll(JSONObject obj);
}
