package com.xiaofu.sharding.key;

import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @Author: xinzhifu
 * @Description:
 */
@Component
public class MyKeyGenerator implements ShardingKeyGenerator {


    @Override
    public Comparable<?> generateKey() {
        return 1;
    }

    @Override
    public String getType() {
        return "xiaofukey";
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
