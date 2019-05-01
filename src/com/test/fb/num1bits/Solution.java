package com.test.fb.num1bits;


public class Solution {
    public int numSetBits(long a) {
        String binary = Long.toBinaryString(a);
        char[] chars = binary.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numSetBits(11));
    }
}
