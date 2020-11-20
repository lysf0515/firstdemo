package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mapper.BookMapper;
import com.pojo.dto.Message;
import com.pojo.entity.Book;
import com.pojo.vo.BookVo;
import com.service.BookService;
import com.util.PojoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 16477
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public Message<List<BookVo>> list(BookVo book) {
        Page<Book> page = new Page<>();
        page.setCurrent(book.getPage());
        page.setSize(book.getRows());
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        IPage<Book> resultPage = bookMapper.selectPage(page, wrapper);
        //调用工具类，将entity列表转化成dto列表
        return Message.successMessage(resultPage.getTotal(),
                PojoUtil.copyList(resultPage.getRecords(), BookVo.class));
    }

    @Override
    public Message<BookVo> get(Integer id) {
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        Book book = bookMapper.selectOne(wrapper);
        return Message.successMessage(1L, PojoUtil.copyObject(book, BookVo.class));
    }

    @Override
    public Message<BookVo> edit(BookVo book) {
        int i = bookMapper.updateById(book);
        if (i==0){
            return Message.errorMessage("1001","更新失败");
        }else {
            return Message.successMessage(1L,null);
        }
    }

    @Override
    public Message<BookVo> add(BookVo book) {
        int i = bookMapper.insert(book);
        if (i==0){
            return Message.errorMessage("1001","添加失败");
        }else {
            return Message.successMessage(1L,book);
        }
    }

    @Override
    public Integer delete(Integer id) {
        return bookMapper.deleteById(id);
    }

}
