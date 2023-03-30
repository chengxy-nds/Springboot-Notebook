package com.chengxy.unifiedlog.aspect;


import com.alibaba.fastjson.JSON;
import com.chengxy.unifiedlog.config.PrintlnLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author xiaofu
 * @description 日志收集切面
 * @date 2020/7/15 10:22
 */
@Slf4j
@Aspect
@Component
//@Profile({"dev"}) //只对某个环境打印日志
public class LogAspect {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    /**
     * 以自定义 @PrintlnLog 注解作为切面入口
     */
    @Pointcut("@annotation(com.chengxy.unifiedlog.config.PrintlnLog)")
    public void PrintlnLog() {
    }

    /**
     * @param joinPoint
     * @author xiaofu
     * @description 切面方法入参日志打印
     * @date 2020/7/15 10:30
     */
    @Before("PrintlnLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String methodDetailDescription = this.getAspectMethodLogDescJP(joinPoint);

        log.info("------------------------------- start --------------------------");
        /**
         * 打印自定义方法描述
         */
        log.info("Method detail Description: {}", methodDetailDescription);
        /**
         * 打印请求入参
         */
        log.info("Request Args: {}", JSON.toJSONString(joinPoint.getArgs()));
        /**
         * 打印请求方式
         */
        log.info("Request method: {}", request.getMethod());
        /**
         * 打印请求 url
         */
        log.info("Request URL: {}", request.getRequestURL().toString());

        /**
         * 打印调用方法全路径以及执行方法
         */
        log.info("Request Class and Method: {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
    }

    /**
     * @param proceedingJoinPoint
     * @author xiaofu
     * @description 切面方法返回结果日志打印
     * @date 2020/7/15 10:32
     */
    @Around("PrintlnLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        String aspectMethodLogDescPJ = getAspectMethodLogDescPJ(proceedingJoinPoint);

        long startTime = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();
        /**
         * 输出结果
         */
        log.info("{}，Response result  : {}", aspectMethodLogDescPJ, JSON.toJSONString(result));

        /**
         * 方法执行耗时
         */
        log.info("Time Consuming: {} ms", System.currentTimeMillis() - startTime);

        return result;
    }

    /**
     * @author xiaofu
     * @description 切面方法执行后执行
     * @date 2020/7/15 10:31
     */
    @After("PrintlnLog()")
    public void doAfter(JoinPoint joinPoint) throws Throwable {
        log.info("------------------------------- End --------------------------" + LINE_SEPARATOR);
    }

    /**
     * @param joinPoint
     * @author xiaofu
     * @description @PrintlnLog 注解作用的切面方法详细细信息
     * @date 2020/7/15 10:34
     */
    public String getAspectMethodLogDescJP(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        return getAspectMethodLogDesc(targetName, methodName, arguments);
    }

    /**
     * @param proceedingJoinPoint
     * @author xiaofu
     * @description @PrintlnLog 注解作用的切面方法详细细信息
     * @date 2020/7/15 10:34
     */
    public String getAspectMethodLogDescPJ(ProceedingJoinPoint proceedingJoinPoint) throws Exception {
        String targetName = proceedingJoinPoint.getTarget().getClass().getName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] arguments = proceedingJoinPoint.getArgs();
        return getAspectMethodLogDesc(targetName, methodName, arguments);
    }

    /**
     * @param targetName
     * @param methodName
     * @param arguments
     * @author xiaofu
     * @description 自定义注解参数
     * @date 2020/7/15 11:51
     */
    public String getAspectMethodLogDesc(String targetName, String methodName, Object[] arguments) throws Exception {
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        StringBuilder description = new StringBuilder("");
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description.append(method.getAnnotation(PrintlnLog.class).description());
                    break;
                }
            }
        }
        return description.toString();
    }
}


