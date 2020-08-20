package com.xiaofu.report;

import com.alibaba.fastjson.JSON;
import com.xiaofu.report.config.ExtentTestNGIReporterListener;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

/**
 * @author xiaofu
 * @description testNG 单元测试
 * @date 2020/3/19 16:43
 */
@Slf4j
@Listeners({ExtentTestNGIReporterListener.class})
@SpringBootTest(classes = SpringbootTestngReportApplication.class)
public class OrderTest extends AbstractTestNGSpringContextTests {

    @Data
    class User {
        private Integer userId;
        private String userName;
    }

    /**
     * 参数提供
     */
    @DataProvider(name = "paramDataProvider")
    public Object[][] paramDataProvider() {
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("程序员内点事1");
        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("程序员内点事2");
        return new Object[][]{{1, user1}, {2, user2}};
    }

    @Test(dataProvider = "paramDataProvider",groups = "user")
    public void queryUser(Integer index, User user) {
        log.info("index：{}，user: {}", index, JSON.toJSONString(user));
    }


    @Test()
    public void orderTest() {

        log.info("我是小组");
    }

    @BeforeSuite
    public void beforeSuite(){
        log.info("beforeSuite");
    }

    @AfterSuite
    public void afterSuite(){
        log.info("AfterSuite");
    }

    @BeforeClass
    public void beforeClass(){
        log.info("BeforeClass");
    }

    @AfterClass
    public void afterClass(){
        log.info("AfterClass");
    }

    @BeforeTest
    public void beforeTest(){
        log.info("BeforeTest");
    }

    @AfterTest
    public void afterTest(){
        log.info("AfterTest");
    }

    @BeforeGroups
    public void beforeGroups(){
        log.info("BeforeGroups");
    }
    @AfterGroups
    public void afterGroups(){
        log.info("AfterGroups");
    }

    @BeforeMethod
    public void BeforeMethod(){
        log.info("BeforeMethod");
    }

    @AfterMethod
    public void AfterMethod(){
        log.info("AfterMethod");
    }
}
