package com.test.effjava3.concurrency;

import java.util.concurrent.TimeUnit;

public class StopThread {

    //stopRequested needs to be volatile
    private static volatile boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
                System.out.println(i);
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;

    }
}
