package com.shardingsphere_101;

import com.shardingsphere_101.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ApplicationTests {

    @Resource
    private OrderService orderService;

    @Test
    void contextLoads() {
        orderService.save();
    }
}
