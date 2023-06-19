package com.xiaofu.sharding.algorithm.dbAlgorithm;


import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author xinzhifu
 * @description 范围分库算法
 * @date 2020/11/2 12:06
 */
public class MyDBRangeShardingAlgorithm implements RangeShardingAlgorithm<Integer> {

    @Override
    public Collection<String> doSharding(Collection<String> databaseNames, RangeShardingValue<Integer> rangeShardingValue) {

        Set<String> result = new LinkedHashSet<>();
        // between and 的起始值
        int lower = rangeShardingValue.getValueRange().lowerEndpoint();
        int upper = rangeShardingValue.getValueRange().upperEndpoint();
        // 循环范围计算分库逻辑
        for (int i = lower; i <= upper; i++) {
            for (String databaseName : databaseNames) {
                if (databaseName.endsWith(i % databaseNames.size() + "")) {
                    result.add(databaseName);
                }
            }
        }
        return result;
    }
}


