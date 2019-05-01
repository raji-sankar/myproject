package com.test.thread.atomic;

import java.util.concurrent.locks.StampedLock;

public class StampedAtomicLong {

    private final long value;

    private final StampedLock lock = new StampedLock();

    public StampedAtomicLong(long value) {
        this.value = value;
    }
}
