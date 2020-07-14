package com.chengxy.delayqueue.deadLetterQueue;

import org.springframework.stereotype.Component;


/**
 * @Author: xinzhifu
 * @Description:
 */
@Component
public class DeadLetterSendMessage {

//    @Resource
//    private AmqpTemplate amqpTemplate;
//
//    public void send(String delayTimes) {
//        amqpTemplate.convertAndSend("order.pay.exchange", "order.pay.queue","大家好我是延迟数据", message -> {
//            // 设置延迟毫秒值
//            message.getMessageProperties().setExpiration(String.valueOf(delayTimes));
//            return message;
//        });
//    }
}
