package com.test.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Solution {

    static class Helper {
        private int data = 5;
        public void bump(int inc){
            inc++;
            data = data + inc;
        }
    }

    public static void main(String[] args) {
//        Helper h = new Helper();
//        int data = 2;
//        h.bump(data);
//        System.out.println(h.data + " " + data);data

//        List<String> list = Arrays.asList("dog", "over", "good");
//        System.out.println(list.stream().reduce(new String(), (x1, x2) -> {if (x1.equals("dog")) return x1; return x2;}));
//        list.stream().reduce((x1, x2) -> x1.length() == 3 ? x1 : x2).ifPresent(System.out::println);

//        int c = 0;
//        System.out.println( (0 == c++) ? "true" : "false");
//        Double d = null;
//        System.out.println((d instanceof Double) ? "true": "false");
//        boolean b = false;
//        System.out.println((b = true)  ? "true" : "false");
//        int a = 0;
//        System.out.println((a != 0) ? "true" : "false");
//        String e = "1";
//        System.out.println(("1" != e) ? "true" : "false");

//        String str1 = "My String";
//        String str2 = new String("My String");
//        System.out.println(str1 == str2);
//        System.out.println(str1.matches(str2));
//        System.out.println(str1.hashCode() == str2.hashCode());
//        System.out.println(str1.equals(str2));

//        Supplier<String> i = () -> "Car";
//        Consumer<String> c = x -> System.out.print(x.toLowerCase());
//        Consumer<String> d = x -> System.out.print(x.toUpperCase());
//        c.andThen(d).accept(i.get());
//        System.out.println();

//        int j =0;
//        int a[] = {2, 4};
//        do for (int i : a)
//            System.out.print(i + " ");
//        while (j++ < 1);

//        meth(args);

//        int x = -1;
//        System.out.println( x = x >>>1);
//        x = -1;
//        System.out.println( x = x >>1);
//        x = -1;
//        System.out.println( x = x >>>0);
//        x = -1;
//        System.out.println( x = x >>32);
//        x = -1;
//        System.out.println( x = x >>>32);

        Predicate<String> lengther = (s) -> s.length() < 2;
        Predicate<String> equalizer = Predicate.isEqual("car");
        Function<Boolean, String> booleaner = i -> Boolean.toString(i);
        Function<String, Boolean> stringer = s -> Boolean.parseBoolean(s);
        System.out.println(booleaner.apply(true));
        System.out.println(stringer.compose(booleaner).apply(true));
        System.out.println(booleaner.compose(stringer).apply("true").substring(0, 3));
//        System.out.println(booleaner.andThen(stringer).apply("true"));
    }


}
