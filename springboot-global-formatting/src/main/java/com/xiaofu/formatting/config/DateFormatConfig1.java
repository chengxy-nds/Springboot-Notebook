//package com.xiaofu.formatting.config;
//
//
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
//import org.springframework.boot.jackson.JsonComponent;
//import org.springframework.context.annotation.Bean;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.TimeZone;
//
///**
// * 第一种全局时间格式化
// */
//@JsonComponent
//public class DateFormatConfig1 {
//
//    @Value("${spring.jackson.date-format:yyyy-MM-dd HH:mm:ss}")
//    private String pattern;
//
//    /**
//     * @author xiaofu
//     * @description date 类型全局时间格式化
//     * @date 2020/8/31 18:22
//     */
//    @Bean
//    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilder() {
//
//        return builder -> {
//            TimeZone tz = TimeZone.getTimeZone("UTC");
//            DateFormat df = new SimpleDateFormat(pattern);
//            df.setTimeZone(tz);
//            builder.failOnEmptyBeans(false)
//                    .failOnUnknownProperties(false)
//                    .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
//                    .dateFormat(df);
//        };
//    }
//
//    /**
//     * @author xiaofu
//     * @description LocalDate 类型全局时间格式化
//     * @date 2020/8/31 18:22
//     */
//    @Bean
//    public LocalDateTimeSerializer localDateTimeDeserializer() {
//        return new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(pattern));
//    }
//
//    @Bean
//    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
//        return builder -> builder.serializerByType(LocalDateTime.class, localDateTimeDeserializer());
//    }
//}