package com.ms;

public class B extends A {
    static {
        System.out.println("Static block in B");
    }

    public B(){
        System.out.println("In B constructor");
    }

    public static void main(String[] args) {
        B b1 = new B();
    }
}
