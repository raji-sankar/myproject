package com.binarygap;

class Solution {
    public int solution(int N) {
        if (N < 1 || N > Integer.MAX_VALUE){
            return 0;
        }
        // write your code in Java SE 8
        int maxGap = 0;
        String binary = Integer.toBinaryString(N);
        char[] chars = binary.toCharArray();
        int gap = 0;
        int begin = 0;
        int end = 0;
        System.out.println(binary + " begin:" + begin + ", end:" + end + ", gap:" + gap + ", maxGap:" + maxGap);
        for (int i=0; i<chars.length; i++){
            if (chars[i] == '1') {
                end = i;
                maxGap = Math.max(maxGap, end > begin? gap : 0);
                System.out.println(binary + " begin:" + begin + ", end:" + end + ", gap:" + gap + ", maxGap:" + maxGap);
                gap = 0;
                begin = i;
            } else {
                gap ++;
            }
        }
        return maxGap;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(32));
        System.out.println(sol.solution(1041));
    }
}