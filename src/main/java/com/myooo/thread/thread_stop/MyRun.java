package com.myooo.thread.thread_stop;

public class MyRun {
    public static void main(String[] args) {

        try {
            MyThread t = new MyThread();
            t.start();
            Thread.sleep(1000);
            t.interrupt();
            System.out.println("mythread is interrupte " + t.isInterrupted());
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
    }
}
