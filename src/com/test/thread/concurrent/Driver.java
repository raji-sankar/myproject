package com.test.thread.concurrent;

import java.util.concurrent.CountDownLatch;

class Worker implements Runnable {

    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    public Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " -"+ Thread.currentThread().getThreadGroup() +" waiting for start signal");
            startSignal.await();
            doWork();
            doneSignal.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void doWork() {
        System.out.println(Thread.currentThread().getName() + " -"+ Thread.currentThread().getThreadGroup() +" In doWork");
        System.out.println(Thread.currentThread().getName() + " -"+ Thread.currentThread().getThreadGroup() +
                " startSignal -" + startSignal.toString());

        System.out.println(Thread.currentThread().getName() + " -"+ Thread.currentThread().getThreadGroup() +
                " doneSignal -" + doneSignal.toString());
    }
}

public class Driver {
    /**
     * use of CountDownLatch - a syncbronization aid that allows one or more threads to wait until a set of
     * operations performed in other threads complete.
     */

    public static void main(String[] args) throws InterruptedException {
        int n = 10;
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(n);
        System.out.println(Thread.currentThread().getName() + " -"+ Thread.currentThread().getThreadGroup() +
                " startSignal -" + startSignal.toString());

        System.out.println(Thread.currentThread().getName() + " -"+ Thread.currentThread().getThreadGroup() +
                " doneSignal -" + doneSignal.toString());

        for (int i=0; i < n; i++)
            new Thread(new Worker(startSignal, doneSignal)).start();

        doSomethingElse();
        Thread.sleep(1000);
        startSignal.countDown();
        System.out.println(Thread.currentThread().getName() + " -"+ Thread.currentThread().getThreadGroup() +
                " startSignal -" + startSignal.toString());
        doSomethingElse();
        doneSignal.await();
        System.out.println(Thread.currentThread().getName() + " -"+ Thread.currentThread().getThreadGroup() +" Done");

        System.out.println(Thread.currentThread().getName() + " -"+ Thread.currentThread().getThreadGroup() +
                " startSignal -" + startSignal.toString());

        System.out.println(Thread.currentThread().getName() + " -"+ Thread.currentThread().getThreadGroup() +
                " doneSignal -" + doneSignal.toString());
    }

    private static void doSomethingElse() {
        System.out.println(Thread.currentThread().getName() + " -"+ Thread.currentThread().getThreadGroup() +" In doSomethingElse");
    }

}
