package com.test.thread.concurrent;

public class InheritableThreadLocalDemo {
    public static void main(String[] args) {
        ParentThread pt = new ParentThread();
        pt.start();
    }

}

class ParentThread extends Thread{

    static ThreadLocal<String> value = new ThreadLocal<>();
    static InheritableThreadLocal<String> childValue = new InheritableThreadLocal<>();
    static InheritableThreadLocal childValue2 = new InheritableThreadLocal(){
        @Override
        protected String childValue(Object parentValue){
            return parentValue + ":child";
        }
    };

    @Override
    public void run() {
        value.set("Parent thread");
        childValue.set("Parent");
        childValue2.set("Abc");
        System.out.println("Parent thread value: " + value.get());

        ChildThread childThread = new ChildThread();
        childThread.start();
    }
}

class ChildThread extends Thread{
    public void run(){
        System.out.println("Child value: " + ParentThread.value.get());
        System.out.println("Child value1: " + ParentThread.childValue.get());
        System.out.println("Child value2: " + ParentThread.childValue2.get());
    }
}
