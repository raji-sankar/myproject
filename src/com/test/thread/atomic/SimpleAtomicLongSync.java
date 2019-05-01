package com.test.thread.atomic;
//https://github.com/douglascraigschmidt/LiveLessons/blob/master/SimpleAtomicLong/src/SimpleAtomicLongSync.java
public class SimpleAtomicLongSync {

    private volatile long value;

    public SimpleAtomicLongSync(long value) {
        this.value = value;
    }

    public long get(){
        return value;
    }

    public long decrementAndGet(){
        synchronized (this){
            return --value;
        }
    }

    public long getAndIncrement(){
        synchronized (this){
            return value++;
        }
    }

    public long getAndDecrement(){
        synchronized (this){
            return value--;
        }
    }

    public long incrementAndGet(){
        synchronized (this){
            return ++value;
        }
    }
}
