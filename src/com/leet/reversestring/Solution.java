package com.leet.reversestring;

public class Solution {

    private static void printReverse(char[] str) {
        helper(0, str);
    }

    private static void helper(int i, char[] str) {
        if (str == null || i >= str.length) {
            return;
        }
        helper(i + 1, str);
        System.out.print(str[i]);
    }

    private void reverseHelper(int i, char[] s){
        if (s == null || i >= (s.length/2) || s.length == 0)
            return;
        char c = s[i];
        int n = s.length;
        s[i] = s[n-1-i];
        s[n-1-i] = c;

        reverseHelper(i+1, s);
    }

    public void reverseStringOld(char[] s) {
        /*
         * Write a function that reverses a string. The input string is given as an array of characters char[].
         * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
         * You may assume all the characters consist of printable ascii characters.
         * Input: ["h","e","l","l","o"]
         * Output: ["o","l","l","e","h"]
         * Input: ["H","a","n","n","a","h"]
         * Output: ["h","a","n","n","a","H"]
         */
        int n = s.length;
        reverseHelper(0, s);

        String str = String.copyValueOf(s);



        System.out.print("[");

        for (int i = 0; i < n; i++) {
            System.out.print("\"" + s[i] + "\"");
            if(i < n-1) {
                System.out.print(",");
            }
        }
        System.out.print("]");

    }

    public void reverseString(char[] s) {

        int i = 0;
        int j = s.length-1;

        while(i<j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }

        int n = s.length;
        System.out.print("[");
        for (int k = 0; k < n; k++) {
            System.out.print("\"" + s[k] + "\"");
            if(k < n-1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        String mystr = "abcdef";
        char[] str = mystr.toCharArray();
//        printReverse(str);
//        System.out.println("");
        Solution sol = new Solution();
//        sol.reverseString(str);
        mystr = "Hannah";
        str = mystr.toCharArray();
//        sol.reverseString(str);
        mystr = "Hello";
        char[] s2 = mystr.toCharArray();
//        sol.reverseString(s2);
        char[] s3 = {'A',' ','m','a','n',',',' ','a',' ','p','l','a','n',',',' ','a',' ','c','a','n','a','l',':',' ','P','a','n','a','m','a'};
        sol.reverseString(s3);

    }
}
