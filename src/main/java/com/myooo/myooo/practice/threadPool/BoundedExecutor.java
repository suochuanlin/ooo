package com.myooo.myooo.practice.threadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

public class BoundedExecutor {

    private final Executor executor;
    private final Semaphore semaphore;


    public BoundedExecutor(Executor executor, int bound) {
        this.executor = executor;
        this.semaphore = new Semaphore(bound);
    }

    public void submitTask(final Runnable command) throws InterruptedException {
        semaphore.acquire();
        try {
            executor.execute(() -> {
                try {
                    System.out.println("command submit");
                    command.run();
                } finally {
                    semaphore.release();
                }
            });
        } catch (RejectedExecutionException e) {
            semaphore.release();
        }

    }

    //执行
    public static void main(String[] args) throws InterruptedException {
        //newFixedThreadPool 为无界队列
        BoundedExecutor be = new BoundedExecutor(Executors.newFixedThreadPool(6), 3);
        for (int i = 0; i < 10; i++) {
            //构造一个Runnable 任务
            be.submitTask(() -> {
                while (true) {
                    System.out.println("线程ID: " + Thread.currentThread().getId());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
