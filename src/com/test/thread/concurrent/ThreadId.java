package com.test.thread.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;





public class ThreadId implements Runnable{

    private static final AtomicInteger nextId = new AtomicInteger(0);

    private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return nextId.getAndIncrement();
        }
    };

    public static int get(){
        return threadId.get();
    }


    @Override
    public void run() {
        System.out.println("Starting thread " +  Thread.currentThread().getName() + ": " + threadId.get());

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished thread " +  Thread.currentThread().getName() + ": " + threadId.get());
    }


    public static void main(String[] args) {

        final int n = 10;
        ThreadId threadId = new ThreadId();

        for (int i=0; i<n; i++){
            Thread t = new Thread(threadId);
            t.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
