package com.springboot101.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "用户实体类", description = "用于存放用户登录信息")
@Data
public class User {

    @ApiModelProperty(value = "用户名字段", required = true, example = "#公众号：程序员小富", name = "1111")
    private String name;

    @ApiModelProperty(value = "年龄", required = true, example = "19")
    private Integer age;

    @ApiModelProperty(value = "邮箱", required = true, example = "#公众号：程序员小富")
    private String email;
}

