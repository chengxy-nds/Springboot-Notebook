package com.shardingsphere_101.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 订单实体类
 *
 * @author Jiahai
 */
@NoArgsConstructor
@TableName("t_order_item")
@Data
public class OrderItem {
    private Long id;
    private Long itemId;
    private Long orderId;
    private int productId;
    private int quantity;
    private BigDecimal unitPrice;
}