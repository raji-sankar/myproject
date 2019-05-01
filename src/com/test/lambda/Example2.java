package com.test.lambda;


public class Example2 {
    @FunctionalInterface
    interface Conversion{
        String convert(Integer number);
    }


    public static String convert(Integer number, Conversion function){
        return function.convert(number);
    }

    public static void main(String[] args) {
        System.out.println(convert(100, (x) ->String.valueOf(x)));
        System.out.println(convert(200, String::valueOf));

        Conversion a = (x) -> String.valueOf(x);
        Conversion b = String::valueOf;
    }
}
