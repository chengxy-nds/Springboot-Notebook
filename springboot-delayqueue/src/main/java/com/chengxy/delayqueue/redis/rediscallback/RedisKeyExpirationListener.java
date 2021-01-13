//package com.chengxy.delayqueue.redis.rediscallback;
//
//import org.springframework.data.redis.connection.Message;
//import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
//import org.springframework.data.redis.listener.RedisMessageListenerContainer;
//import org.springframework.stereotype.Component;
//
///**
// * @Author: xiaofu
// * @Description:
// */
//@Component
//public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {
//
//    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
//        super(listenerContainer);
//    }
//
//    @Override
//    public void onMessage(Message message, byte[] pattern) {
//        String expiredKey = message.toString();
//        System.out.println("监听到key：" + expiredKey + "已过期");
//
//    }
//}