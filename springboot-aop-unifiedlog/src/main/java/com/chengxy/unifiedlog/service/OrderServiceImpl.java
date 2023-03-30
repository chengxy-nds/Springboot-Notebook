package com.chengxy.unifiedlog.service;

import com.chengxy.unifiedlog.entity.OrderDTO;
import com.chengxy.unifiedlog.entity.OrderVO;
import com.chengxy.unifiedlog.service.impl.OrderService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiaofu
 * @Description:
 */
@Component
public class OrderServiceImpl implements OrderService {

    @Override
    public OrderDTO getOrderInfo(OrderVO orderVO) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderNo("A0000001");
        Map<String, Object> map = new HashMap<>();
        map.put("money", 444);
        map.put("shopId", 1002);
        orderDTO.setOrderMap(map);
        return orderDTO;
    }
}
