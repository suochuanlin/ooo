package com.myooo.threadPool;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://www.cnblogs.com/gemine/p/9039012.html
 * https://leetcode-cn.com/problems/print-foobar-alternately/
 *
 */
public class ThreadPractice {

    private ReentrantLock lock = new ReentrantLock();
    private Condition fooCondition = lock.newCondition();
    private Condition barCondition = lock.newCondition();
    private int count = 1;
    private int n;

    public ThreadPractice(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            if(count != 1) {
                fooCondition.await();
            }
            printFoo.run();
            barCondition.signal();
            count=2;
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            if(count != 2) {
                barCondition.await();
            }
            printBar.run();
            fooCondition.signal();
            count=1;
            lock.unlock();
        }
    }

    static class Print_Bar implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "Bar");
        }
    }

    static class Print_Foo implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "Foo");
        }
    }



    public static void main(String[] args) throws InterruptedException {
        ThreadPractice practice = new ThreadPractice(2);
        Thread thread1 = new Thread(()-> {
            try {
                practice.foomyself(new Print_Foo());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.setName("ceshi-> thread 1");
        thread1.start();
        Thread thread2 = new Thread(()-> {
            try {
                practice.barmyself(new Print_Bar());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread2.setName("thread2");
        thread2.start();

    }


    private int c = 1;

    public void foomyself(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "【foomyself】 拿到了锁");
            if (c != 1) {
                fooCondition.await(); //释放锁在此等待
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barCondition.signal();
            System.out.println(Thread.currentThread().getName() + " 【foomyself】 发出了信号");

            c = 2;
            lock.unlock();
        }
    }
    public void barmyself(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "【barmyself】 拿到了锁");

            if (c != 2) {
                barCondition.await();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printBar.run();
            fooCondition.signal();
            System.out.println(Thread.currentThread().getName() + "【barmyself】 发出了信号");

            c = 1;
            lock.unlock();
        }
    }


}
