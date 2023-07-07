package com.springboot101.handler;

import com.springboot101.domain.OrderContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 订单参数校验处理器
 *
 * @author 公众号：程序员小富
 * @date 2023/07/03 11:02
 */
@Order(1)
@Component
public class ValidOrderHandler extends AbstractOrderHandler {

    @Override
    public boolean handle(OrderContext context) {
        if (context.getAmount() < 0) {
            System.out.println("下单数量超出限定，请检查参数！");
            return false;
        }
        return true;
    }
}