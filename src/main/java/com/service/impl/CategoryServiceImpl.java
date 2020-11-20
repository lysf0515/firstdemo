package com.service.impl;

import com.pojo.entity.Category;
import com.mapper.CategoryMapper;
import com.service.CategoryService;
import com.pojo.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public Message<List<Category>> categoryList() {
        List<Category> list = categoryMapper.selectList(null);
        return Message.successMessage(1L,list);
    }
}
