package com.shardingsphere_101.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单实体类
 */
@NoArgsConstructor
@TableName("t_order")
@Data
public class Order {

    private Long id;
    private Long orderId;
    private String orderNumber;
    private Long customerId;
    private Date orderDate;
    private BigDecimal totalAmount;
}