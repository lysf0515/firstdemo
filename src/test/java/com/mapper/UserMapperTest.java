package com.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pojo.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:main.xml")
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void query(){
        //Bean,实体Bean，传输Bean，业务Bean
        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.eq("name","abc1122");
//        wrapper.like("name","abc");
        wrapper.likeRight("name","张");
//        wrapper.between("id",5,8);

        List<User> users = userMapper.selectList(wrapper);
        Assert.assertNotNull(users);
        Assert.assertEquals(1,users.size());
    }

    @Test
    public void lambdaQuery(){
        LambdaQueryWrapper<User> wrapper=new LambdaQueryWrapper<>();
        wrapper.likeRight(User::getName,"张");
        List<User> users = userMapper.selectList(wrapper);
        Assert.assertNotNull(users);
        Assert.assertEquals(1,users.size());
    }


    @Test
    public void findByPage(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.likeRight("name","张");
        Page<User> page=new Page<>();
        page.setCurrent(1);
        page.setSize(1);
        //第一个参数既是输入参数也是输出参数
        userMapper.selectPage(page,wrapper);
        Assert.assertNotNull(page.getRecords());

    }
    @Test
    public void find() {
        List<User> users = userMapper.selectList(null);
        Assert.assertNotNull(users);
        Assert.assertEquals(16,users.size());
    }
    @Test
    public void add() {
        User user=new User();
        user.setName("abc");
        user.setPassword("123");
        user.setPhone("1111");
        user.setEmail("abc@abc.com");
        int i = userMapper.add(user);
        Assert.assertNotNull(i);
    }

    /**
     * 根据传入参数进行动态更新
     */
    @Test
    public void update() {
        User user=new User();
        user.setId(16);
        user.setName("abc1122");
        user.setPassword("123");

        int i = userMapper.updateById(user);
        Assert.assertNotNull(i);
    }
    @Test
    public void delete() {
        int i = userMapper.deleteById(17);
        Assert.assertNotNull(i);
    }
}