package com.springboot101.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value ="用户的PO实体")
@Data
public class User {

    @ApiModelProperty(value="用户名")
    private String name;

    @ApiModelProperty(value="年龄")
    private Integer age;

    @ApiModelProperty(value="邮箱")
    private String email;
}

