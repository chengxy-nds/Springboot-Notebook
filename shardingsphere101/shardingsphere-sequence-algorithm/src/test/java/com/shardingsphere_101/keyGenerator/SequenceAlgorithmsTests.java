package com.shardingsphere_101.keyGenerator;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shardingsphere_101.keyGenerator.dao.OrderMapper;
import com.shardingsphere_101.keyGenerator.entity.OrderPo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 分布式ID测试类
 *
 * @author 公众号：程序员小富
 * @date 2023/12/31 17:25
 */
@Slf4j
@DisplayName("分布式ID测试类")
@SpringBootTest
class SequenceAlgorithmsTests {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private OrderMapper orderMapper;

    @DisplayName("测试分布式ID生成算法插入数据")
    @Test
    public void orderComplexCustomAlgorithmTest() {

        int randomId = RandomUtils.nextInt();
        OrderPo order = new OrderPo();
        order.setOrderId(20L);
        order.setUserId(100L);
        order.setOrderNumber(String.valueOf(randomId));
        order.setCustomerId((long) randomId);
        order.setOrderDate(new Date());
        order.setTotalAmount(new BigDecimal("0"));
        order.setIntervalValue("2024-03-01 00:00:00");
        orderMapper.insert(order);
    }

    /**
     * 查询标准策略
     *
     * @author 公众号：程序员小富
     */
    @DisplayName("自动义分片算法-范围查询")
    @Test
    public void queryTableTest() {
        QueryWrapper<OrderPo> queryWrapper = new QueryWrapper<OrderPo>()
                .eq("order_id", 20L)
                .eq("id", 20L);
        queryWrapper.orderByAsc("order_id");
        List<OrderPo> orderPos = orderMapper.selectList(queryWrapper);
        log.info("查询结果：{}", JSON.toJSONString(orderPos));
    }
}
