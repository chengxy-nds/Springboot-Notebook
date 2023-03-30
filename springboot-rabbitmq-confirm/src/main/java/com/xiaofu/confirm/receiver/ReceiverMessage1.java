package com.xiaofu.confirm.receiver;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: xiaofu
 * @Description:
 */
@Slf4j
@Component
@RabbitListener(queues = "confirm_test_queue")
public class ReceiverMessage1 {

    private int retryNum = 5;

    private int currentNum = 0;


//    @RabbitHandler
//    public void processHandler(String msg, Channel channel, Message message) throws IOException {
//
//        try {
//            log.info("消费者 2 号收到：{}", msg);
//
//            int a = 1 / 0;
//
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//
//        } catch (Exception e) {
//
//            if (currentNum <= 1000) {
//
//                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
//            }
//            currentNum++;
//        }
//    }

    @RabbitHandler
    public void processHandler(CorrelationData correlationData , String msg, Channel channel, Message message) throws IOException {

        try {
            log.info("消费者 2 号收到：{}", msg);

            String correlationId = (String) message.getMessageProperties().getHeaders().get("spring_returned_message_correlation");

            System.out.println(correlationId);

            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

        } catch (Exception e) {

        }
    }
}