package com.test.thread;

/**
 * Created by Raji on 5/24/2016.
 */
public class Example {
    Runnable r = new Runnable() {
        @Override
        public void run() {
            System.out.println("Hello from runnable");
        }
    };

    public static void main(String[] args){
        Example e = new Example();
        e.r.run();
        MyThread t = new MyThread();
        t.start();
        System.out.println(t.getState());
        Thread t1 = new Thread(e.r, "thread t1");
        System.out.println(t1.getName()); // Output: thread t1
        System.out.println(t1.getState());
        Thread t2 = new Thread(e.r);
        t2.setName("thread t2");
        System.out.println(t2.getName());

    }


}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from thread");
    }
}
