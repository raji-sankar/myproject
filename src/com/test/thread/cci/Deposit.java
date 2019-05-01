package com.test.thread.cci;

public class Deposit implements Runnable{
    private LockedATM atm;
    private int val;

    public Deposit(LockedATM atm, int val) {
        this.atm = atm;
        this.val = val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public void run() {
        atm.deposit(val);
    }
}
