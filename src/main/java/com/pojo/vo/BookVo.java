package com.pojo.vo;

import lombok.Data;

/**
 * 作为传输 对象 封装请求参数   传输Bean
 * @author 16477
 */
@Data
public class BookVo extends com.pojo.entity.Book {
   private int page;
   private int rows;
}
