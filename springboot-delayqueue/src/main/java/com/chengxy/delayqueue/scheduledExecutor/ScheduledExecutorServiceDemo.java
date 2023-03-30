package com.chengxy.delayqueue.scheduledExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Author: xiaofu
 * @Description:
 */
public class ScheduledExecutorServiceDemo {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(100);

        for (int i = 10; i > 0; i--) {

            executor.schedule(() -> System.out.println("Work start, thread id:" + Thread.currentThread().getId() + " " + sdf.format(new Date())), i, TimeUnit.SECONDS);
        }
    }

    public void ScheduledExecutorServiceTest() throws InterruptedException {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        System.out.println("创建5秒延迟的任务");
        ScheduledFuture<?> schedule = scheduledExecutorService.schedule(() -> doTask("5s"), 5, TimeUnit.SECONDS);

        Thread.sleep(4900);

        schedule.cancel(false);
        System.err.println("取消5秒延迟的任务");


        System.out.println("创建3秒延迟的任务");
        ScheduledFuture<?> schedule2 = scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                doTask("3s");
            }
        }, 3, TimeUnit.SECONDS);

        Thread.sleep(4000);

    }

    private void doTask(String arg) {
        System.out.println(arg + " 任务执行 ");
    }
}
