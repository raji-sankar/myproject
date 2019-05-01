package com.challenge;

/**
 * Reverse an integer without using String or char methods
 */

public class ReverseInteger {

    public static int reverseInteger(int input){
        long output = 0;
        int copy = input;
        long z = (long) input;

        int[] arr = new int[20];

        int k = 10;

        int x = 0;
        for (int i=0; i < arr.length; i++){
            arr[i] = (int) (z % k);
            z = z/10;


            if (z == 0) break;
            x++;
        }

        k = 1;
        for (int i = x; i >= 0; i--){
            output += arr[i] * (long)k;
            k *= 10;
        }

        if(output > Integer.MAX_VALUE || output < Integer.MIN_VALUE )
            output = 0;

        System.out.println(copy + " -> " + output);
        return (int)output;
    }

    public static void main(String[] args) {

        reverseInteger(1534236469);
        reverseInteger(120);
        reverseInteger(-120);
        reverseInteger(-123);

        reverseInteger(-1234);

        reverseInteger(12332111);

        reverseInteger(124321456);


    }
}
