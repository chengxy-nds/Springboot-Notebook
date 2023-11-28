package com.dynamic.controller;

import com.dynamic.aspect.DS;
import com.dynamic.config.DataSourceContextHolder;
import com.dynamic.dao.DynamicDatasourceDataMapper;
import com.dynamic.entity.DynamicDatasourceData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 动态数据源切换
 *
 * @author 公众号：程序员小富
 * @date 2023/11/27 11:02
 */
@RestController
public class DynamicSwitchController {

    @Resource
    private DynamicDatasourceDataMapper dynamicDatasourceDataMapper;

    @GetMapping("/switchDataSource/{datasourceName}")
    public String switchDataSource(@PathVariable("datasourceName") String datasourceName) {
        DataSourceContextHolder.setDataSource(datasourceName);
        DynamicDatasourceData dynamicDatasourceData = dynamicDatasourceDataMapper.selectOne(null);
        DataSourceContextHolder.removeDataSource();
        return dynamicDatasourceData.getSourceName();
    }

    @DS(value = "master")
    @GetMapping("/dbMaster")
    public String dbMaster() {
        DynamicDatasourceData dynamicDatasourceData = dynamicDatasourceDataMapper.selectOne(null);
        return dynamicDatasourceData.getSourceName();
    }

    @DS(value = "slave")
    @GetMapping("/dbSlave")
    public String dbSlave() {
        DynamicDatasourceData dynamicDatasourceData = dynamicDatasourceDataMapper.selectOne(null);
        return dynamicDatasourceData.getSourceName();
    }


    /**
     * 验证一下事物控制
     */
//    @Transactional(rollbackFor = Exception.class)
    @DS(value = "slave")
    @GetMapping("/dbTestTransactional")
    public void dbTestTransactional() {

        DynamicDatasourceData datasourceData = new DynamicDatasourceData();
        datasourceData.setSourceName("test");
        dynamicDatasourceDataMapper.insert(datasourceData);

        DynamicDatasourceData datasourceData1 = new DynamicDatasourceData();
        datasourceData1.setSourceName("testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest");
        dynamicDatasourceDataMapper.insert(datasourceData1);
    }
}