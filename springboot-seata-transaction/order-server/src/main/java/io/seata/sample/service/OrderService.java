package io.seata.sample.service;

import io.seata.sample.entity.Order;
import java.math.BigDecimal;

/**
 * @author 小富 ，公众号：程序员内点事
 */
public interface OrderService {

    /**
     * 创建订单
     * @param order
     * @return
     */
    void create(Order order);

    /**
     * 修改订单状态
     * @param userId
     * @param money
     * @param status
     */
    void update(Long userId,BigDecimal money,Integer status);
}
