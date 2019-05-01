package com.test.thread.cci;

public class Withdrawl implements Runnable{
    private LockedATM atm;
    private int val;

    public Withdrawl(LockedATM atm, int val) {
        this.atm = atm;
        this.val = val;
    }

    @Override
    public void run() {
        atm.withdraw(val);
    }
}
