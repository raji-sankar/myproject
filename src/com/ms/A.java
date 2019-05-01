package com.ms;

public class A {

    static {
        System.out.println("Static block in A");
    }

    public A() {
        System.out.println("In A constructor");
    }
}
