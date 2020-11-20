package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pojo.entity.User;

/**
 * @author 16477
 */
public interface UserMapper extends BaseMapper<User> {
    Integer add(User user);
}
