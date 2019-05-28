package com.test.thread.concurrent;

public class SynchronizedMethods {

    synchronized public void  methodA(){
        System.out.println(Thread.currentThread().getName() + "in methodA");
        methodB();
    }

    synchronized public void methodB(){
        System.out.println(Thread.currentThread().getName() + "in methodB");

    }

    public static void main(String[] args) {
        SynchronizedMethods sm = new SynchronizedMethods();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                sm.methodA();;
            }
        }, "T1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                sm.methodB();;
            }
        }, "T2");

        System.out.println("T1 state " + t1.getState());
        System.out.println("T2 state " + t2.getState());

        t1.start();

        System.out.println("T1 state " + t1.getState());
        System.out.println("T2 state " + t2.getState());
        t2.start();

        System.out.println("T1 state " + t1.getState());
        System.out.println("T2 state " + t2.getState());
    }
}
