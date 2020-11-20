package com.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Reply {
    private Integer id;
    /**
     * 书籍编号
     */
    private Integer bookId;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 星级
     */
    private Integer star;
    /**
     * 发表时间
     */
    private Date publishDate;
    /**
     * 上级评论
     */
    private Integer parentId;
    /**
     * 评论层次
     */
    private Integer level;

}
