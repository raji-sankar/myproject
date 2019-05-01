package com.test.thread;

public class VolatileFlag implements Runnable{

    private volatile boolean shouldStop = false;

    @Override
    public void run() {
        while (!shouldStop){
            System.out.println(Thread.currentThread().getName() + ": Running");
        }
    }

    void stop(){
        System.out.println(Thread.currentThread().getName() + "Stopping");
        shouldStop = true;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileFlag flag = new VolatileFlag();

        Thread thread = new Thread(flag);
        Thread thread2 = new Thread(flag);
        thread.start();
        thread2.start();

        Thread.sleep(30);
        flag.stop();
        thread.join();
//        thread2.join();
    }
}
