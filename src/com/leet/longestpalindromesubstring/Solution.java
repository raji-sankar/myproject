package com.leet.longestpalindromesubstring;

import com.leet.addtwonumbers.Sol;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/***
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 * Hint 1: How can we reuse a previously computed palindrome to compute a larger palindrome?
 * Hint 2: If “aba” is a palindrome, is “xabax” and palindrome? Similarly is “xabay” a palindrome?
 * Hint 3: Complexity based hint:
 * If we use brute-force and check whether for every start and end position a substring is a palindrome
 * we have O(n^2) start - end pairs and O(n) palindromic checks.
 * Can we reduce the time for palindromic checks to O(1) by reusing some previous computation.
 */


public class Solution {

    private Map<String,String> palindromes = new HashMap<>();

    public String longestPalindrome(String s) {
        int length = s.length();
        int left = length % 2 == 0 ? (length/2) - 1 : length/2;
        int right = length/2;
        int palLength = 0;

        while(left >= 0 && right < length){
            if (s.charAt(left) == s.charAt(right)){
                palLength++;
                if (left != right) palLength++;
                left--;
                right++;
            } else {
                break;
            }
        }

        return s.substring(left >= 0 ? (left + 1 == right) ? left : left + 1 : 0, right);
    }


    public String longestPalindrome_sol(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    String palindrome(String s, int pivot){

        if (palindromes.keySet().contains(s)){
            return palindromes.get(s);
        }

        int length = s.length();
        int left = 0;
        int right = 0;
        if (pivot == 0) {
            left = length % 2 == 0 ? (length / 2) - 1 : length / 2;
            right = length / 2;
        } else {
            left = pivot;
            right = pivot + 1;
        }

        int palLength = 0;

        while(left >= 0 && right < length){
            if (s.charAt(left) == s.charAt(right)){
                palLength++;
                if (left != right) palLength++;
                left--;
                right++;
            } else {
                break;
            }
        }
        int startIndex = left >= 0 ? (left + 1 == right) ? left : left + 1 : 0;

        String pal = s.substring(startIndex, right);
        palindromes.put(s, pal);
        return pal;
    }

    int palindromeLength(String s){
        int minpalLength = 1;
        int length = s.length();
        int left = length % 2 == 0 ? (length/2) - 1 : length/2;
        int right = length/2;
        int palLength = 0;

        while(left >= 0 && right < length){
            if (s.charAt(left) == s.charAt(right)){
                palLength++;
                if (left != right) palLength++;
                left--;
                right++;
            } else {
                break;
            }
        }

        return palLength > minpalLength ? palLength : minpalLength;
    }

    boolean isPalindrome(String string){
        char[] chars = string.toCharArray();
        char[] revchar = new char[string.length()];

        for (int i = chars.length - 1; i >= 0; i--){
            revchar[chars.length-1 -i ] = chars[i];
        }
        String reversed = new String(revchar);
        System.out.println(string);
        System.out.println(reversed);
        return string.equals(reversed);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "ableasaelba";
        System.out.println(sol.palindromeLength(s));
        System.out.println(sol.palindrome(s, 0));
        System.out.println(sol.longestPalindrome(s));

        String s2 = "defabbaabc";
        System.out.println(sol.palindromeLength(s2));
        System.out.println(sol.palindrome(s2, 0));
        System.out.println(sol.longestPalindrome(s2));

        String s3 = "ac";
        System.out.println(sol.palindromeLength(s3));
        System.out.println(sol.palindrome(s3, 0));
        System.out.println(sol.longestPalindrome(s3));

        String s4 = "abb";
        System.out.println(sol.palindromeLength(s4));
        System.out.println(sol.palindrome(s4, 0));
        System.out.println(sol.longestPalindrome(s4));
    }
}
