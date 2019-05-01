package com.test.thread;

public class TestInterrupted {

    public static void main(String[] args) {
        System.out.println("Entering main()");

        final Boolean interruptThread = args.length == 0;

        GCDRunnable gcdRunnable = new GCDRunnable();

        Thread thr = new Thread(gcdRunnable);
        Thread thr2 = new Thread(gcdRunnable);

        thr.start();
        thr2.start();

        try {
            if(interruptThread) {
                Thread.sleep(1000);

                System.out.println("interrupting thread " + thr.getName());

                thr.interrupt();
            }
            thr2.join();

            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        System.out.println("Leaving main()");
    }
}
