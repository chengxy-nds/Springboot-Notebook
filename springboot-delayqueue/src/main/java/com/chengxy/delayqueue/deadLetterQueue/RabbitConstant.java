package com.chengxy.delayqueue.deadLetterQueue;

/**
 * @Author: xinzhifu
 * @Description:
 */
public @interface RabbitConstant {

    /**
     * 死信交换机
     */
    String DEAD_LETTER_EXCHANGE = "com.xin.deadLetterExchange";

    /**
     * 死信队列
     */
    String DEAD_LETTER_QUEUE = "com.xin.deadLetterQueue";

    /**
     * 测试死信正常消费交换机
     */
    String MESSAGE_EXCHANGE = "order.pay.exchange";

    /**
     * 测试死信正常消费队列
     */
    String MESSAGE_QUEUE = "order.pay.queue";
}
