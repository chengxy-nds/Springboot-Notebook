//package com.chengxy.delayqueue.redis;
//
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.Tuple;
//
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.Set;
//
///**
// * @Author: xiaofu
// * @Description:
// */
//public class RedisDelayQueue {
//
//    private JedisPool jedisPool = null;
//    // Redis服务器IP
//    private String ADDR = "127.0.0.1";
//    // Redis的端口号
//    private int PORT = 6379;
//
//    private static String DELAY_QUEUE = "delayqueue";
//
//    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//    public RedisDelayQueue() {
//        jedisPool = new JedisPool(ADDR, PORT);
//    }
//
//    public static void main(String[] args) {
//
//        RedisDelayQueue redisDelay = new RedisDelayQueue();
//        redisDelay.pushOrderQueue();
//        redisDelay.pollOrderQueue();
//        redisDelay.deleteZSet();
//    }
//
//    public void deleteZSet() {
//        Jedis jedis = jedisPool.getResource();
//        jedis.del(DELAY_QUEUE);
//    }
//
//    /**
//     * 消息入队
//     */
//    public void pushOrderQueue() {
//        Jedis jedis = jedisPool.getResource();
//        Calendar cal1 = Calendar.getInstance();
//        cal1.add(Calendar.SECOND, 10);
//        int order1 = (int) (cal1.getTimeInMillis() / 1000);
//
//        Calendar cal2 = Calendar.getInstance();
//        cal2.add(Calendar.SECOND, 20);
//        int order2 = (int) (cal2.getTimeInMillis() / 1000);
//
//        Calendar cal3 = Calendar.getInstance();
//        cal3.add(Calendar.SECOND, 30);
//        int order3 = (int) (cal3.getTimeInMillis() / 1000);
//
//        jedis.zadd(DELAY_QUEUE, order1, "order1");
//        jedis.zadd(DELAY_QUEUE, order2, "order2");
//        jedis.zadd(DELAY_QUEUE, order3, "order3");
//        System.out.println(sdf.format(new Date()) + " add finished.");
//    }
//
//    /**
//     * 消费消息
//     */
//    public void pollOrderQueue() {
//
//        Jedis jedis = jedisPool.getResource();
//        while (true) {
//
//            Set<Tuple> set = jedis.zrangeWithScores(DELAY_QUEUE, 0, 0);
//
//            String value = ((Tuple) set.toArray()[0]).getElement();
//            int score = (int) ((Tuple) set.toArray()[0]).getScore();
//
//            Calendar cal = Calendar.getInstance();
//            int nowSecond = (int) (cal.getTimeInMillis() / 1000);
//
//            if (nowSecond >= score) {
//                jedis.zrem(DELAY_QUEUE, value);
//                System.out.println(sdf.format(new Date()) + " removed key:" + value);
//            }
//
//            if (jedis.zcard(DELAY_QUEUE) <= 0) {
//                System.out.println(sdf.format(new Date()) + " zset empty ");
//                return;
//            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//}
