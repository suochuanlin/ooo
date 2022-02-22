package com.myooo.thread.thread_stop;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyThread extends Thread{

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            if (Thread.currentThread().isInterrupted()) {
                log.info("停止 ");
//                try {
//                    throw new InterruptedException();
                    break;
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
            log.info("i= {}", i + 1);
        }
    }
}
