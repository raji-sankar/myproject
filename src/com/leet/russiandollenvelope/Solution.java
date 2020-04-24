package com.leet.russiandollenvelope;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 354. Russian Doll Envelopes
 * Hard
 *
 * 934
 *
 * 35
 *
 * Add to List
 *
 * Share
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 *
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 *
 * Note:
 * Rotation is not allowed.
 *
 * Example:
 *
 * Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //sort the envelopes
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (Integer.valueOf(o1[0]) != (Integer.valueOf(o2[0]))){
                    return Integer.valueOf(o1[0]).compareTo(Integer.valueOf(o2[0]));
                } else {
                    return Integer.valueOf(o1[1]).compareTo(Integer.valueOf(o2[1]));
                }
            }

        });

        int n = envelopes.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (envelopes[j][0] > envelopes[i][0] && envelopes[j][1] > envelopes[i][1]) {
                    dp[j] = Math.max(dp[j], 1 + dp[i]);
                }
            }
        }

        int max = 0;

        for (int i=0; i<dp.length; i++){
            max = Math.max(max, dp[i]);
        }

        return max;
    }



    public static void main(String[] args) {
        Solution sol = new Solution();
//        Input: [[5,4],[6,4],[6,7],[2,3]]
        int[][] env = new int[4][2];
        env[0] = new int[]{5,4};
        env[1] = new int[]{6,4};
        env[2] = new int[]{6,7};
        env[3] = new int[]{2,3};

        System.out.println(sol.maxEnvelopes(env));
//        [[4,5],[4,6],[6,7],[2,3],[1,1]]
//        int[][] env2 = new int[5][2];
//        env2[0] = new int[]{4,5};

        int env2[][] = {{4,5},{4,6},{6,7},{2,3},{1,1}};
        System.out.println(sol.maxEnvelopes(env2));

        int env3[][] = {{1,1},{1,1},{1,1}};
        System.out.println(sol.maxEnvelopes(env3));

        int env4[][] = {{46,89},{50,53},{52,68},{72,45},{77,81}};
        System.out.println(sol.maxEnvelopes(env4));

    }
}