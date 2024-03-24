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
     * @param shardingValues        多个分片健的值，并SQL中解析出来的分片值
     */
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, ComplexKeysShardingValue<Long> shardingValues) {

        // 多分片健和其对应的分片健范围值
        Map<String, Range<Long>> columnNameAndRangeValuesMap = shardingValues.getColumnNameAndRangeValuesMap();

        // 多分片健和其对应的分片健值
        Map<String, Collection<Long>> columnNameAndShardingValuesMap = shardingValues.getColumnNameAndShardingValuesMap();
        return null;
    }

    @Override
    public Properties getProps() {
        return null;
    }

    /**
     * 初始化配置
     *
     * @param properties
     */
    @Override
    public void init(Properties properties) {
        Object prop = properties.get("prop");
        log.info("配置信息：{}", JSON.toJSONString(prop));
    }
}