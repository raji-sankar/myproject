package com.test.thread;

class ThreadWithState extends Thread{

    ConditionLoop conditionLoop;
    boolean wait;

    public ThreadWithState(ConditionLoop conditionLoop, boolean wait) {
        this.conditionLoop = conditionLoop;
        this.wait = wait;
    }

    @Override
    public void run() {
        System.out.println("Before sleep, " + Thread.currentThread().toString() + " run, wait  "  + wait );
        if (wait) {
            try {
                conditionLoop.waitForCondition();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            conditionLoop.satisfyCondition();
            System.out.println("After sleep, " + Thread.currentThread().toString() + " run, wait  " + wait);
        }
    }


    public void printState(){
        System.out.println(super.getName() + " " +  super.getState());
    }

}

public class ConditionLoop {

    private boolean condition;

    synchronized void waitForCondition() throws InterruptedException {
        while (!condition) {
            System.out.println(Thread.currentThread().getName() + " in wait " + Thread.currentThread().getState());
            wait();

        }
    }

    synchronized void satisfyCondition() {
        System.out.println(Thread.currentThread().getName() + " in notify " + Thread.currentThread().getState() + " condition " + condition);
        condition = true;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " in notify " + Thread.currentThread().getState() + " condition " + condition);
    }

    synchronized void take(){
        try {
            waitForCondition();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        satisfyCondition();
    }



    public static void main(String[] args) throws InterruptedException {

//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Before sleep, " + Thread.currentThread() + " run, condition  " + cl.condition);
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("After sleep, " + Thread.currentThread() + " run, condition  " + cl.condition) ;
//            }
//
//            public void printState(){
//                System.out.println(Thread.currentThread().getName() + " " +  Thread.currentThread().getState());
//            }
//        });
//
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Before sleep, " + Thread.currentThread() + " run, condition  " + cl.condition) ;
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("After sleep, " + Thread.currentThread() + " run, condition  " + cl.condition) ;
//            }
//        });

        ConditionLoop conditionLoop = new ConditionLoop();

        ThreadWithState t1 = new ThreadWithState(conditionLoop, true);
        t1.printState();


        ThreadWithState t2 = new ThreadWithState(conditionLoop, false);
        t2.printState();

        System.out.println(Thread.currentThread().getName() + " state " + Thread.currentThread().getState() + " holds lock " + Thread.currentThread().holdsLock(conditionLoop));
        System.out.println(t1.getName() + " state " + t1.getState() + " holds lock " + Thread.currentThread().holdsLock(conditionLoop));
        System.out.println(t2.getName() + " state " + t2.getState() + " holds lock " + Thread.currentThread().holdsLock(conditionLoop));

        t1.start();
        t1.printState();
        t2.start();
        t2.printState();

        System.out.println(Thread.currentThread().getName() + " state " + Thread.currentThread().getState() + " holds lock " + Thread.currentThread().holdsLock(conditionLoop));
        System.out.println(t1.getName() + " state " + t1.getState() + " holds lock " + Thread.currentThread().holdsLock(conditionLoop));
        System.out.println(t2.getName() + " state " + t2.getState() + " holds lock " + Thread.currentThread().holdsLock(conditionLoop));
        t1.printState();
        t2.printState();

        System.out.println(Thread.currentThread().getName() + " state " + Thread.currentThread().getState());


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw e;
        }

        System.out.println(Thread.currentThread().getName() + " state " + Thread.currentThread().getState());

        t1.printState();
        t2.printState();


        t1.printState();
        t2.printState();

        System.out.println("exiting main");
    }
}
