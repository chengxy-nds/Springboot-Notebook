package com.dynamic.aspect;

import java.lang.annotation.*;

/**
 * 定于数据源切换注解
 *
 * @author 公众号：程序员小富
 * @date 2023/11/27 11:02
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DS {
    // 默认数据源master
    String value() default "master";
}