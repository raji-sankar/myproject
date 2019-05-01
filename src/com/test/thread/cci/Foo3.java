package com.test.thread.cci;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Foo3 {

    private Semaphore sem1 = new Semaphore(1);
    private Semaphore sem2 = new Semaphore(1);
    private Semaphore sem3 = new Semaphore(1);

    public Foo3 () throws InterruptedException {
        sem1.acquire();
        sem2.acquire();
        sem3.acquire();

    }

    public void first() throws InterruptedException{

        System.out.println(Thread.currentThread().getName() + " -first");
        System.out.println(Thread.currentThread().getName() + " - in first releasing sem1");
        sem1.release();

    }

    public void second() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " - starting second, waiting to acquire sem1");
        sem1.acquire();
        System.out.println(Thread.currentThread().getName() + " -  second, releasing sem1");
        sem1.release();
        System.out.println(Thread.currentThread().getName() + " -second");
        System.out.println(Thread.currentThread().getName() + " -  second, releasing sem1");
        sem2.release();

    }

    public void third() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " - starting third, waiting to acquire sem2");
        sem2.acquire();
        System.out.println(Thread.currentThread().getName() + " -  third, releasing sem2");
        sem2.release();
        System.out.println(Thread.currentThread().getName() + " -third");
        sem3.release();

    }

    public static void main(String[] args) throws InterruptedException {

        Foo3 foo = new Foo3();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

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
