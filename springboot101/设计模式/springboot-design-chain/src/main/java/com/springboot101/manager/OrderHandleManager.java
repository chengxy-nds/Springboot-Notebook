package com.springboot101.manager;

import com.springboot101.domain.OrderContext;
import com.springboot101.handler.AbstractOrderHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;


/**
 * 订单处理器管理器
 *
 * @author 公众号：程序员小富
 * @date 2023/07/03 11:02
 */
@Component
public class OrderHandleManager {

    @Autowired
    private List<AbstractOrderHandler> orderHandleList;

    @PostConstruct
    public void init() {

        /**
         * 如果处理器List没有按照 @Order 注解方式排序，我们可以通过如下方式手动排序
         */
        // orderHandleList.sort(AnnotationAwareOrderComparator.INSTANCE);

        int size = orderHandleList.size();
        for (int i = 0; i < size; i++) {
            AbstractOrderHandler currentHandler = orderHandleList.get(i);
            if (i == size - 1) {
                currentHandler.setNext(null);
            } else {
                currentHandler.setNext(orderHandleList.get(i + 1));
            }
        }
    }

    public boolean execute(OrderContext context) {
        return orderHandleList.get(0).execute(context);
    }
}