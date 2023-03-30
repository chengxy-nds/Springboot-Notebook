package io.seata.sample.entity;


import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单
 * @author 小富 ，公众号：程序员内点事
 */
@Data
public class Order {

    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    /**订单状态：0：创建中；1：已完结*/
    private Integer status;

}
