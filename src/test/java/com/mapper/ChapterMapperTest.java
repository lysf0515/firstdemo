package com.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pojo.entity.Chapter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:main.xml")
public class ChapterMapperTest {
    @Autowired
    private ChapterMapper chapterMapper;
    @Test
    public void find() {
        QueryWrapper<Chapter> wrapper= new QueryWrapper<>();
        Page<Chapter> page=new Page<>();
//        page.setCurrent(1);
        page.setSize(10);
        IPage<Chapter> iPage = chapterMapper.findWithBook(page,wrapper);
        Assert.assertNotNull(iPage);
    }
}