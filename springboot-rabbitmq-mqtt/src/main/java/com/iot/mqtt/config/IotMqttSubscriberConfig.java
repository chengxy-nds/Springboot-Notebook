package com.iot.mqtt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

/**
 * @Author: xiaofu
 * @Description: 消息订阅配置
 * @date 2020/6/8 18:24
 */
@Configuration
public class IotMqttSubscriberConfig {

    @Autowired
    private MqttConfig mqttConfig;

    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setServerURIs(mqttConfig.getServers());
        return factory;
    }

    @Bean
    public MessageChannel iotMqttInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageProducer inbound() {
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(mqttConfig.getClientId(), mqttClientFactory(), mqttConfig.getDefaultTopic());
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(2);
        adapter.setOutputChannel(iotMqttInputChannel());
        return adapter;
    }

    /**
     * @author xiaofu
     * @description 消息订阅
     * @date 2020/6/8 18:20
     */
    @Bean
    @ServiceActivator(inputChannel = "iotMqttInputChannel")
    public MessageHandler handlerTest() {

        return message -> {
            try {
                String string = message.getPayload().toString();
                System.out.println("接收到消息：" + string);
            } catch (MessagingException ex) {
                //logger.info(ex.getMessage());
            }
        };

    }
}


