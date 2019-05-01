package com.test.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Basic {

    public static void main(String[] args){
        Integer[] numbers = {13, 23, 12, 40,56, 2, 1 };
        Arrays.sort(numbers, new Comparator<Integer>(){
            @Override public int compare(Integer first, Integer second){
                return first.compareTo(second);
            }
        });
        System.out.println(Arrays.toString(numbers));

        Integer[] n2 = {13, 23, 12, 40,56, 2, 1 };
//        with lambdas
        Arrays.sort(n2, (first, second) -> first.compareTo(second));
        System.out.println(Arrays.toString(n2));

    }
}
