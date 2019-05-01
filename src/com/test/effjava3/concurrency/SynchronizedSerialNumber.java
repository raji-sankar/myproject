package com.test.effjava3.concurrency;

public class SynchronizedSerialNumber {

    private static long nextSerialNumber;

    public static synchronized long generateSerialNumber(){
        return nextSerialNumber++; //not atomic
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++){
            Thread t = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ": " + generateSerialNumber())  ;
            });
            t.start();
        }
    }



}
