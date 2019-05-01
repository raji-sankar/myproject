package com.test.thread.cci;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockedATM {

    private Lock lock;
    private int balance = 100;

    public LockedATM() {
        lock = new ReentrantLock();
    }

    public int withdraw(int value){
        lock.lock();
        try {
            Thread.sleep(100);
            balance = balance - value;
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        System.out.println("withdrawing " + value + "; balance " + balance);
        return balance;
    }

    public int deposit(int value){
        lock.lock();
        try {
            Thread.sleep(100);
            balance = balance + value;
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        System.out.println("depositing " + value + "; balance " + balance);
        return balance;
    }





    public static void main(String[] args) {
        LockedATM atm = new LockedATM();
        Withdrawl w1 = new Withdrawl(atm, 50);
        Deposit d1 = new Deposit(atm, 40);
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(d1);
        t1.start();
        t2.start();
        Withdrawl w2 = new Withdrawl(atm, 50);
        Deposit d2 = new Deposit(atm, 40);
        Thread t3 = new Thread(w2);
        Thread t4 = new Thread(d2);
        t3.start();
        t4.start();
    }
}
