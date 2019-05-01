package com.test.thread.cci;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Foo {

    private static final int MAX = 3;
    //    private final Semaphore available = new Semaphore(MAX, true);
    private int current = 0;

    private boolean[] used = new boolean[MAX];

    public Foo() {
    }



    private Lock lock = new ReentrantLock();
    private final Condition notCurrent = lock.newCondition();

    public void first()  {

        lock.lock();
        try {
            while (current != 0) {
                notCurrent.await();
            }
            System.out.println(Thread.currentThread().getName() + " -first");
            current += 1;
            notCurrent.signalAll();

        } catch(InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public void second() throws InterruptedException {
        lock.lock();
        try {
            while (current != 1) {
                notCurrent.await();
            }
            System.out.println(Thread.currentThread().getName() + " -second");
            current += 1;
            notCurrent.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void third() throws InterruptedException {
        lock.lock();
        try {
            while (current != 2) {
                notCurrent.await();
            }
            System.out.println(Thread.currentThread().getName() + " -third");
            current = 0;
            notCurrent.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args)throws InterruptedException  {
        Foo foo = new Foo();
        Runnable r1 = foo::first;
        Thread t1 = new Thread(r1);


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.second();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.third();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t3.start();
        t2.start();
        t1.start();

    }


}
