package com.shardingsphere_101.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.sharding.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.sharding.api.sharding.hint.HintShardingValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

/**
 * 自定义强制路由分片算法
 *
 * @author 公众号：程序员小富
 * @date 2024/03/22 11:02
 */
@Slf4j
public class OrderHintCustomAlgorithm implements HintShardingAlgorithm<Long> {

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, HintShardingValue<Long> hintShardingValue) {

        /**
         * 获取到设置的分表或者分库的分片值
         * 指定分表时的分片值  hintManager.addTableShardingValue("t_order",2L);
         * 指定分库时的分片值  hintManager.addDatabaseShardingValue("t_order", 100L);
         */
        Collection<Long> values = hintShardingValue.getValues();
        Collection<String> result = new ArrayList<>();
        // 从所有分片表中得到合适的分片表
        for (String each : availableTargetNames) {
            for (Long value : values) {
                Long mod = value % availableTargetNames.size();
                if (each.endsWith(String.valueOf(mod))) {
                    result.add(each);
                }
            }
        }
        return result;
    }

    @Override
    public Properties getProps() {
        return null;
    }

    @Override
    public void init(Properties properties) {

    }
}