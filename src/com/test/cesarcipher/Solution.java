package com.test.cesarcipher;

import java.util.Scanner;

/**
 * Created by Raji on 5/10/2016.
 */
public class Solution {

    public static String encrypt(String input, int k){
        k = k % 26;
        char[] outputArray = new char[input.length()];
        char[] inputArray = input.toCharArray();
        for (int i=0; i < input.length(); i++) {
            char c = inputArray[i];
            int j = (int)c;
            if ((j > 96 && j < 123) ||(j > 64 && j < 91)){
                int n = j + k;
                if ((j > 64 && j < 91) && (n > 90) ){
                    n -= 26;
                }
                if ((j > 96 && j < 123) && (n > 122)){
                    n -= 26;
                }
                outputArray[i] = (char)n;

            } else {
                outputArray[i] = inputArray[i];
            }

        }
        return new String(outputArray);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int k = in.nextInt();

        System.out.println(Solution.encrypt(s, k));
    }
}
