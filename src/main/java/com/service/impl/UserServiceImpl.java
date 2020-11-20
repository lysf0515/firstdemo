package com.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mapper.UserMapper;
import com.pojo.dto.Message;
import com.pojo.entity.User;
import com.pojo.vo.UserVo;
import com.service.UserService;
import com.util.PojoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Component      //最通用的注解  相当于bean
//@Controller     //用于控制层
//@Repository     //用于dao层


/**
 * 用户实现类
 *
 * @author 16477
 */
@Service        //用于业务层
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String name, String password) {
        return null;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Message<UserVo> register(UserVo userVo) {
        int i = userMapper.insert(userVo);
        if (i==0){
            return Message.errorMessage("1001","添加失败");
        }else {
            return Message.successMessage(1L,userVo);
        }
    }

    @Override
    public Message<List<UserVo>> list(UserVo userVo) {
        Page<User> page = new Page<>();
        page.setCurrent(userVo.getPage());
        page.setSize(userVo.getRows());
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (userVo.getName()!=null&&userVo.getName().trim().length()!=0) {
            wrapper.likeRight("name", userVo.getName());
        }
        if (userVo.getPhone()!=null&&userVo.getPhone().trim().length()!=0) {
            wrapper.eq("phone", userVo.getPhone());
        }
        if (userVo.getEmail()!=null&&userVo.getEmail().trim().length()!=0){
        wrapper.eq("email",userVo.getEmail());
        }
        IPage<User> resultPage=userMapper.selectPage(page,wrapper);
        return Message.successMessage(resultPage.getTotal(),
                PojoUtil.copyList(resultPage.getRecords(), UserVo.class));
    }

    @Override
    public Message<UserVo> update(UserVo user) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public Object delAll(JSONObject obj) {
        Map<String,Object> maps = new HashMap<>();
        //将json对象序列化为json字符串
        String data = obj.toJSONString();
        //将json字符串反序列化为json字符串
        JSONObject json = JSON.parseObject(data);
        //解析json数据
        String ids = obj.getString("listId");
        JSONArray idsArray=JSONArray.parseArray(ids);
        for(int i=0;i<idsArray.size();i++){
            userMapper.deleteById(Long.valueOf(idsArray.get(i).toString()));
            System.out.println("========="+ idsArray.get(i));
            maps.put("count",1);
        }
        return maps;
    }
}
