package com.xiaofu.annotation;

import java.lang.annotation.*;

import static com.xiaofu.enums.EncryptConstant.ENCRYPT;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EncryptMethod {

    String type() default ENCRYPT;
}

