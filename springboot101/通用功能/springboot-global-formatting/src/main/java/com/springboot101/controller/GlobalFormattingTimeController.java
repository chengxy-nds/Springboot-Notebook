package com.springboot101.controller;

import com.alibaba.fastjson.JSON;
import com.springboot101.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author: 公众号：程序员小富
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping
public class GlobalFormattingTimeController {

    @RequestMapping("/timeTest")
    public OrderDTO timeTest(OrderDTO orderDTO) {
        OrderDTO dto = new OrderDTO();
        dto.setCreateTime(LocalDateTime.now());
        dto.setUpdateTime(new Date());

        log.info(JSON.toJSONString(dto));
        return dto;
    }
}
