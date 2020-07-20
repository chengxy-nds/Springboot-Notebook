package com.xiaofu.redisson.controller;

import org.redisson.api.RFuture;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

/**
 * @Author: xinzhifu
 * @Description:
 */
@Controller
@RequestMapping
public class LockController {

    @Autowired
    private RedissonClient redissonClient;

    @RequestMapping("/reduceStock")
    @ResponseBody
    public String reduceStock() {

        RLock lock = redissonClient.getLock("order:A0001");
        try {
            lock.lock(5, TimeUnit.SECONDS);
            Thread.currentThread().sleep(30000);
            lock.unlock();
            System.out.println("锁释放~");

        } catch (Exception e) {
            lock.unlock();
        }
        return null;
    }


    /**
     * @author xinzhifu
     * @description 可重入锁-普通
     * @date 2020/7/16 15:20
     */
    public void reentrantLock() {

        RLock reentrantLock = redissonClient.getLock("order:A0002");
        try {
            reentrantLock.lock();
            //TODO something
            reentrantLock.unlock();

        } catch (Exception e) {
            reentrantLock.unlock();
        } finally {
            reentrantLock.unlock();
        }
    }

    /**
     * @author xinzhifu
     * @description 可重入锁-设置过期时间
     * @date 2020/7/16 15:20
     */
    public void reentrantLock2() {

        RLock reentrantLock = redissonClient.getLock("order:A0001");
        try {

            // 100尝试加锁的时间 ，10锁过期时间
            if (reentrantLock.tryLock(100, 10, TimeUnit.SECONDS)) {
                //TODO something
            }
        } catch (Exception e) {
            reentrantLock.unlock();
        } finally {
            reentrantLock.unlock();
        }
    }

    /**
     * @author xinzhifu
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
     * @author xinzhifu
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
     * @author xinzhifu
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
     * @author xinzhifu
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
     * @author xinzhifu
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
