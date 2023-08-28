package com.springboot101.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;

@EnableWebMvc
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 配置docket 具体参数
     */
    @Bean
    public Docket docket(Environment environment) {

        // 设置要显示swagger的环境
        Profiles of = Profiles.of("dev", "test", "pre");
        boolean enable = environment.acceptsProfiles(of);

        return new Docket(DocumentationType.SWAGGER_2)
                .host("http://test.com") // 请求地址
                .groupName("用户分组")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.springboot101.controller"))
//                .paths(PathSelectors.ant("/test/**"))
                .build()
                .enable(true)
//                .tags(new Tag("tag测试-1", "tag测试-1描述"))
                .apiInfo(apiInfo()) // 文档基础配置
                .securitySchemes(
                        Arrays.asList(
                                new ApiKey("Bearer", "Bearer", "header"),
                                new ApiKey("Authorization", "Authorization", "header"),
                                new ApiKey("Basic", "Basic", "header")
                        )
                )
                .securityContexts(Collections.singletonList(securityContext()));
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(
                        Arrays.asList(
                                new SecurityReference("Authorization", new AuthorizationScope[0]),
                                new SecurityReference("Bearer", new AuthorizationScope[0]),
                                new SecurityReference("Basic", new AuthorizationScope[0])))
                .build();
    }

    @Bean
    public Docket docket1(Environment environment) {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("商家分组")
                .tags(new Tag("tag测试-2", "tag测试-2描述"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.springboot101.controller"))
                .paths(PathSelectors.ant("/test1/**"))
                .build();
    }

    /**
     * 文档基础信息
     */
    private ApiInfo apiInfo() {
        Contact contact = new Contact("小富", "http://fire100.top/contact", "email@example.com");
        return new ApiInfoBuilder()
                .title("Swagger学习")
                .description("程序员小富-带你一起学习 Swagger")
                .version("v1.0.1")
                .termsOfServiceUrl("http://fire100.top")
                .contact(contact)
                .license("许可证")
                .licenseUrl("许可链接")
                .extensions(Arrays.asList(
                        new StringVendorExtension("我是", "小富"),
                        new StringVendorExtension("你是", "谁")
                ))
                .build();
    }


//    @Bean
//    public static BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
//        return new BeanPostProcessor() {
//
//            @Override
//            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//                if (bean instanceof WebMvcRequestHandlerProvider || bean instanceof WebFluxRequestHandlerProvider) {
//                    customizeSpringfoxHandlerMappings(getHandlerMappings(bean));
//                }
//                return bean;
//            }
//
//            private <T extends RequestMappingInfoHandlerMapping> void customizeSpringfoxHandlerMappings(List<T> mappings) {
//                List<T> copy = mappings.stream()
//                        .filter(mapping -> mapping.getPatternParser() == null)
//                        .collect(Collectors.toList());
//                mappings.clear();
//                mappings.addAll(copy);
//            }
//
//            @SuppressWarnings("unchecked")
//            private List<RequestMappingInfoHandlerMapping> getHandlerMappings(Object bean) {
//                try {
//                    Field field = ReflectionUtils.findField(bean.getClass(), "handlerMappings");
//                    field.setAccessible(true);
//                    return (List<RequestMappingInfoHandlerMapping>) field.get(bean);
//                } catch (IllegalArgumentException | IllegalAccessException e) {
//                    throw new IllegalStateException(e);
//                }
//            }
//        };
//    }
}