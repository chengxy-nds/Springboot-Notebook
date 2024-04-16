package com.shardingsphere_101.algorithm;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Range;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingValue;

import java.util.Collection;
import java.util.Map;
import java.util.Properties;

/**
 * 自定义复合分片算法
 *
 * @author 公众号：程序员小富
 * @date 2024/03/22 11:02
 */
@Slf4j
public class OrderComplexCustomAlgorithm implements ComplexKeysShardingAlgorithm<Long> {

    /**
     * 复合分片算法进入，支持>，>=, <=，<，=，IN 和 BETWEEN AND 等操作符
     *
     * @param availableTargetNames 所有分片表的集合
     * @param complexKeysShardingValue        多个分片健的值，并SQL中解析出来的分片值
     */
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames,
                                         ComplexKeysShardingValue<Long> complexKeysShardingValue) {

        /**
         * 分库策略使用时：availableTargetNames 参数数据为分片库的集合 ["db0","db1"]
         * 分表策略使用时：availableTargetNames 参数数据为分片库的集合 ["t_order_0","t_order_1","t_order_2"]
         */
        log.info("进入复合分片：complex availableTargetNames:{}", JSON.toJSONString(availableTargetNames));

        // 多分片健和其对应的分片健范围值
        Map<String, Range<Long>> columnNameAndRangeValuesMap = complexKeysShardingValue.getColumnNameAndRangeValuesMap();
        log.info("进入复合分片：columnNameAndRangeValuesMap:{}", JSON.toJSONString(columnNameAndRangeValuesMap));

        columnNameAndRangeValuesMap.forEach((columnName, range) -> {
            range.lowerEndpoint();
            range.upperEndpoint();
            // 分片健
            log.info("进入复合分片：columnName:{}", columnName);
            // 分片健范围值
            log.info("进入复合分片：range:{}", JSON.toJSONString(range));
        });

        // 多分片健和其对应的分片健值
        Map<String, Collection<Long>> columnNameAndShardingValuesMap = complexKeysShardingValue.getColumnNameAndShardingValuesMap();
        log.info("进入复合分片：columnNameAndShardingValuesMap:{}", JSON.toJSONString(columnNameAndShardingValuesMap));
        columnNameAndShardingValuesMap.forEach((columnName, shardingValues) -> {
            // 分片健
            log.info("进入复合分片：columnName:{}", columnName);
            // 分片健值
            log.info("进入复合分片：shardingValues:{}", JSON.toJSONString(shardingValues));
        });

        return null;
    }

    @Override
    public Properties getProps() {

        Properties props = new Properties();
        // 设置算法所需的配置信息
        props.setProperty("key1", "value1");
        props.setProperty("key2", "value2");
        return props;
    }

    /**
     * 初始化配置
     *
     * @param properties
     */
    @Override
    public void init(Properties properties) {
        Object prop = properties.get("aaaaaa");
        log.info("自定义配置信息：{}", JSON.toJSONString(prop));
    }
}