package com.test.thread.atomic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SimpleAtomicLongRWLock {

    private long value;

    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    public SimpleAtomicLongRWLock(long value) {
        this.value = value;
    }

    public long get() {
        readLock.lock();

        try {
            return value;
        } finally{
            readLock.unlock();
        }
    }

    public long decrementAndGet(){
        writeLock.lock();
        try {
            value = value - 1;
            return value;
        }finally {
            writeLock.unlock();
        }
    }

    public long getAndIncrement(){
        writeLock.lock();
        try {
            long oldValue = value;
            value++;
            return oldValue;
        }finally {
            writeLock.unlock();
        }
    }

    public long incrementAndGet(){
        writeLock.lock();
        try {

            return value++;

        }finally {
            writeLock.unlock();
        }
    }

    public long getAnddecrement(){
        writeLock.lock();
        try {
            long old = value;
            value--;
            return old;
        }finally {
            writeLock.unlock();
        }
    }
}
