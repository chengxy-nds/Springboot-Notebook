package com.shardingsphere_101;

import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("创建分片表")
    @Test
    public void autoCreateOrderTableTest() {

        jdbcTemplate.execute("CREATE TABLE `t_order` (\n" +
                "  `order_id` bigint(20) NOT NULL,\n" +
                "  `order_number` varchar(255) NOT NULL,\n" +
                "  `customer_id` bigint(20) NOT NULL,\n" +
                "  `order_date` date NOT NULL,\n" +
                "  `total_amount` decimal(10,2) NOT NULL,\n" +
                "  PRIMARY KEY (`order_id`) USING BTREE\n" +
                ");");
    }

    /**
     * 删除 t_order 表
     *
     * @author 公众号：程序员小富
     */
    @DisplayName("修改分片表字段长度")
    @Test
    public void autoModifyOrderTableTest() {

        jdbcTemplate.execute("ALTER TABLE t_order MODIFY COLUMN order_number varchar(500);");
    }

    /**
     * 删除 t_order 表
     *
     * @author 公众号：程序员小富
     */
    @DisplayName("删除分片表")
    @Test
    public void autoDeleteOrderTableTest() {

        jdbcTemplate.execute("DROP TABLE `t_order`;");
    }
}
