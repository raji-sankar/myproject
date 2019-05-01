package com.test.thread.runnable;

import java.util.Random;

public class UserOrDaemonRunnable  extends Random implements Runnable {

    private final String threadType;

    private final int MAX_ITERATIONS =  100000000;

    public UserOrDaemonRunnable(boolean daemon) {
        if (daemon) {
            this.threadType = "daemon";
        } else {
            this.threadType = "user";
        }
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
