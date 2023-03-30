package com.chengxy.delayqueue.deadLetterQueue;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author: xiaofu
 * @Description:
 */
@Configuration
public class DeadLetterConfig {

    /**
     * 正常消费队列
     */
    @Bean
    public Queue messageQueue() {
        return new Queue(RabbitConstant.IOT_VIRTUAL_DEVICE_CLOSE_QUEUE);
    }

    /**
     * 正常消费交换机
     */
    @Bean
    public DirectExchange messageDirectExchange() {
        return new DirectExchange(RabbitConstant.IOT_VIRTUAL_DEVICE_CLOSE_EXCHANGE);
    }

    /**
     * 正常消费队列与交换机绑定
     */
    @Bean
    public Binding bingdingMessageExchangeAndQueue() {

        return BindingBuilder.bind(messageQueue()).to(messageDirectExchange()).with(RabbitConstant.IOT_VIRTUAL_DEVICE_CLOSE_QUEUE);
    }

    /**
     * 延时队列
     */
    @Bean
    public Queue delayMessageQueue() {
        return QueueBuilder
                .durable(RabbitConstant.IOT_VIRTUAL_DEVICE_DELAY_QUEUE)
                // 配置到期后转发的交换
                .withArgument("x-dead-letter-exchange", RabbitConstant.IOT_VIRTUAL_DEVICE_CLOSE_EXCHANGE)
                // 配置到期后转发的路由键
                .withArgument("x-dead-letter-routing-key", RabbitConstant.IOT_VIRTUAL_DEVICE_CLOSE_QUEUE)
                .build();
    }

    /**
     * 延时交换机
     */
    @Bean
    public DirectExchange delayMessageDirectExchange() {

        return new DirectExchange(RabbitConstant.IOT_VIRTUAL_DEVICE_DELAY_EXCHANGE);
    }

    /**
     * 延时队列与交换机绑定
     */
    @Bean
    public Binding bingdingDeadLetterExchangeAndQueue() {
        return BindingBuilder.bind(delayMessageQueue()).to(delayMessageDirectExchange()).with(RabbitConstant.IOT_VIRTUAL_DEVICE_DELAY_QUEUE);
    }
}