package com.myooo.threadPool;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

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
        ThreadPractice practice = new ThreadPractice(10);
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
            System.out.println(Thread.currentThread().getName() + "拿到了锁 信号");
            if (c != 1) {
                System.out.println(Thread.currentThread().getName() + "等待信号");
                fooCondition.await();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barCondition.signal();
            c = 2;
            lock.unlock();
        }
    }
    public void barmyself(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            if (c != 2) {
                barCondition.await();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printBar.run();
            fooCondition.signal();
            c = 1;
            lock.unlock();
        }
    }


}
