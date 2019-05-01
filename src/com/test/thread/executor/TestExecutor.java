package com.test.thread.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class TestExecutor {

    public static void main(String[] args) {


        final boolean demonThread = args.length > 0;


        GCDRunnable gcd = new GCDRunnable(demonThread ? "daemon" : "user");

        final int POOL_SIZE = 2;

        final ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable runnable) {
                Thread thr = new Thread(runnable);
                if (demonThread){
                    thr.setDaemon(true);
                }
                return thr;
            }
        };

        final Executor executor = Executors.newFixedThreadPool(POOL_SIZE, threadFactory);

        for (int i = 0; i < POOL_SIZE; i++){
            executor.execute(gcd);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex){

        }

        System.out.println("Exiting main()");
    }
}
