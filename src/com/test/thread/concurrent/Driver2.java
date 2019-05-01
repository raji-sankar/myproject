package com.test.thread.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class WorkerRunnable implements Runnable {
    private final CountDownLatch doneSignal;
    private final int i;

    public WorkerRunnable(CountDownLatch doneSignal, int i) {
        this.doneSignal = doneSignal;
        this.i = i;
    }

    @Override
    public void run() {
        doWork(i);
        doneSignal.countDown();
    }

    private void doWork(int i) {
        System.out.println(Thread.currentThread().getName() + " - "
                + Thread.currentThread().getThreadGroup() +" In doWork "
                + "doneSignal "+ doneSignal.toString() + " count "
                + doneSignal.getCount());
    }
}

public class Driver2 {


    public static void main(String[] args) throws InterruptedException {
        final int n = 30;
        CountDownLatch doneSignal = new CountDownLatch(n);
        Executor executor = Executors.newWorkStealingPool(2);
        System.out.println(Thread.currentThread().getName() + " - "
                + Thread.currentThread().getThreadGroup() +" In main "
                + "doneSignal "+ doneSignal.toString());

        for (int i=0; i < n+1; i++){
            executor.execute(new WorkerRunnable(doneSignal, i));
        }

        System.out.println(Thread.currentThread().getName() + " - "
                + Thread.currentThread().getThreadGroup() +" In main "
                + "doneSignal "+ doneSignal.toString());
        doneSignal.await();
    }






}
