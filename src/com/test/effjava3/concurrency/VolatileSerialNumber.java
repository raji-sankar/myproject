package com.test.effjava3.concurrency;

public class VolatileSerialNumber {

    /*
    Volatile will not work here, because ++ increment operator is not
    atomic. Synchronizing and using a long is a better solution.
    When multiple threads share mutable data, each thread that reads
    or writes the data must perform synchronization
     */

    private static volatile int nextSerialNumber = 0;

    public static int generateSerialNumber(){
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
