package com.shardingsphere_101.algorithm;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

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
     * @param preciseShardingValue        分片健的值，SQL中解析出来的分片值
     */
    @Override
    public String doSharding(Collection<String> availableTargetNames,
                             PreciseShardingValue<Long> preciseShardingValue) {
        /**
         * 分库策略使用时：availableTargetNames 参数数据为分片库的集合 ["db0","db1"]
         * 分表策略使用时：availableTargetNames 参数数据为分片库的集合 ["t_order_0","t_order_1","t_order_2"]
         */
        log.info("进入精准分片 precise availableTargetNames:{}", JSON.toJSONString(availableTargetNames));

        /**
         * 分库策略使用时： shardingValue 参数数据：{"columnName":"order_id","dataNodeInfo":{"paddingChar":"0","prefix":"db","suffixMinLength":1},"logicTableName":"t_order","value":1}
         * 分表策略使用时： shardingValue 参数数据：{"columnName":"order_id","dataNodeInfo":{"paddingChar":"0","prefix":"t_order_","suffixMinLength":1},"logicTableName":"t_order","value":1}
         */
        log.info("进入精准分片 preciseShardingValue:{}", JSON.toJSONString(preciseShardingValue));
        int tableSize = availableTargetNames.size();
        // 真实表的前缀
        String tablePrefix = preciseShardingValue.getDataNodeInfo().getPrefix();
        // 分片健的值
        long orderId = preciseShardingValue.getValue();
        // 对分片健取模后确定位置
        long mod = orderId % tableSize;
        return tablePrefix + mod;
    }

    /**
     * 范围分片进入 sql中有 between 和  < > 等操作符会执行
     *
     * @param availableTargetNames 所有分片表的集合
     * @param rangeShardingValue        分片健的值，SQL中解析出来的分片值
     * @return
     */
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames,
                                         RangeShardingValue<Long> rangeShardingValue) {
        /**
         * 分库策略使用时：availableTargetNames 参数数据为分片库的集合 ["db0","db1"]
         * 分表策略使用时：availableTargetNames 参数数据为分片库的集合 ["t_order_0","t_order_1","t_order_2"]
         */
        log.info("进入范围分片：range availableTargetNames:{}", JSON.toJSONString(availableTargetNames));


        /**
         * 分库策略使用时 shardingValue 参数数据：{"columnName":"order_id","dataNodeInfo":{"paddingChar":"0","prefix":"db","suffixMinLength":1},"logicTableName":"t_order","valueRange":{"empty":false}}
         * 分表策略使用时 shardingValue 参数数据：{"columnName":"order_id","dataNodeInfo":{"paddingChar":"0","prefix":"t_order_","suffixMinLength":1},"logicTableName":"t_order","valueRange":{"empty":false}}
         */
        log.info("进入范围分片：rangeShardingValue:{}", JSON.toJSONString(rangeShardingValue));

        Properties props = getProps();
        log.info("进入范围分片：rangeShardingValue props:{}", JSON.toJSONString(props));
        // 分片健值的上下边界
//        Range<Long> valueRange = rangeShardingValue.getValueRange();
//        Long lower = valueRange.lowerEndpoint();
//        // 分片健值的上边界
//        Long upper = valueRange.upperEndpoint();
//        // 真实表的前缀
//        String tablePrefix = rangeShardingValue.getDataNodeInfo().getPrefix();
//        if (lower != null && upper != null) {
//            // 分片健的值
//            long orderId = upper - lower;
//            // 对分片健取模后确定位置
//            long mod = orderId % availableTargetNames.size();
//            return Arrays.asList(tablePrefix + mod);
//        }
        //
        return Collections.singletonList("t_order_0");
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
        Object prop = properties.get("cccccc");
        log.info("自定义配置信息：{}", JSON.toJSONString(prop));
    }
}