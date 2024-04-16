package com.shardingsphere_101;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shardingsphere_101.dao.OrderMapper;
import com.shardingsphere_101.entity.OrderPo;
import org.apache.commons.lang3.RandomUtils;
import org.apache.shardingsphere.infra.hint.HintManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 分片算法测试类
 *
 * @author 公众号：程序员小富
 * @date 2023/12/31 17:25
 */
@DisplayName("分片算法测试类")
@SpringBootTest
class ShardingAlgorithmsTests {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private OrderMapper orderMapper;

    /**
     * 执行创建逻辑表的SQL，会根据AutoTables的配置自动在对应的数据源内创建分片表
     *
     * @author 公众号：程序员小富
     */
    @DisplayName("创建分片表")
    @Test
    public void autoCreateOrderTableAlgorithmsTest() {
        jdbcTemplate.execute("CREATE TABLE `t_order` (\n" + "  `id` bigint(20) NOT NULL,\n" + "  `order_id` bigint(20) NOT NULL,\n" + "  `user_id` bigint(20) NOT NULL,\n" + "  `order_number` varchar(255) NOT NULL,\n" + "  `customer_id` bigint(20) NOT NULL,\n" + "  `order_date` datetime  default NULL,\n" + "  `interval_value` varchar(125)  default NULL,\n" + "  `total_amount` decimal(10,2) NOT NULL,\n" + "  PRIMARY KEY (`order_id`) USING BTREE\n" + ");");
    }

    /**
     * 删除 t_order 表
     *
     * @author 公众号：程序员小富
     */
    @DisplayName("删除分片表")
    @Test
    public void autoDeleteOrderTableAlgorithmsTest() {
        jdbcTemplate.execute("DROP TABLE `t_order`;");
    }

    @DisplayName("测试t_order_id插入数据")
    @Test
    public void insertTableTest() {

        for (int i = 1; i <= 40; i++) {
            int randomId = RandomUtils.nextInt();
            OrderPo order = new OrderPo();
            order.setOrderId((long) i);
            order.setUserId((long) i);
            order.setOrderNumber(String.valueOf(randomId));
            order.setCustomerId((long) randomId);
            order.setOrderDate(new Date());
            order.setTotalAmount(new BigDecimal("0"));
            order.setIntervalValue("2024-03-01 00:00:00");
            orderMapper.insert(order);
        }
    }

    /**
     * 查询标准策略
     *
     * @author 公众号：程序员小富
     */
    @DisplayName("查询标准策略")
    @Test
    public void queryTableTest() {
        QueryWrapper<OrderPo> queryWrapper = new QueryWrapper<OrderPo>().eq("order_id", 9).eq("id", 1769988936014688257L);
        OrderPo orderPo = orderMapper.selectOne(queryWrapper);
        System.out.println(orderPo.getId());
    }

    @DisplayName("测试 AUTO_INTERVAL 时间分片算法插入数据")
    @Test
    public void insertAutoIntervalDateTableTest() {
        // 放入 t_order_0 分片表
        jdbcTemplate.execute("INSERT INTO `t_order`(`id`,`order_date`,`order_id`, `order_number`, `customer_id`, `total_amount`, `interval_value`, `user_id`) VALUES (1, '2023-03-20 00:00:00', 1, '1', 1, 1.00 , '2024-01-01 00:00:00', 1);");

        // 放入 t_order_1 分片表
        jdbcTemplate.execute("INSERT INTO `t_order`(`id`,`order_date`,`order_id`, `order_number`, `customer_id`, `total_amount`, `interval_value`, `user_id`) VALUES (2, '2024-03-20 00:00:00', 2, '2', 2,1.00 , '2024-01-01 00:00:00', 1);");
        jdbcTemplate.execute("INSERT INTO `t_order`(`id`,`order_date`,`order_id`, `order_number`, `customer_id`, `total_amount`, `interval_value`, `user_id`) VALUES (3, '2024-03-20 00:00:00', 3, '3', 3, 1.00 , '2024-01-01 00:00:00', 1);");

        // 放入 t_order_2 分片表
        jdbcTemplate.execute("INSERT INTO `t_order`(`id`,`order_date`,`order_id`, `order_number`, `customer_id`, `total_amount`, `interval_value`, `user_id`) VALUES (4,'2025-03-20 00:00:00',4, '4', 4, 1.00 , '2024-01-01 00:00:00', 1);");
        jdbcTemplate.execute("INSERT INTO `t_order`(`id`,`order_date`,`order_id`, `order_number`, `customer_id`, `total_amount`, `interval_value`, `user_id`) VALUES (5,'2025-03-20 00:00:00',5, '5', 5,  1.00 , '2024-01-01 00:00:00', 1);");

        // 放入 t_order_3 分片表
        jdbcTemplate.execute("INSERT INTO `t_order`(`id`,`order_date`,`order_id`, `order_number`, `customer_id`, `total_amount`, `interval_value`, `user_id`) VALUES (6,'2026-03-20 00:00:00',6, '6', 6,  1.00 , '2024-01-01 00:00:00', 1);");
        jdbcTemplate.execute("INSERT INTO `t_order`(`id`,`order_date`,`order_id`, `order_number`, `customer_id`, `total_amount`, `interval_value`, `user_id`) VALUES (7,'2027-03-20 11:19:58',7, '7', 7,  1.00 , '2024-01-01 00:00:00', 1);");
    }


    @DisplayName("测试 interval 时间范围分片算法插入数据")
    @Test
    public void insertIntervalDateTableTest() {
        // 放入 t_order_202401 分片表
        jdbcTemplate.execute("INSERT INTO `t_order`(`id`,`order_date`,`order_id`, `order_number`, `customer_id`, `total_amount`, `interval_value`, `user_id`) VALUES (1, '2024-03-20 00:00:00', 1, '1', 1, 1.00, '2024-01-01 00:00:00', 1);");
        // 放入 t_order_202402 分片表
        jdbcTemplate.execute("INSERT INTO `t_order`(`id`,`order_date`,`order_id`, `order_number`, `customer_id`, `total_amount`, `interval_value`, `user_id`) VALUES (2, '2024-03-20 00:00:00', 2, '2', 2, 1.00, '2024-02-01 00:00:00', 1);");
        // 放入 t_order_202403 分片表
        jdbcTemplate.execute("INSERT INTO `t_order`(`id`,`order_date`,`order_id`, `order_number`, `customer_id`, `total_amount`, `interval_value`, `user_id`) VALUES (3, '2024-03-20 00:00:00', 3, '3', 3, 1.00, '2024-03-01 00:00:00', 1);");
        // 放入 t_order_202404 分片表
        jdbcTemplate.execute("INSERT INTO `t_order`(`id`,`order_date`,`order_id`, `order_number`, `customer_id`, `total_amount`, `interval_value`, `user_id`) VALUES (4, '2025-03-20 00:00:00', 4, '4', 4, 1.00, '2024-04-01 00:00:00', 1);");
        // 放入 t_order_202405 分片表
        jdbcTemplate.execute("INSERT INTO `t_order`(`id`,`order_date`,`order_id`, `order_number`, `customer_id`, `total_amount`, `interval_value`, `user_id`) VALUES (5, '2025-03-20 00:00:00', 5, '5', 5, 1.00, '2024-05-01 00:00:00', 1);");
        // 放入 t_order_202406 分片表
        jdbcTemplate.execute("INSERT INTO `t_order`(`id`,`order_date`,`order_id`, `order_number`, `customer_id`, `total_amount`, `interval_value`, `user_id`) VALUES (6, '2026-03-20 00:00:00', 6, '6', 6, 1.00, '2024-06-01 00:00:00', 1);");
        jdbcTemplate.execute("INSERT INTO `t_order`(`id`,`order_date`,`order_id`, `order_number`, `customer_id`, `total_amount`, `interval_value`, `user_id`) VALUES (7, '2027-03-20 00:00:00', 7, '7', 7, 1.00, '2024-07-01 00:00:00', 1);");
    }


    @DisplayName("测试 cosid_interval COSID_INTERVAL_SNOWFLAKE 时间范围分片算法插入数据")
    @Test
    public void insertCosIdIntervalDateTableTest() {
        // 放入 t_order_202401 分片表
        jdbcTemplate.execute("INSERT INTO `t_order`(`id`,`order_date`,`order_id`, `order_number`, `customer_id`, `total_amount`, `interval_value`, `user_id`) VALUES (1, '2024-03-20 00:00:00', 1, '1', 1, 1.00, '2024-01-01 00:00:00', 1);");
//        jdbcTemplate.execute("INSERT INTO `t_order`(`id`,`order_date`,`order_id`, `order_number`, `customer_id`, `total_amount`, `interval_value`, `user_id`) VALUES (2, '2024-03-20 00:00:00', 2, '2', 2, 1.00, '2024-02-01 00:00:00', 1);");
//        jdbcTemplate.execute("INSERT INTO `t_order`(`id`,`order_date`,`order_id`, `order_number`, `customer_id`, `total_amount`, `interval_value`, `user_id`) VALUES (3, '2024-03-20 00:00:00', 3, '3', 3, 1.00, '2024-03-01 00:00:00', 1);");
//        jdbcTemplate.execute("INSERT INTO `t_order`(`id`,`order_date`,`order_id`, `order_number`, `customer_id`, `total_amount`, `interval_value`, `user_id`) VALUES (4, '2025-03-20 00:00:00', 4, '4', 4, 1.00, '2024-04-01 00:00:00', 1);");
//        jdbcTemplate.execute("INSERT INTO `t_order`(`id`,`order_date`,`order_id`, `order_number`, `customer_id`, `total_amount`, `interval_value`, `user_id`) VALUES (5, '2025-03-20 00:00:00', 5, '5', 5, 1.00, '2024-05-11 00:00:10', 1);");
//        jdbcTemplate.execute("INSERT INTO `t_order`(`id`,`order_date`,`order_id`, `order_number`, `customer_id`, `total_amount`, `interval_value`, `user_id`) VALUES (6, '2026-03-20 00:00:00', 6, '6', 6, 1.00, '2024-06-01 00:00:00', 1);");
    }

    @DisplayName("测试 hint_inline 分片算法插入数据")
    @Test
    public void insertHintInlineTableTest() {
        HintManager hintManager = HintManager.getInstance();
        hintManager.clearShardingValues();
        // 设置逻辑表 t_order 的分库值
        hintManager.addDatabaseShardingValue("t_order", 0);
        // 设置逻辑表 t_order 的分表值
        hintManager.addTableShardingValue("t_order", 1);
        // 1%3 = 1 所以放入 db0.t_order_1 分片表
        // /* SHARDINGSPHERE_HINT: t_order.SHARDING_DATABASE_VALUE=0, t_order.SHARDING_TABLE_VALUE=1 */
        jdbcTemplate.execute("INSERT INTO `t_order`(`id`,`order_date`,`order_id`, `order_number`, `customer_id`, `total_amount`, `interval_value`, `user_id`) VALUES (1, '2024-03-20 00:00:00', 1, '1', 1, 1.00, '2024-01-01 00:00:00', 1);");

        hintManager.close();
    }
}
