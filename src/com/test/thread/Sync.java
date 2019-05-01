package com.test.thread;

public class Sync {

    private int x;


    public synchronized int getX(){
        System.out.println("In " + Thread.currentThread().getName());
        return x;
    }

    public synchronized void setX(int x){
        System.out.println("In " + Thread.currentThread().getName());
        this.x = x;
    }

    public static void main(String[] args) {
        Sync sync = new Sync();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println(sync.getX());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sync.setX(4);
                    Thread.sleep(2000);
                    System.out.println(sync.getX());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
