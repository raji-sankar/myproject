package com.test.thread;

import java.util.Random;

public class GCDRunnable extends Random implements Runnable {

    private final int MAX_ITERATIONS =  100000000;




    public int computeGCD(int number1, int number2){
        if (number2 == 0){
            return number1;
        }
        return computeGCD(number1, number1 % number2);
    }
    @Override
    public void run() {

        final String threadString = " with thread id " + Thread.currentThread();

        System.out.println("Entering run()" + threadString);

        try {
            for (int i = 0; i < MAX_ITERATIONS; i++) {

                if (i % 1000000 == 0) {
                    int number1 = nextInt();
                    int number2 = nextInt();

                    if (Thread.interrupted()){
                        throw new InterruptedException();
                    }

                    System.out.println("In run method " + threadString + " computeGCD number1 " + number1 + " number2 " + number2
                            + " GCD " + computeGCD(number1, number2));
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted " + threadString);
        } finally {
            System.out.println("Exiting run() " + threadString);
        }

    }
}
