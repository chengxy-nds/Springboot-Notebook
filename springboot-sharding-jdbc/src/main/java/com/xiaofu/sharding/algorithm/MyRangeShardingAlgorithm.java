package com.xiaofu.sharding.algorithm;


import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;


public class MyRangeShardingAlgorithm implements RangeShardingAlgorithm<Integer> {

    @Override
    public Collection<String> doSharding(Collection<String> tableNames, RangeShardingValue<Integer> rangeShardingValue) {

        Set<String> result = new LinkedHashSet<>();
        if (Range.closed(1000000000,2000000000).encloses(rangeShardingValue.getValueRange())) {
            for (String tableName : tableNames) {
                if (tableName.endsWith("0")) {
                    result.add(tableName);
                }
            }
        }
        return result;
    }
}


