package com.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 16477
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Book {
    /**
     * 小说id
     */
    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;
    /**
     * 小说标题
     */
    @NonNull
    private String title;
    /**
     * 小说作者
     */
    @NonNull
    private Integer author;
    @TableField(exist = false)
    private User ower;
    /**
     * 小说简介
     */
    private String summary;
    /**
     * 章节数目
     */
    private Integer chapterCount;
    /**
     * 连载状态 1=连载中， 2=完本
     */
    private Integer processState;
    /**
     * 书籍状态
     */
    private Integer state;
    /**
     * 每千字点数
     */
    private Integer points;
    /**
     * 评分
     */
    private Double score;
    /**
     * 回复数
     */
    private Integer replies;
    /**
     * 当前章节
     */
    private Integer currentChapter;
    /**
     * 发布时间
     */
    private Date publishDate;
    /**
     * 封面
     */
    private String coverPic;
    /**
     * 分类
     */
    private Integer categoryId;
    /**
     * 章节列表
     */
    @TableField(exist = false)
    List<Chapter> chapterList=new ArrayList<>();

}
