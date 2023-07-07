package com.springboot101.handler;

import com.springboot101.domain.OrderContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * 订单重复下单处理器
 *
 * @author 公众号：程序员小富
 * @date 2023/07/03 11:02
 */
@Order(2)
@Component
public class RepeatOrderHandler extends AbstractOrderHandler {

    @Override
    public boolean handle(OrderContext context) {
        // redis get SeqId value
        if (true) {
            System.out.println("请勿重复下单！");
            return false;
        }
        return true;
    }
}
