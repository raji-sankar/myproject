package com.interviewbit.colorfulnumber;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int colorful(int A) {
        if(A < 10){
            return 1;
        }

        String str = Integer.toString(A);
        Set<Integer> set = new HashSet<Integer>();
        int prod = 0;

        //Exploring all combinations
        for(int i = 0; i < str.length(); i++) {
            prod = 1;
            for(int j = i; j < str.length(); j++ ){
                prod *= str.charAt(j)-'0';
                //Check if Product value already present.
                if(set.contains(prod))
                    return 0;
                else set.add(prod);
            }
        }
        return 1;

    }





    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.colorful(234));
        System.out.println(sol.colorful(12));
        System.out.println(sol.colorful(2345));
    }
}
