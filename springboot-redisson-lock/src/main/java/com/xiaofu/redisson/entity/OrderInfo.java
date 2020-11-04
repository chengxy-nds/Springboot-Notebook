package com.xiaofu.redisson.entity;

import org.redisson.api.annotation.REntity;
import org.redisson.api.annotation.RId;
import org.redisson.api.annotation.RIndex;

/**
 * @Author: xiaofu
 * @Description:
 */
@REntity
public class OrderInfo {

    @RId
    private Integer id;

    @RIndex
    private String name;

    @RIndex
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
