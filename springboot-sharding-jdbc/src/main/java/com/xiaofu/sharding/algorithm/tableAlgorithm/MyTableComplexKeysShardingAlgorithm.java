package com.xiaofu.sharding.algorithm.tableAlgorithm;


import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.Collection;

/**
 * @author xiaofu 公众号【程序员内点事】
 * @description 自定义复合分表策略
 * @date 2020/10/30 13:48
 */
public class MyTableComplexKeysShardingAlgorithm implements ComplexKeysShardingAlgorithm<Long> {

    @Override
    public Collection<String> doSharding(Collection<String> collection, ComplexKeysShardingValue<Long> complexKeysShardingValue) {

//        Collection<Integer> ids = getShardingValue(shardingValues, "id");
//        Collection<Integer> usernames = getShardingValue(shardingValues, "username");
        return null;
    }
}


