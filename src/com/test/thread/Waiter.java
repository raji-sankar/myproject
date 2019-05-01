package com.test.thread;

public class Waiter implements Runnable {

    private boolean shouldFinish;

    void finish(){
        shouldFinish = true;
    }

    @Override
    public void run() {
        long iteration = 0;
        while(!shouldFinish){
            iteration++;
            System.out.println("Thread " + Thread.currentThread().getName() + " iteration: " + iteration);
        }
        System.out.println("Thread " + Thread.currentThread().getName() + ": Finished after: " + iteration);
    }
}

class DataRace {

    public static void main(String[] args) throws InterruptedException {
        Waiter waiter = new Waiter();
        Thread waiterThread = new Thread(waiter);

        waiterThread.start();
        Thread.sleep(1000);
        waiter.finish();
        waiterThread.join();
    }
}
