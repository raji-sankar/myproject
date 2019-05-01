package com.test.thread.runnable;

public class TestThread {

    public static void main(String[] args) {
        boolean demon = false;

        if(args.length > 0){
            demon = true;
        }

        Thread mythread = new Thread(new UserOrDaemonRunnable(demon));
        mythread.setDaemon(demon);

        mythread.start();


    }
}
