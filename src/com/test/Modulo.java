package com.test;

public class Modulo {

    public static void main(String[] args) {
        long m = 1000000007;
        long a = 1457856355953635695L;
        long b = 3151635135413512165L;
        long c = 99987445522222220L;

        long i = 1;
        i = (i*a) % m;
        i = (i*b) % m;
        i = ((i*c)%m + m) % m ;
        System.out.println(i);
    }
}
