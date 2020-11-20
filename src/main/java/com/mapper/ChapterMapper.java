package com.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pojo.entity.Chapter;

public interface ChapterMapper extends BaseMapper<Chapter> {
    IPage<Chapter> findWithBook(IPage<Chapter> page, QueryWrapper<Chapter> wrapper);
}
