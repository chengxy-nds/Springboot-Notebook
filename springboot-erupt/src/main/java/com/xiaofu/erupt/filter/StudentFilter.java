package com.xiaofu.erupt.filter;

import xyz.erupt.annotation.fun.FilterHandler;


public class StudentFilter implements FilterHandler {

    /**
     * @param condition 条件表达式
     * @param params    注解参数
     */
    @Override
    public String filter(String condition, String[] params) {
        return condition + " = '" + params[0] + "'";
    }

}
