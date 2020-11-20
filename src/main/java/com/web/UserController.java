package com.web;


import com.alibaba.fastjson.JSONObject;
import com.pojo.dto.Message;
import com.pojo.entity.User;
import com.pojo.vo.UserVo;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 16477
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public Message<List<UserVo>> list(UserVo user) {
        return userService.list(user);
    }

    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public Message<UserVo> reg(UserVo userVo)  {
        return userService.register(userVo);
    }
    @RequestMapping(value = "/users/update",method = RequestMethod.POST)
    public Message<User> update(UserVo userVo)  {
        userService.update(userVo);
        Message<User> message=new Message<>();
        message.setCode("ok");
        return message;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/users/user/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable int id) {
        return userService.delete(id);
    }

    /**
     * 复选删除
     * @param
     * @return
     */
    @RequestMapping(value = "/users/del", method = RequestMethod.DELETE)
    public Object delAll(@RequestBody JSONObject obj) {
        return  userService.delAll(obj);
    }
}
