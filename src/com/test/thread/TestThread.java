package com.test.thread;

public class TestThread {

    public static void main(String[] args) {
        System.out.println("Entering main()");

        final Boolean daemonThread = args.length > 0;

        UserOrDaemonThread th = new UserOrDaemonThread(daemonThread);
        UserOrDaemonThread another = new UserOrDaemonThread(false);
        th.start();
        another.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){

        }
        System.out.println("Exiting main()");
    }
}
