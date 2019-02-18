package com.leet.palindromenumber;

public class Solution {
    /**
     * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
     *
     * Example 1:
     *
     * Input: 121
     * Output: true
     * Example 2:
     *
     * Input: -121
     * Output: false
     * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
     * Example 3:
     *
     * Input: 10
     * Output: false
     * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
     */

    public boolean isPalindrome_str(int x) {
        String str = Integer.toString(x);
        if (x < 0) return false;
        int midPoint = str.length()/2;
        int i, j;
        if (str.length() % 2 == 0){
            i = midPoint - 1;
            j = midPoint;
        } else {
            i = midPoint;
            j = midPoint;
        }

        while (i >= 0 && j < str.length()){
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
            i--;
            j++;
        }
        return true;

    }

    public boolean isPalindrome(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0 )){
            return false;
        }

        int reversedNumber = 0;
        while(x > reversedNumber){
            reversedNumber = (x % 10)  + reversedNumber * 10;
            x /= 10;
        }

        return x == reversedNumber || x == reversedNumber/10;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome(1221));
        System.out.println(sol.isPalindrome(121));
        System.out.println(sol.isPalindrome(-121));
        System.out.println(sol.isPalindrome(10));
    }
}
