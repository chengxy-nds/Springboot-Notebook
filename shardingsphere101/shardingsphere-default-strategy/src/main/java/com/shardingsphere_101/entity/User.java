package com.shardingsphere_101.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("t_user")
@Data
public class User implements Serializable {

    private Long id;

    private String uName;

    private Integer uAge;

    private String uAddress;

    private Date createTime;

    private Date dateTime;
}
