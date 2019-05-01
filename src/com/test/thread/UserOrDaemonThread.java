package com.test.thread;

import java.util.Random;

/**
 * @class UserOrDaemonThread
 *
 * @brief This is the brief javadoc
 */

public class UserOrDaemonThread extends Thread{

    final private String threadType;

    private final int MAX_ITERATIONS =  100000000;

    public UserOrDaemonThread(Boolean daemonThread) {
        if (daemonThread){
            setDaemon(true);
            this.threadType = "daemon";
        } else {
            threadType = "user";
        }
    }

    private int computeGCD(int number1, int number2){

        if (number2 == 0){
            return number1;
        }
        return computeGCD(number2, number1%number2);
    }

    @Override
    public void run() {
        final String threadString = " with " + threadType + "thread id " + Thread.currentThread();

        System.out.println("Entering run() " + threadString);
        Random random = new Random();

        try {
            for (int i=0; i < MAX_ITERATIONS; i++){
                int number1 = random.nextInt();
                int number2 = random.nextInt();

                if (i % 10000000 == 0){
                    System.out.println("In run()" + threadString + " the GCD of" + number1 + " and " + number2 + " is " + computeGCD(number1, number2));
                }
            }
        } finally {
            System.out.println("Leaving run() " + threadString);
        }
    }
}
