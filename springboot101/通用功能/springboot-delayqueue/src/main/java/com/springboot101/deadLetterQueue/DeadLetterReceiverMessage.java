package com.springboot101.deadLetterQueue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: 公众号：程序员小富
 * @Description:
 */
@Slf4j
@Component
@RabbitListener(queues = RabbitConstant.IOT_VIRTUAL_DEVICE_CLOSE_QUEUE)
public class DeadLetterReceiverMessage {

    @RabbitHandler
    public void receiver(String val) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("收到延时消息时间："+sdf.format(new Date()) + " Delay sent.");
        System.out.println("收到延时消息了:" + val);
    }
}
