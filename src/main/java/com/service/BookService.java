package com.service;

import com.pojo.dto.Message;
import com.pojo.vo.BookVo;

import java.util.List;

/**
 * @author 16477
 */
public interface BookService {
    /**
     * 查询所有书籍
     * @param book
     * @return
     */
    Message<List<BookVo>> list(BookVo book);

    /**
     * 根据id查找书籍
     * @param id
     * @return
     */
    Message<BookVo> get(Integer id);

    /**
     * 根据id进行和更新
     * @param book
     * @return
     */
    Message<BookVo> edit(BookVo book);

    /**
     * 添加书籍
     * @param book
     * @return
     */
    Message<BookVo> add(BookVo book);
;

    /**
     * 根据id删除书籍
     * @param id
     * @return
     */
    Integer delete(Integer id);
}
