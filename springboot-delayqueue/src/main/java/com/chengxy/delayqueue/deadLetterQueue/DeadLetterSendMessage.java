package com.chengxy.delayqueue.deadLetterQueue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @Author: xiaofu
 * @Description:
 */
@Component
public class DeadLetterSendMessage {

    @Resource
    private AmqpTemplate amqpTemplate;

    public void send(String delayTimes) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        amqpTemplate.convertAndSend(RabbitConstant.IOT_VIRTUAL_DEVICE_DELAY_EXCHANGE,RabbitConstant.IOT_VIRTUAL_DEVICE_DELAY_QUEUE, "大家好我是延迟数据" + delayTimes, message -> {
            message.getMessageProperties().setExpiration(delayTimes);
            System.out.println(sdf.format(new Date()) + " Delay sent.");
            return message;
        });
    }
}
