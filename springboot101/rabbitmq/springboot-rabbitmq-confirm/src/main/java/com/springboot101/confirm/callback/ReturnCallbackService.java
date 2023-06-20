package com.springboot101.confirm.callback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author: 公众号：程序员小富
 * @Description:
 */
@Slf4j
@Component
public class ReturnCallbackService implements RabbitTemplate.ReturnCallback {

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.info("returnedMessage ===> replyCode={} ,replyText={} ,exchange={} ,routingKey={}", replyCode, replyText, exchange, routingKey);
    }
}
