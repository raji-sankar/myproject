package com.test.stringsimilarity;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * For two strings A and B, we define the similarity of the strings to be the length of the longest prefix common to both strings. For example, the similarity of strings "abc" and "abd" is 2, while the similarity of strings "aaa" and "aaab" is 3.
 *
 * Calculate the sum of similarities of a string S with each of it's suffixes.
 *
 * Input Format
 *
 * The first line contains the number of test cases t.
 * Each of the next t lines contains a string to process, .
 *
 * Constraints
 *
 *  is composed of characters in the range ascii[a-z]
 * Output Format
 *
 * Output t lines, each containing the answer for the corresponding test case.
 *
 * Sample Input
 *
 * 2
 * ababaa
 * aa
 * Sample Output
 *
 * 11
 * 3
 * Explanation
 *
 * For the first case, the suffixes of the string are "ababaa", "babaa", "abaa", "baa", "aa" and "a". The similarities of these strings with the string "ababaa" are 6,0,3,0,1, & 1 respectively. Thus, the answer is 6 + 0 + 3 + 0 + 1 + 1 = 11.
 *
 * For the second case, the answer is 2 + 1 = 3.
 */

public class Solution {

    public static final int ASCII_CHARS = 256;
    // Complete the stringSimilarity function below.

    static int stringSimilarity(String s) {
        //use rabin-karp algorithm and compute string hash
        int result = s.length();


        return result;
    }

    static void search(String text, String pattern, int q){
        int n = text.length();
        int m = pattern.length();
        int i =0;
        int j=0;
        int p=0;
        int t=0;
        int h=1;

        for(i =0; i < m; i++){
            h = (h * ASCII_CHARS) % q;
        }

        for (i=0; i < m; i++){
            p = (ASCII_CHARS * p + pattern.charAt(i)) % q;
            t = (ASCII_CHARS * t + text.charAt(i))%q;
        }

        for(i =0; i <= n -m; i++){
            if(p == t){
                for(j=0; j < m; j++){
                    if(text.charAt(i+j) != pattern.charAt(j)){
                        break;
                    }
                }
                if (j == m)
                    System.out.println("Pattern found at index " + i);
            }
            if (i < n-m){
                t = (ASCII_CHARS *(t -text.charAt(i)*h) + text.charAt(i+m)) % q;

                if (t < 0)
                    t = t+q;
            }
        }
    }

    static int stringSimilarity_naive(String s) {

        int result = s.length();
        if (s.length() > 1){
            for (int i=1; i < s.length(); i++){
                String sub = s.substring(i);
                for(int j=0; j<sub.length(); j++){
                    if(s.charAt(j) == sub.charAt(j)){
                        result++;
                    } else {
                        break;
                    }
                }
            }
        }


        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            int result = stringSimilarity(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
