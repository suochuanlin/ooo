package com.myooo.myooo.practice.buildSynchronizationTool;

/**
 * 暴躁的处理
 * @param <V>
 */
public class GrumpyBoundedBuffer<V> extends BaseBoundedBuffer<V> {
    public GrumpyBoundedBuffer(int capacity) {
        super(capacity);
    }

    public synchronized void put(V v) throws BufferFullException {
        if (isFull()) {
            throw new BufferFullException();
        }
        doPut(v);
    }

    public synchronized V take() throws BufferFullException {
        if (isEmpty()) {
            throw new BufferEmptyException();
        }
        return doTake();
    }

    public static void main(String[] args) {
        GrumpyBoundedBuffer buffer = new GrumpyBoundedBuffer(2);
        buffer.put(1);
    }
}
