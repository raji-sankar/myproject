package com.test.thread.concurrent.threadlocal;

import java.text.DateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable{



    private static ThreadLocal<Date> startDate = new ThreadLocal<Date>(){
        @Override
        protected Date initialValue() {
            return new Date();
        }
    };


    @Override
    public void run() {

        System.out.printf("Starting thread: %s : %s\n", Thread.currentThread().getId(), startDate.get());

        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Finished thread: %s : %s\n", Thread.currentThread().getId(), startDate.get());

    }

    public static void main(String[] args) {
        SafeTask task = new SafeTask();
        for (int i=0; i<10; i++){
            Thread thread = new Thread(task);
            thread.start();

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
