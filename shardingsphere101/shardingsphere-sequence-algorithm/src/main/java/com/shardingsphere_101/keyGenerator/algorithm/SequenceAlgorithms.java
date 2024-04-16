package com.shardingsphere_101.keyGenerator.algorithm;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.sharding.spi.KeyGenerateAlgorithm;

import java.util.Properties;

/**
 * 自定义分库分表主键算法
 */
@Data
@Slf4j
public class SequenceAlgorithms implements KeyGenerateAlgorithm {
    @Override
    public String getType() {
        // 返回算法类型表示
        return "custom";
    }

    @Override
    public Comparable<?> generateKey() {
        System.out.println(111);
        System.out.println(111);
        System.out.println(111);

        return null;
    }

    @Override
    public Properties getProps() {
        return null;
    }

    @Override
    public void init(Properties properties) {
    }
}