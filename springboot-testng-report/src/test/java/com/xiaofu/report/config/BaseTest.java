package com.xiaofu.report.config;

import com.xiaofu.report.SpringbootTestngReportApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Listeners;

/**
 * @Author: xiaofu
 * @Description:
 */
@SpringBootTest(classes = SpringbootTestngReportApplication.class)
@WebAppConfiguration
@Slf4j
@Listeners({ExtentTestNGIReporterListener.class})
public class BaseTest extends AbstractTestNGSpringContextTests {

    public BaseTest() {
    }
}
