//package com.chengxy.delayqueue.deadLetterQueue;
//
//import org.springframework.amqp.core.*;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
///**
// * @Author: xiaofu
// * @Description:
// */
//@Configuration
//public class DeadLetterConfig {
//
//    /**
//     * 正常消费交换机
//     */
//    @Bean(name = "order.close.exchange")
//    public DirectExchange getDirectExchange() {
//
//        return new DirectExchange("order.close.exchange");
//    }
//
//    /**
//     * 正常消费队列
//     */
//    @Bean(name = "order.close.queue")
//    public Queue getQueue() {
//        return new Queue("order.close.queue");
//    }
//
//    /**
//     * 正常消费队列与交换机绑定
//     */
//    @Bean
//    public Binding bingdingDeadLetterExchangeAndQueue(@Qualifier("order.close.exchange") DirectExchange deadLetterExchange
//            , @Qualifier("order.close.queue") Queue deadLetterQueue) {
//
//        return BindingBuilder.bind(deadLetterQueue).to(deadLetterExchange).with("order.close.queue");
//    }
//
//    /**
//     * 延时交换机
//     */
//    @Bean(name = "order.delay.exchange")
//    public DirectExchange getMessageDirectExchange() {
//
//        return new DirectExchange("order.delay.exchange");
//    }
//
//    /**
//     * 延时队列
//     */
//    @Bean(name = "order.delay.queue")
//    public Queue getMessageQueue() {
//        return QueueBuilder
//                .durable(RabbitConstant.DEAD_LETTER_QUEUE)
//                // 配置到期后转发的交换
//                .withArgument("x-dead-letter-exchange", "order.close.exchange")
//                // 配置到期后转发的路由键
//                .withArgument("x-dead-letter-routing-key", "order.close.queue")
//                .build();
//    }
//
//    /**
//     * 延时队列与交换机绑定
//     */
//    @Bean
//    public Binding bingdingMessageExchangeAndQueue(@Qualifier("order.delay.exchange") DirectExchange messageExchange
//            , @Qualifier("order.delay.queue") Queue messageQueue) {
//        return BindingBuilder.bind(messageQueue).to(messageExchange).with("order.delay.queue");
//    }
//}