package com.fb.editdistance;

import java.util.Scanner;

public class Solution {

    public static int editDistance(String s1, String s2){
        int d = 0;
        if (s1 == null || s2 == null) {
            return d;
        }

        if(s1.equals(s2)) return d;
        d = compareStrings(s1, s2, d);
        return d;

    }

    private static int compareStrings(String s1, String s2, int d) {
        if(s1.length() == s2.length()){

            for(int i=0; i< s1.length(); i++){
                if (s1.charAt(i) != s2.charAt(i)){
                    d++;
                }
            }

        } else {
            //one string is bigger than the other
            //remove the not matching character and try matching
            //use recursion
            String bigger = s1.length() > s2.length() ? s1 : s2;
            String smaller = bigger == s1 ? s2 : s1;

            d += bigger.length() - smaller.length();
            for (int i = 0; i < smaller.length(); i++) {
                if (bigger.charAt(i) != smaller.charAt(i)) {
                    return compareStrings(smaller, bigger.substring(0, i) + bigger.substring(i + 1, bigger.length()), d);
                }
            }


        }
        return d;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0; i < t; i++){
            String a = in.next();
            String b = in.next();

            System.out.println(editDistance(a, b));
        }
    }
}
