package com.xiaofu.sharding.model;

import lombok.Data;

import java.util.Date;

@Data
public class TConfig {

    private Long id;

    private String remark;

    private Date createTime;

    private Date lastModifyTime;
}