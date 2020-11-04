package com.chengxy.unifiedlog.controller;


import com.alibaba.fastjson.JSON;
import com.chengxy.unifiedlog.config.PrintlnLog;
import com.chengxy.unifiedlog.entity.OrderVO;
import com.chengxy.unifiedlog.service.impl.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PrintlnLog(description = "订单详情Controller")
    @RequestMapping("/order")
    public void getOrder(OrderVO orderVO, String name) {

        log.info("订单详情入参：orderVO={},name={}", JSON.toJSONString(orderVO), name);

        //OrderDTO orderInfo = orderService.getOrderInfo(orderVO);

        log.info("订单详情结果：orderInfo={}", JSON.toJSONString(""));

        //return orderInfo;
    }
}
