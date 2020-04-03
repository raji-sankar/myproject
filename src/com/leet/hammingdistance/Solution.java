package com.leet.hammingdistance;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Note:
 * 0 ≤ x, y < 231.
 *
 * Example:
 *
 * Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * The above arrows point to positions where the corresponding bits are different.
 */

public class Solution {

    public int hammingDistance(int x, int y) {
        int dist = 0;
        String binX = Integer.toBinaryString(x);
        String binY = Integer.toBinaryString(y);


        int min = Math.min(binX.length(), binY.length());
        int max = Math.max(binX.length(), binY.length());
        if(max - min != 0) {
            char[] pad = new char[max - min];
            for (int i = 0; i < pad.length; i++) {
                pad[i] = '0';
            }
            if(binX.length() < binY.length()){
                binX = new String(pad) + binX;
            } else {
                binY = new String(pad) + binY;
            }
        }


        for(int i=0; i < max; i++){
            if (binX.charAt(i) != binY.charAt(i)){
                dist++;
            }
        }


        return dist;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.hammingDistance(1,4));
        System.out.println(sol.hammingDistance(1,256));
    }
}
