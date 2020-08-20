package com.xiaofu.report;

import com.xiaofu.report.config.ExtentTestNGIReporterListener;
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
public class UserTest extends AbstractTestNGSpringContextTests {

    @Test(groups = "user")
    public void queryUser(String name) {

        log.info("我是测试方法~");
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

    @BeforeGroups(groups="user")
    public void beforeGroups(){
        log.info("BeforeGroups");
    }
    @AfterGroups(groups="user")
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


    @Test
    public void token() {
        System.out.println("get token");
    }

    @Test(dependsOnMethods= {"token"})
    public void getUser() {
        System.out.println("this is test getUser");
    }
}
