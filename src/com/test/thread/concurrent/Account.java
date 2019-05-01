package com.test.thread.concurrent;

import java.util.concurrent.TimeUnit;

public class Account {

    private long id;
    private long amount;

    public Account(long id, long amount) {
        this.id = id;
        this.amount = amount;
    }

    void plus(long amount){

        this.amount += amount;
    }

    void minus(long amount){
        if (this.amount < amount){
            throw new IllegalArgumentException("Insufficient balance");
        }
        this.amount -=  amount;
    }

    public String toString(){
        return "Id = " + id +", Balance = " + amount;
    }

    static void transferWithDeadlock(long amount, Account first, Account second) throws InterruptedException {
        synchronized (first){
            synchronized (second){
                first.minus(amount);
                second.plus(amount);
                TimeUnit.SECONDS.sleep(5);
                System.out.println(first);
                System.out.println(second);
            }
        }
    }

    static void transferWithOrdering(long amount, Account first, Account second){
        boolean lockOnFirstAccountFirst = first.id < second.id;
        Account firstLock = lockOnFirstAccountFirst ? first : second;
        Account secondLock = lockOnFirstAccountFirst ? second : first;
        synchronized (firstLock){
            synchronized (secondLock){
                first.minus(amount);
                second.plus(amount);
            }
        }
    }



//    static void  transferWithLockOrdering(long amount, Account first, Account second)

    public static void main(String[] args) {
        Account first = new Account(1, 200);
        Account second = new Account(2, 100);

        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
//                    transferWithDeadlock(50, first, second);
                    transferWithOrdering(50, first, second);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
//                    transferWithDeadlock(25, second, first);
                    transferWithOrdering(25, second, first);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        t1.start();
        t2.start();
        System.out.println(first);
        System.out.println(second);
    }
}
