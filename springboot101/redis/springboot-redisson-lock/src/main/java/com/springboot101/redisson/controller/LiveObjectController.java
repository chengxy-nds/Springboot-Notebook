package com.springboot101.redisson.controller;


import com.springboot101.redisson.entity.OrderInfo;
import org.redisson.api.RLiveObjectService;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 公众号：程序员小富
 * @Description:
 */
@Controller
@RequestMapping
public class LiveObjectController {


    @Autowired
    private RedissonClient redissonClient;

    @RequestMapping("/liveObject")
    @ResponseBody
    public String reduceStock() {

        RLiveObjectService service = redissonClient.getLiveObjectService();
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(1);
        orderInfo.setName("小富111");
        orderInfo.setAge(16);

        OrderInfo orderInfo2 = new OrderInfo();
        orderInfo2.setId(2);
        orderInfo2.setName("小瑞");
        orderInfo2.setAge(16);

        // 将orderInfo对象当前的状态持久化到Redis里并与之保持同步。
//        if (!service.isExists(orderInfo)) {
//            orderInfo = service.persist(orderInfo);
//        }
//        if (!service.isExists(orderInfo2)) {
//            orderInfo2 = service.persist(orderInfo2);
//        }

        // 抛弃orderInfo对象当前的状态，并与Redis里的数据建立连接并保持同步。
        orderInfo.setId(1);
        orderInfo = service.attach(orderInfo);

        // 将orderInfo对象当前的状态与Redis里的数据合并之后与之保持同步。
        //orderInfo = service.merge(orderInfo);

        return null;
    }

}
