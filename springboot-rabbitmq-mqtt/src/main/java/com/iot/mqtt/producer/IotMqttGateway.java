package com.iot.mqtt.producer;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

/**
 * @Author: xinzhifu
 * @Description:
 */
/**
 * @author xinzhifu
 * @description
 * @date    2020/6/8 18:26
 */
@MessagingGateway(defaultRequestChannel = "iotMqttInputChannel")
public interface IotMqttGateway {

    void sendMessage2Mqtt(String data);

    void sendMessage2Mqtt(String data,@Header(MqttHeaders.TOPIC) String topic);

    void sendMessage2Mqtt(@Header(MqttHeaders.TOPIC) String topic, @Header(MqttHeaders.QOS) int qos, String payload);
}



