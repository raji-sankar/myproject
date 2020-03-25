package com.test.test;

interface StringMapper<T>{
    String map(T t);
}

class X {
    String s;
    public X (String s) { this.s = s;}
}

class Y <T>{
    T s;
    public Y (T s){ this.s = s;}
    @Override public String toString(){ return s.toString();}
}

public class H2 {

    static String name (Y y, StringMapper<Y> t){
        return t.map(y);
    }
    static String mapme(X x, StringMapper<X> t){
        return t.map(x);
    }

    public static void main(String[] args) {
//        System.out.println(mapme(new Y<>(new X("Hello")), e -> {return e.toString();}));
        System.out.println(mapme(new X("Hello"), e-> e.toString()));

    }
}
