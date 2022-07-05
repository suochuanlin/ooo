package com.myooo.myooo.practice.buildSynchronizationTool;

/**
 * 温和的轮训+休眠
 * @param <V>
 */
public class SleepyBoundedBuffer<V> extends BaseBoundedBuffer<V> {

    private static final long SLEEP_GRANULARITY = 1000L;

    public SleepyBoundedBuffer(int capacity) {
        super(capacity);
    }

    public void put(V v) throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (!isFull()) {
                    doPut(v);
                    return;
                }
            }
            Thread.sleep(SLEEP_GRANULARITY);
        }
    }

    public V take() throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (!isEmpty()) {
                    return doTake();
                }
            }
            Thread.sleep(SLEEP_GRANULARITY);
        }
    }
}
