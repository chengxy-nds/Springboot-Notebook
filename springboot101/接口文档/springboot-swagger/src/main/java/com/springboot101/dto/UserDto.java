package com.springboot101.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {

    private String name;

    private Integer age;

    private String email;

    private Date createTime;

    private Date updateTime;
}

