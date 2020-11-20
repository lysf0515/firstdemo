package com.service;

import com.pojo.dto.Message;
import com.pojo.entity.Category;

import java.util.List;

/**
 * @author 16477
 */
public interface CategoryService {
    /**
     * 查询所有的分类名称
     * @return
     */
    Message<List<Category>> categoryList();
}
