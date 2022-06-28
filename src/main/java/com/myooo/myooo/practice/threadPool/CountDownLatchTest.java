package com.myooo.myooo.practice.threadPool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

    private ThreadPoolExecutor WORK_POOL = new ThreadPoolExecutor(6,6,1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(12));

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchTest test = new CountDownLatchTest();
        test.testCountLatch();
    }

    public void testCountLatch() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            WORK_POOL.execute(() -> {
                System.out.println(Thread.currentThread().getId() + ", id 开始");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId() + ", id 完成");
            });
        }
        boolean isEnd = countDownLatch.await(1000, TimeUnit.MICROSECONDS);
        if (!isEnd) {
            System.out.println("指定时间未完成");
            //回退操作等等
        }
    }
}
