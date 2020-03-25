package com.test.test;

import java.util.Optional;

public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        String a = null;
        Optional<String> b = Optional.empty();
        try {
            System.out.print(a.length());
            System.out.print(b.orElse("").length());
        }catch(Exception ex){
            System.out.print(a);
        }finally {
            a = "String";
            System.out.print(a.length());
            b = Optional.ofNullable("");
            System.out.print(b.get().length());
        }
    }
}
