package com.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Record {
    private Integer id;
    /**
     * 书籍编号
     */
    private Integer bookId;
    /**
     * 章节编号
     */
    private Integer chapterId;
    /**
     * 字数
     */
    private Integer words;
    /**
     * 阅读时间
     */
    private Date readDate;
    /**
     * 阅读人
     */
    private Integer userId;
}
