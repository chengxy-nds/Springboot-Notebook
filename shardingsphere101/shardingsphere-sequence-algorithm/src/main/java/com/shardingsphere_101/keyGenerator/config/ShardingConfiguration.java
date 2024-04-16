//package com.shardingsphere_101.config;
//
//import com.zaxxer.hikari.HikariDataSource;
//import org.apache.shardingsphere.driver.api.ShardingSphereDataSourceFactory;
//import org.apache.shardingsphere.infra.config.algorithm.AlgorithmConfiguration;
//import org.apache.shardingsphere.sharding.api.config.ShardingRuleConfiguration;
//import org.apache.shardingsphere.sharding.api.config.rule.ShardingTableRuleConfiguration;
//import org.apache.shardingsphere.sharding.api.config.strategy.keygen.KeyGenerateStrategyConfiguration;
//import org.apache.shardingsphere.sharding.api.config.strategy.sharding.StandardShardingStrategyConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//import java.util.*;
//
///**
// * 公众号：程序员小富
// */
//@Configuration
//public class ShardingConfiguration {
//
//    /**
//     * 配置分片数据源
//     * 公众号：程序员小富
//     */
//    @Bean
//    public DataSource getShardingDataSource() throws SQLException {
//        Map<String, DataSource> dataSourceMap = new HashMap<>();
//        dataSourceMap.put("db0", dataSource0());
//        dataSourceMap.put("db1", dataSource1());
//
//        // 分片rules规则配置
//        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
//
//        // 分片算法
//        shardingRuleConfig.setShardingAlgorithms(getShardingAlgorithms());
//        shardingRuleConfig.setKeyGenerators(getKeyGenerators());
//        // 配置 t_order 表分片规则
//        ShardingTableRuleConfiguration orderTableRuleConfig = new ShardingTableRuleConfiguration("t_order", "db${0..1}.t_order_${0..2}");
//        orderTableRuleConfig.setTableShardingStrategy(new StandardShardingStrategyConfiguration("order_id", "t_order_table_mod"));
//        orderTableRuleConfig.setDatabaseShardingStrategy(new StandardShardingStrategyConfiguration("order_id", "t_order_database_mod"));
//
//        // 配置分片健策略
//        orderTableRuleConfig.setKeyGenerateStrategy(new KeyGenerateStrategyConfiguration("id", "xiaofu"));
//
//
//        shardingRuleConfig.getTables().add(orderTableRuleConfig);
//
//        // 是否在控制台输出解析改造后真实执行的 SQL
//        Properties properties = new Properties();
//        properties.setProperty("sql-show", "true");
//
//        // 创建 ShardingSphere 数据源
//        return ShardingSphereDataSourceFactory.createDataSource(dataSourceMap, Collections.singleton(shardingRuleConfig), properties);
//    }
//
//    /**
//     * 配置数据源1
//     * 公众号：程序员小富
//     */
//    public DataSource dataSource0() {
//        HikariDataSource dataSource = new HikariDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/db0?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true");
//        dataSource.setUsername("root");
//        dataSource.setPassword("123456");
//        return dataSource;
//    }
//
//    /**
//     * 配置数据源2
//     * 公众号：程序员小富
//     */
//    public DataSource dataSource1() {
//        HikariDataSource dataSource = new HikariDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/db1?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true");
//        dataSource.setUsername("root");
//        dataSource.setPassword("123456");
//        return dataSource;
//    }
//
//    /**
//     * 配置分片算法
//     * 公众号：程序员小富
//     */
//    private Map<String, AlgorithmConfiguration> getShardingAlgorithms() {
//        Map<String, AlgorithmConfiguration> shardingAlgorithms = new LinkedHashMap<>();
//
//        // 自定义分库算法
//        Properties databaseAlgorithms = new Properties();
//        databaseAlgorithms.setProperty("sharding-count", "2");
//        shardingAlgorithms.put("t_order_database_mod", new AlgorithmConfiguration("MOD", databaseAlgorithms));
//
//        // 自定义分表算法
//        Properties tableAlgorithms = new Properties();
//        tableAlgorithms.setProperty("sharding-count", "3");
//        shardingAlgorithms.put("t_order_table_mod", new AlgorithmConfiguration("MOD", tableAlgorithms));
//
//        return shardingAlgorithms;
//    }
//
//    /**
//     * 配置分片健
//     * 公众号：程序员小富
//     */
//    private Map<String, AlgorithmConfiguration> getKeyGenerators() {
//        Map<String, AlgorithmConfiguration> keyGenerators = new LinkedHashMap<>();
//
//        Properties uuidProperties = new Properties();
//        keyGenerators.put("uuid", new AlgorithmConfiguration("UUID", uuidProperties));
//
//        Properties nanoid = new Properties();
//        keyGenerators.put("nanoid", new AlgorithmConfiguration("NANOID", nanoid));
//
//        Properties xiaofu = new Properties();
//        keyGenerators.put("xiaofu", new AlgorithmConfiguration("xiaofu", xiaofu));
//
//        return keyGenerators;
//    }
//}
