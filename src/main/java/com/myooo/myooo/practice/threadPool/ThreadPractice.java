package com.myooo.myooo.practice.threadPool;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPractice {

    private ReentrantLock lock = new ReentrantLock();
    private Condition fooCondition = lock.newCondition();
    private Condition barCondition = lock.newCondition();

    // 缓存参数
    private int c = 1;

    private final int n;
    public ThreadPractice(int n) {
        this.n = n;
    }

    /**
     * 调用方法
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ThreadPractice practice = new ThreadPractice(2);
        Thread thread1 = new Thread(()-> {
            try {
                practice.helloRun(new Print_World());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        Thread thread2 = new Thread(()-> {
            try {
                practice.worldRun(new Print_Hello());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread2.start();

    }


    public void helloRun(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            if (c != 1) {
                fooCondition.await(); //释放锁在此等待
            }
            printFoo.run();
            barCondition.signal();
            c = 2;
            lock.unlock();
        }
    }
    public void worldRun(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            if (c != 2) {
                barCondition.await();
            }
            printBar.run();
            fooCondition.signal();
            c = 1;
            lock.unlock();
        }
    }

    static class Print_Hello implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Hello\n");
        }
    }
    static class Print_World implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " World\n");
        }
    }


}
