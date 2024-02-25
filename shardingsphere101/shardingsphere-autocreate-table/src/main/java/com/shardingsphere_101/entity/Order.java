package com.shardingsphere_101.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单实体类
 */
@Data
@TableName("t_order")
@NoArgsConstructor
public class Order implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long Id;
    private Long orderId;
    private String orderNumber;
    private Long customerId;
    private Date orderDate;
    private BigDecimal totalAmount;
}