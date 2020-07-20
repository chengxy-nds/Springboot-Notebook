package com.chengxy.delayqueue.delayQueue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: xiaofu
 * @Description:
 */
public class DelayQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        Order Order1 = new Order("Order1", 5, TimeUnit.SECONDS);
        Order Order2 = new Order("Order2", 10, TimeUnit.SECONDS);
        Order Order3 = new Order("Order3", 15, TimeUnit.SECONDS);

        DelayQueue<Order> delayQueue = new DelayQueue<>();

        delayQueue.put(Order1);
        delayQueue.put(Order2);
        delayQueue.put(Order3);

        System.out.println("订单延迟队列开始时间:" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        while (delayQueue.size() != 0) {

            /**
             * 取队列头部元素是否过去
             */
            Order task = delayQueue.poll();
            Order task1 = delayQueue.take();


            if (task1 != null) {
                System.out.format("订单:{%s}被取消, 取消时间:{%s}\n", task1.name, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }else{
                System.out.println("null");
            }
        }
    }
}