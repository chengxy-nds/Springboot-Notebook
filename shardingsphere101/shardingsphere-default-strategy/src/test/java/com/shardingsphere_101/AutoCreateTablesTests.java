package com.shardingsphere_101;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

/**
 * @author 公众号：程序员小富
 * 自动创建分片表
 * @date 2023/12/31 17:25
 */
@SpringBootTest
class AutoCreateTablesTests {

    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 执行创建逻辑表的SQL，会根据AutoTables的配置自动在对应的数据源内创建分片表
     *
     * @author 公众号：程序员小富
     */
    @Test
    public void autoCreateOrderTableTest() {

        jdbcTemplate.execute("CREATE TABLE `t_order` (\n" +
                "  `order_id` bigint(20) NOT NULL,\n" +
                "  `order_number` varchar(255) NOT NULL,\n" +
                "  `customer_id` bigint(20) NOT NULL,\n" +
                "  `order_date` date NOT NULL,\n" +
                "  `total_amount` decimal(10,2) NOT NULL,\n" +
                "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
                "  PRIMARY KEY (`id`) USING BTREE\n" +
                ");");
    }

    @Test
    public void autoCreateOrderItemTableTest() {

        jdbcTemplate.execute("CREATE TABLE t_order_item (\n" +
                "  item_id INT PRIMARY KEY,\n" +
                "  order_id INT,\n" +
                "  product_id INT,\n" +
                "  quantity INT,\n" +
                "  unit_price DECIMAL(8, 2)\n" +
                ");");
    }
}
