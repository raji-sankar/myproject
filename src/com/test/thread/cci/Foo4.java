package com.test.thread.cci;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Foo4 {

    private final ReentrantLock lock = new ReentrantLock();

    private int current = 0;
    private Condition notCurrent = lock.newCondition();


    public void first(){
        lock.lock();
        try {
            while (current != 0){
                notCurrent.await();
            }
            System.out.println(Thread.currentThread().getName() + " called first");
            current += 1;
            notCurrent.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    public void second(){
        lock.lock();
        try {
            while (current != 1){
                notCurrent.await();
            }
            System.out.println(Thread.currentThread().getName() + " called second");
            current += 1;
            notCurrent.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void third(){
        lock.lock();
        try {
            while (current != 2){
                notCurrent.await();
            }
            System.out.println(Thread.currentThread().getName() + " called first");
            current = 0;
            notCurrent.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args)  {
        Foo foo = new Foo();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                foo.first();
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
