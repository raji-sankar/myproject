package com.test.thread;

public class Synchronized extends Thread {

    private final String action;

    public Synchronized(String action) {
        this.action = action;
    }

    synchronized void doFirst() {
        System.out.println(Thread.currentThread().getName() + " First operation");
    }

    synchronized void doSecond() {
        System.out.println(Thread.currentThread().getName() + " Second operation");
    }

    synchronized void doBoth() {
        doFirst();
        doSecond();
    }

    @Override
    public void run() {
        if (action == "first"){
            doFirst();
        } else if (action =="second"){
            doSecond();
        }else {
            doBoth();
        }
    }

    @Override
    public synchronized void start() {
        System.out.println(action + " " + Thread.currentThread().getName() + " starting");
        super.start();
    }

    public static void main(String[] args) {

//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                Synchronized syn = new Synchronized();
//                syn.doFirst();
//            }
//        });
//
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                Synchronized syn = new Synchronized();
//                syn.doSecond();
//            }
//        });
//
//        Thread t3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                Synchronized syn = new Synchronized();
//                syn.doBoth();
//            }
//        });

        Synchronized t1 = new Synchronized("first");
        Synchronized t2 = new Synchronized("second");
        Synchronized t3 = new Synchronized("third");


        t2.start();
        t3.start();
        t1.start();

    }

}


