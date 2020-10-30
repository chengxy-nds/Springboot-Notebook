package com.xiaofu.sharding.algorithm.tableAlgorithm;


import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class MyTableHintShardingAlgorithm implements HintShardingAlgorithm {

	@Override
	public Collection<String> doSharding(Collection tableNames, HintShardingValue hintShardingValue) {
		List<String> shardingResult = new ArrayList<>();
		for (Object targetName : tableNames) {

		}
		return shardingResult;
	}
}


