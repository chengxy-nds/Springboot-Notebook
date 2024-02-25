package com.shardingsphere_101.controller;

import com.shardingsphere_101.dao.OrderItemMapper;
import com.shardingsphere_101.dao.OrderMapper;
import com.shardingsphere_101.entity.Order;
import com.shardingsphere_101.entity.OrderItem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 公众号：程序员小富
 *
 * @author Jiahai
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderItemMapper orderItemMapper;

    @RequestMapping("/test1")
    public String test1() {
        for (int i = 0; i < 3; i++) {
            Order order = new Order();
            order.setOrderNumber("WIN000" + i);
            order.setCustomerId((long) i);
            order.setOrderDate(new Date());
            order.setTotalAmount(new BigDecimal("0" + i));
            orderMapper.insert(order);
//            OrderItem orderItem = new OrderItem();
//            orderItem.setOrderId(order.getOrderId());
//            orderItem.setProductId(i);
//            orderItem.setQuantity(i);
//            orderItem.setUnitPrice(new BigDecimal("0" + i));
//            orderItemMapper.insert(orderItem);
        }
        return "ok";
    }
}