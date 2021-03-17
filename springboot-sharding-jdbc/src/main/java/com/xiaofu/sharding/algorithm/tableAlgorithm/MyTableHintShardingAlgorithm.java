package com.xiaofu.sharding.algorithm.tableAlgorithm;


import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author xinzhifu
 * @description hit分表算法
 * @date 2020/11/2 12:06
 */
public class MyTableHintShardingAlgorithm implements HintShardingAlgorithm<String> {

    @Override
    public Collection<String> doSharding(Collection<String> tableNames, HintShardingValue<String> hintShardingValue) {

        Collection<String> result = new ArrayList<>();
        for (String tableName : tableNames) {
            Collection<String> values = hintShardingValue.getValues();
            for (String shardingValue : values) {
                if (tableName.endsWith(String.valueOf(Long.valueOf(shardingValue) % tableNames.size()))) {
                    result.add(tableName);
                }
            }
        }
        return result;
    }
}


