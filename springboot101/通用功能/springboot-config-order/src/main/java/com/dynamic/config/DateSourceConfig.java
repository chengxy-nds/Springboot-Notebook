package com.dynamic.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 注册多个数据源
 *
 * @author 公众号：程序员小富
 * @date 2023/11/27 11:02
 */
@Configuration
public class DateSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid.master")
    public DataSource dynamicDatasourceMaster() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.slave")
    public DataSource dynamicDatasourceSlave() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "dynamicDataSource")
    @Primary
    public DynamicDataSource createDynamicDataSource() {
        Map<Object, Object> dataSourceMap = new HashMap<>();
        // 设置默认的数据源为Master
        DataSource defaultDataSource = dynamicDatasourceMaster();
        dataSourceMap.put("master", defaultDataSource);
        dataSourceMap.put("slave", dynamicDatasourceSlave());
        return new DynamicDataSource(defaultDataSource, dataSourceMap);
    }
}