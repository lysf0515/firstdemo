package com.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pojo.entity.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:main.xml")
public class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void findByPage(){
        QueryWrapper<Book> wrapper= new QueryWrapper<>();
        Page<Book> page=new Page<>();
//        page.setCurrent(1);
//        page.setSize(100);
        IPage<Book> iPage = bookMapper.selectPage(page,null);
        Assert.assertNotNull(iPage);
    }

    @Test
    public void findList(){
        QueryWrapper<Book> wrapper= new QueryWrapper<>();
        List<Book> books = bookMapper.selectList(wrapper);
        Assert.assertNotNull(books);
    }
}