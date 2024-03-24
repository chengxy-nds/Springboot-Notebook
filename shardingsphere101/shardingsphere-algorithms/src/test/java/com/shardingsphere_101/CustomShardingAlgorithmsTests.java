package com.shardingsphere_101;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shardingsphere_101.dao.OrderMapper;
import com.shardingsphere_101.entity.OrderPo;
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
 * 自动义分片算法测试类
 *
 * @author 公众号：程序员小富
 * @date 2023/12/31 17:25
 */
@SpringBootTest
class CustomShardingAlgorithmsTests {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private OrderMapper orderMapper;

    @DisplayName("测试自定义标准分片算法插入数据")
    @Test
    public void orderComplexCustomAlgorithmTest() {

        int randomId = RandomUtils.nextInt();
        OrderPo order = new OrderPo();
        order.setOrderId(1L);
        order.setUserId(1L);
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
    @DisplayName("查询标准策略")
    @Test
    public void queryTableTest() {
        QueryWrapper<OrderPo> queryWrapper = new QueryWrapper<OrderPo>()
                .le("order_id", 10)
                        .ge("order_id", 1);

//                .eq("id", 1771023476480950274L);
        List<OrderPo> orderPos = orderMapper.selectList(queryWrapper);
        System.out.println(orderPos);
    }
}
