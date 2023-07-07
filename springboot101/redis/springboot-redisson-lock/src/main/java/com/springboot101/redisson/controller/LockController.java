package com.springboot101.redisson.controller;

import org.redisson.api.RFuture;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

/**
 * @Author: 公众号：程序员小富
 * @Description:
 */
@Controller
@RequestMapping("/lock")
public class LockController {

    @Autowired
    private RedissonClient redissonClient;

    /**
     * @author xiaofu
     * @description 可重入锁-普通
     * @date 2020/7/16 15:20
     */
    @GetMapping("/reduceStock2")
    @ResponseBody
    public String reentrantLock(String order) {

        RLock reentrantLock = redissonClient.getLock(order);
        try {
            if (reentrantLock.tryLock(100, 8, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getName() + "---" + order + "---" + "加锁成功");
                Thread.currentThread().sleep(10000);
                return "YES";
            } else {
                System.out.println("线程 " + Thread.currentThread().getName() + "---" + order + "---" + "加锁失败");
            }
        } catch (Exception e) {
            //reentrantLock.unlock();
        } finally {
            //reentrantLock.unlock();
        }
        return "NO";
    }

    /**
     * @author xiaofu
     * @description 可重入锁-设置过期时间
     * @date 2020/7/16 15:20
     */
    public String reentrantLock2(String order) {

        RLock reentrantLock = redissonClient.getLock(order);
        try {
            // 100尝试加锁的时间 ，10锁过期时间
            if (reentrantLock.tryLock(100, 10, TimeUnit.SECONDS)) {
                //Thread.currentThread().sleep(10000);
                System.out.println(order + "加锁成功");
            } else {
                System.out.println(order + "已加锁");
            }
        } catch (Exception e) {
            reentrantLock.unlock();
        } finally {
            reentrantLock.unlock();
        }
        return "success";
    }

    /**
     * @author xiaofu
     * @description 异步可重入锁-设置过期时间
     * @date 2020/7/16 15:20
     */
    public void reentrantLock2Async() {

        RLock reentrantLock = redissonClient.getLock("order:A0001");
        try {

            // 100尝试加锁的时间 ，10锁过期时间
            final RFuture<Boolean> booleanRFuture = reentrantLock.tryLockAsync(100, 10, TimeUnit.SECONDS);
            if (booleanRFuture.get()) {
                //TODO something
            }
        } catch (Exception e) {
            reentrantLock.unlock();
        } finally {
            reentrantLock.unlock();
        }
    }

    /**
     * @author xiaofu
     * @description 公平锁
     * @date 2020/7/16 15:20
     */
    public void fairLock() {

        RLock fairLock = redissonClient.getFairLock("order:A0001");
        /**
         * 开启异步模式
         */
        fairLock.lockAsync();
        try {

            if (fairLock.tryLock(100, 10, TimeUnit.SECONDS)) {
                //TODO something
            }
        } catch (Exception e) {
            fairLock.unlock();
        } finally {
            fairLock.unlock();
        }
    }

    /**
     * @author xiaofu
     * @description 联锁
     * @date 2020/7/16 15:20
     */
    public void multiLock() {

        RLock lock1 = redissonClient.getLock("order:A0001");
        RLock lock2 = redissonClient.getLock("order:A0002");
        RLock lock3 = redissonClient.getLock("order:A0003");
        RLock multiLock = redissonClient.getMultiLock(lock1, lock2, lock3);
        try {

            if (multiLock.tryLock(100, 10, TimeUnit.SECONDS)) {
                //TODO something
            }
        } catch (Exception e) {
            multiLock.unlock();
        } finally {
            multiLock.unlock();
        }
    }

    /**
     * @author xiaofu
     * @description 红锁
     * @date 2020/7/16 15:20
     */
    public void redLock() {

        RLock lock1 = redissonClient.getLock("order:A0001");
        RLock lock2 = redissonClient.getLock("order:A0002");
        RLock lock3 = redissonClient.getLock("order:A0003");
        RLock redLock = redissonClient.getRedLock(lock1, lock2, lock3);
        try {

            if (redLock.tryLock(100, 10, TimeUnit.SECONDS)) {
                //TODO something
            }
        } catch (Exception e) {
            redLock.unlock();
        } finally {
            redLock.unlock();
        }
    }

    /**
     * @author xiaofu
     * @description 读写锁
     * @date 2020/7/16 15:20
     */
    public void readWriteLock() {

        RReadWriteLock readWriteLock = redissonClient.getReadWriteLock("order:A0001");

        try {

            if (readWriteLock.writeLock().tryLock(100, 10, TimeUnit.SECONDS)) {
                //TODO something
            }

            if (readWriteLock.readLock().tryLock(100, 10, TimeUnit.SECONDS)) {
                //TODO something
            }

            if (readWriteLock.readLock().tryLock(100, 10, TimeUnit.SECONDS)) {
                //TODO something
            }

        } catch (Exception e) {
            readWriteLock.writeLock().unlock();
            readWriteLock.readLock().unlock();
        } finally {
            readWriteLock.writeLock().unlock();
            readWriteLock.readLock().unlock();
        }
    }

}
