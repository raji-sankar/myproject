package com.test.javachallenge.stringreverse;

import java.util.Scanner;

/**
 * Created by Raji on 4/2/2016.
 */
public class Palindrome {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        //Split the word into two halves
        int len = word.length();
        String left;
        String right;

        int halfway = len%2 == 0 ? len/2 : (len +1)/2;
        left = word.substring(0, halfway) ;
        right = word.substring(halfway, len);
        boolean isPalindrome = true;

        int loopTerm = (left.length() == right.length()) ? left.length() : left.length() - 1;

        for (int i=0; i < loopTerm; i++){
            if (left.charAt(i) != right.charAt(right.length() - i - 1)) {
                isPalindrome = false;
                break;
            }
        }


        System.out.println(isPalindrome ? "Yes" : "No");

    }
}
