package com.pojo.vo;

import com.pojo.entity.User;
import lombok.Data;

/**
 * @author 16477
 */
@Data
public class UserVo extends User {
    private int page;
    private int rows;
}
