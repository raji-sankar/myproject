package com.test.thread.cci;

import java.util.concurrent.Semaphore;

public class Foo2 {

    private Semaphore sem1;
    private Semaphore sem2;
    private Semaphore sem3;

    public Foo2() throws InterruptedException {
        sem1 = new Semaphore(1);
        sem2 = new Semaphore(1);
        sem3 = new Semaphore(1);
        sem1.acquire();
        sem2.acquire();
        sem3.acquire();
    }

    public void first() throws InterruptedException {

        try {
            System.out.println(Thread.currentThread().getName() + " -first");
        } finally {
            sem1.release();
        }

    }

    public void second() throws InterruptedException {
        sem1.acquire();
        sem1.release();

        try {
            System.out.println(Thread.currentThread().getName() + " -second");
        } finally {
            sem2.release();
        }

    }

    public void third() throws InterruptedException {
        sem2.acquire();
        sem2.release();
        try {
            System.out.println(Thread.currentThread().getName() + " -third");
        } finally {
            sem3.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Foo2 foo = new Foo2();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.second();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.third();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t3.start();
        t2.start();
        t1.start();
    }
}
