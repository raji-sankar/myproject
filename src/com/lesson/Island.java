package com.lesson;

import java.util.concurrent.TimeUnit;

public class Island {

    Island next;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize called");
    }

    public static void main(String[] args) throws InterruptedException {
        Island one = new Island();
        Island two = new Island();

        one.next = two;
        two.next = one;

        one = null;
        two = null;

        System.gc();

        Thread.sleep(25000);
        System.out.println("Done");
    }
}
