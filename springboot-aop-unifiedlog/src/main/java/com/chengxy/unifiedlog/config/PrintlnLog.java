package com.chengxy.unifiedlog.config;

import java.lang.annotation.*;

/**
 * @author xiaofu
 * @description
 * @date 2020/7/15 10:20
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface PrintlnLog {

    /**
     * 自定义日志描述信息文案
     *
     * @return
     */
    String description() default "";
}
