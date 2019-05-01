package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Raji on 3/29/2016.
 */
public class Solution {
    private int n;


    public long factorial(int n){
        if (n == 1){
            return 1;
        } else {
            return n * factorial(n-1);
        }

    }



    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named AllSubsetSolution. */
        String input = null;
        int n = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            input = bufferedReader.readLine();
            n = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            System.out.println("Not a number !");
        } catch (IOException e) {
            e.printStackTrace();
        }


        Solution mysol = new Solution();
        System.out.println(mysol.factorial(n));


    }
}
