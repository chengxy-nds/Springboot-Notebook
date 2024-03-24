package com.shardingsphere_101.algorithm;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Range;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.*;

/**
 * 自定义标准分片算法
 *
 * @author 公众号：程序员小富
 * @date 2024/03/22 11:02
 */
@Slf4j
public class OrderStandardCustomAlgorithm implements StandardShardingAlgorithm<Long> {

    /**
     * 精准分片进入 sql中有 = 和 in 等操作符会执行
     *
     * @param availableTargetNames 所有分片表的集合
     * @param shardingValue        分片健的值，SQL中解析出来的分片值
     */
    @Override
    public String doSharding(Collection<String> availableTargetNames,
                             PreciseShardingValue<Long> shardingValue) {
        log.info("进入精准分片 = 和 in");
        int tableSize = availableTargetNames.size();
        // 真实表的前缀
        String tablePrefix = shardingValue.getDataNodeInfo().getPrefix();
        // 分片健的值
        long orderId = shardingValue.getValue();
        // 对分片健取模后确定位置
        long mod = orderId % tableSize;
        return tablePrefix + mod;
    }

    /**
     * 范围分片进入 sql中有 between 和  < > 等操作符会执行
     *
     * @param availableTargetNames 所有分片表的集合
     * @param shardingValue        分片健的值，SQL中解析出来的分片值
     * @return
     */
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames,
                                         RangeShardingValue<Long> shardingValue) {
        log.info("进入范围分片 = 和 in");
        // 分片健值的下边界
        Range<Long> valueRange = shardingValue.getValueRange();
        Long lower = (Long) valueRange.lowerEndpoint();
        // 分片健值的上边界
        Long upper = (Long) valueRange.upperEndpoint();
        // 真实表的前缀
        String tablePrefix = shardingValue.getDataNodeInfo().getPrefix();
        if (lower != null && upper != null) {
            // 分片健的值
            long orderId = upper - lower;
            // 对分片健取模后确定位置
            long mod = orderId % availableTargetNames.size();
            return Arrays.asList(tablePrefix + mod);
        }
        //
        return Collections.singletonList("t_order_0");
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