package com.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chapter {
    private Integer id;
    /**
     * 章节编号
     */
    private Integer chapterId;
    /**
     * 章节内容
     */
    private String content;
    /**
     * 章节字数
     */
    private Integer words;
    /**
     * 发布时间
     */
    private Date publishDate;
    /**
     * 书籍编号
     */
    private Integer bookId;
    /**
     * 书籍对象
     */
    @TableField(exist = false)
    private Book book;
    /**
     * 阅读数
     */
    private Integer readCount;
    /**
     * 评论数
     */
    private Integer replyCount;
    /**
     * 付费状态
     */
    private Integer payState;
    /**
     * 章节标题
     */
    private String title;
}
