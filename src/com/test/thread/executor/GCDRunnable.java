package com.test.thread.executor;

import java.util.Random;

public class GCDRunnable extends Random implements Runnable {

    private final int MAX_ITERATIONS =  100000000;

    private final String threadType;

    public GCDRunnable(String threadType) {
        this.threadType = threadType;
    }

    public int computeGCD(int number1, int number2){
        if (number2 == 0){
            return number1;
        }
        return computeGCD(number1, number1 % number2);
    }
    @Override
    public void run() {
        System.out.println("Begin run method " + threadType);
        final String threadString = " with " + threadType + "thread id " + Thread.currentThread();

        for (int i = 0; i < MAX_ITERATIONS; i++) {

            if (i % 1000000 == 0) {
                int number1 = nextInt();
                int number2 = nextInt();


                System.out.println("In run method " + threadString + " computeGCD number1 " + number1 + " number2 " + number2
                        + " GCD " + computeGCD(number1, number2));
            }
        }

    }
}
