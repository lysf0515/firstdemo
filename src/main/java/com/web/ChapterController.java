package com.web;

import com.pojo.dto.Message;
import com.pojo.entity.Category;
import com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 章节类
 * @author 16477
 */
@RestController
public class ChapterController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/categories",method = RequestMethod.GET)
    public Message<List<Category>> find(){
        Message<List<Category>> list = categoryService.categoryList();
        return list;
    }
}
