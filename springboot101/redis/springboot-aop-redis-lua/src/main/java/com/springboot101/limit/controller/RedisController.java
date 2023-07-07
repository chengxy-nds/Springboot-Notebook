package com.springboot101.limit.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author: 公众号：程序员小富
 * @Description:
 */
@Controller
public class RedisController {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @GetMapping("/addKey")
    @ResponseBody
    public String addkey() {

        for (int i = 0; i < 500000; i++) {

            redisTemplate.opsForValue().set("test_key_" + i, i);
        }
        return null;
    }

}