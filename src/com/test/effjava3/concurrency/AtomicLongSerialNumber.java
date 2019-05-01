package com.test.effjava3.concurrency;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongSerialNumber {

    private static AtomicLong nextSerialNumber = new AtomicLong();

    public static long generateSerialNumber(){
        return nextSerialNumber.getAndIncrement();
    }

    public static void main(String[] args){
        for (int i = 0; i < 100; i++){
            Thread t = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ": " + generateSerialNumber())  ;
            });
            t.start();
        }

    }

}
