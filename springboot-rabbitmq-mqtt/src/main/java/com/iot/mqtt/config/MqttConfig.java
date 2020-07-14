package com.iot.mqtt.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.stereotype.Component;

/**
 * @Author: xinzhifu
 * @Description: 基础配置类
 * @date 2020/6/8 18:25
 */
@Getter
@Setter
@Component
@IntegrationComponentScan
@ConfigurationProperties(prefix = "iot.mqtt")
public class MqttConfig {

    /**
     * 服务地址
     */
    private String servers;

    /**
     * 客户端id
     */
    private String clientId;

    /**
     * 服务端id
     */
    private String serverClientId;

    /**
     * 默认主题
     */
    private String defaultTopic;
}
