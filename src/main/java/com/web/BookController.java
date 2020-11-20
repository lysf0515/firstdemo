package com.web;

import com.pojo.dto.Message;
import com.pojo.vo.BookVo;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Rest风格  前后端分离
 *
 * @author 16477
 */
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    /**
     * dto(Controller,Service) 用于传输数据，entity，用于映射数据库表
     *
     * @param book
     * @param model
     * @return
     */
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public Message<List<BookVo>> find(BookVo book, Map model) {
        return bookService.list(book);
    }

    /**
     * 根据id查询
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/books/book/{id}", method = RequestMethod.GET)
    public Message<BookVo> get(@PathVariable int id, Map model) {
        return bookService.get(id);
    }

    /**
     * 更新
     *
     * @param book
     * @return
     */
    @RequestMapping(value = "/books/book", method = RequestMethod.POST)
    public Message<BookVo> update(BookVo book) {
        return bookService.edit(book);
    }

    /**
     * 添加
     *
     * @param book
     * @return
     */
    @RequestMapping(value = "/books/book", method = RequestMethod.PUT)
    public Message<BookVo> add(BookVo book) {
        return bookService.add(book);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/books/book/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable int id) {
        return bookService.delete(id);
    }
}
