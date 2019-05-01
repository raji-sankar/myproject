package com.test.lambda;



@FunctionalInterface
interface Calculation{
    Integer apply (Integer x, Integer y);
 }


public class Example {

    static Integer calculate(Calculation operation, Integer x, Integer y){
        return  operation.apply(x, y);
    }


    public static void main(String[] args){
        Calculation addition = (x, y) -> x + y;
        Calculation subtraction = (x, y) -> x - y;

        Integer a = calculate(addition, 2,2);
        Integer b = calculate(subtraction, 5, calculate(addition, 3, 4));

        System.out.println(a);
        System.out.println(b);
    }
}
