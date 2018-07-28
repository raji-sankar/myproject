package com.challenge;

/**
 * Reverse an integer without using String or char methods
 */

public class ReverseInteger {

    public static int reverseInteger(int input){
        int output = 0;
        int copy = input;

        int[] arr = new int[10];

        int k = 10;

        int x = 0;
        for (int i=0; i < arr.length; i++){
            arr[i] = input % k;
            input = input/10;


            if (input == 0) break;
            x++;
        }

        k = 1;
        for (int i = x; i >= 0; i--){
            output += arr[i] * k;
            k *= 10;
        }

        System.out.println(copy + " -> " + output);
        return output;
    }

    public static void main(String[] args) {


        reverseInteger(123);

        reverseInteger(12332111);

        reverseInteger(124321456);
    }
}
