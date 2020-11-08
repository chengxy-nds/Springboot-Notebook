package com.xiaofu.sharding.contoller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaofu.sharding.mapper.ConfigRepository;
import com.xiaofu.sharding.mapper.OrderItemRepository;
import com.xiaofu.sharding.mapper.OrderRepository;
import com.xiaofu.sharding.model.TConfig;
import com.xiaofu.sharding.model.TOrder;
import com.xiaofu.sharding.model.TOrderDto;
import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author: xiaofu
 * @Description:
 */
@Controller
@RequestMapping
public class TestController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ConfigRepository configRepository;

    @GetMapping(value = "/insertOrder")
    @ResponseBody
    public String insertOrder() {

        for (int i = 0; i < 5; i++) {
//            HintManager.clear();
//            HintManager hintManager = HintManager.getInstance();
//            hintManager.setDatabaseShardingValue(1);
//            hintManager.addTableShardingValue("t_order" , 0);
//            hintManager.addTableShardingValue("t_order" , 1);
//            hintManager.addTableShardingValue("t_order" , 2);

            TOrder order = new TOrder();
            order.setOrderNo("A000" + i);
            order.setCreateName("订单 " + i);
            order.setUserId(Long.parseLong(i + ""));
            order.setPrice(new BigDecimal("" + i));
            orderRepository.insert(order);

//            TOrderItem orderItem = new TOrderItem();
//            orderItem.setOrderId(order.getOrderId());
//            orderItem.setOrderNo("A000" + i);
//            orderItem.setItemName("服务项目" + i);
//            orderItem.setPrice(new BigDecimal("" + i));
//            orderItemRepository.insert(orderItem);
        }
        return "success";
    }

    @GetMapping(value = "/config")
    @ResponseBody
    public String config() {

        TConfig tConfig = new TConfig();
        tConfig.setRemark("我是广播表");
        tConfig.setCreateTime(new Date());
        tConfig.setLastModifyTime(new Date());
        configRepository.insert(tConfig);
        return "success";
    }


    @GetMapping(value = "/getOneOrder")
    @ResponseBody
    public String getOne(String orderId) {
        return JSON.toJSONString(orderRepository.selectById(Long.parseLong(orderId)));
    }


    @GetMapping(value = "/selectOrderAndItemByOrderId")
    @ResponseBody
    public String selectOrderAndItemByOrderId(String orderId) {
        TOrderDto tOrder = new TOrderDto();
        if (!StringUtils.isEmpty(orderId)) {
            tOrder.setOrderId(Long.parseLong(orderId));
        }
        return JSON.toJSONString(orderRepository.selectOrderAndItemByOrderId(tOrder));
    }

    @GetMapping("/orderList")
    @ResponseBody
    public Object list() {
        return orderRepository.selectList(new QueryWrapper<>());
    }

    @GetMapping(value = "/selectOrderListPage")
    @ResponseBody
    public List<TOrderDto> selectOrderListPage() {


        return orderRepository.selectOrderListPage();
    }

    public static void main(String[] args) {

    }
}
