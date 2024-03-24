package com.shardingsphere_101.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单实体类
 */
@Data
@TableName("t_order")
public class OrderPo {

    private Long Id;
    private Long orderId;
    private Long userId;
    private String orderNumber;
    private Long customerId;
    private Date orderDate;
    private BigDecimal totalAmount;
    private String intervalValue;
}