package com.springboot101.deadLetterQueue;

/**
 * @Author: 公众号：程序员小富
 * @Description:
 */
public @interface RabbitConstant {

    /**
     * 死信交换机
     */
    String IOT_VIRTUAL_DEVICE_DELAY_EXCHANGE = "ecej.iot.virtual.device.delay.exchange";

    /**
     * 死信队列
     */
    String IOT_VIRTUAL_DEVICE_DELAY_QUEUE = "ecej.iot.virtual.device.delay.queue";

    /**
     * 消费交换机
     */
    String IOT_VIRTUAL_DEVICE_CLOSE_EXCHANGE = "ecej.iot.virtual.device.close.exchange";

    /**
     * 消费队列
     */
    String IOT_VIRTUAL_DEVICE_CLOSE_QUEUE = "ecej.iot.virtual.device.close.queue";

}
