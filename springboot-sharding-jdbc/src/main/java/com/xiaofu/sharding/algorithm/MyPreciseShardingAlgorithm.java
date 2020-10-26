package com.xiaofu.sharding.algorithm;


import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;


public class MyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

	@Override
	public String doSharding(Collection<String> tableNames, PreciseShardingValue<Long> shardingValue) {
		for (String tableName : tableNames) {
			String  value = shardingValue.getValue() % 3 + "";
			if (tableName.endsWith(value)) {
				return tableName;
			}
		}
		throw new IllegalArgumentException();
	}
}


