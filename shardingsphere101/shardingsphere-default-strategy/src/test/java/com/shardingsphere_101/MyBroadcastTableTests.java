package com.shardingsphere_101;

import com.alibaba.fastjson.JSON;
import com.shardingsphere_101.dao.CityDictMapper;
import com.shardingsphere_101.entity.CityDict;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * 广播表测试
 */
@Slf4j
@SpringBootTest
class MyBroadcastTableTests {

    @Resource
    private CityDictMapper cityDictRepository;

    /**
     * 广播表测试
     */
    @Test
    void saveCityDict() {
        CityDict cityDict = new CityDict();
        cityDict.setCityName("北京市");
        cityDict.setProvinceName("北京");
        cityDict.setCountryName("中国");
        cityDict.setPopulation(0);
        cityDict.setArea(0);
        cityDictRepository.insert(cityDict);
    }

    @Test
    void findCityDict() {
        for (int i = 0; i < 2000; i++) {
            CityDict dict = cityDictRepository.selectById(1L);
            log.info(JSON.toJSONString(dict));
        }
    }
}
