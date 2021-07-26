package com.xiaofu.model;

import lombok.Data;

/**
 * @Auther: zhifu.xin@ipinyou.com
 * @Date: 2021/7/26 15:10
 * @Description:
 */
@Data
public class UserDto {

    private Long userId;

    private String mobile;

    private String address;

    private String age;
}
