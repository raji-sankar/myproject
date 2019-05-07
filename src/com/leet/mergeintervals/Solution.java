package com.leet.mergeintervals;

import java.util.*;

/**
 * 56. Merge Intervals
 * Medium
 * <p>
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> output = new ArrayList<>();

        if(intervals.length > 0) {
            //Question is the input array sorted by x?
            //assume the input is not sorted
            Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < intervals.length; i++) {


                if (intervals[i][0] >= min && intervals[i][0] <= max) {
                    min = Math.min(min, intervals[i][0]);
                    max = Math.max(max, intervals[i][1]);
                } else {
                    if (max != Integer.MIN_VALUE && min != Integer.MAX_VALUE) {
                        List<Integer> out = new ArrayList<>();
                        out.add(min);
                        out.add(max);
                        output.add(out);
                    }

                    min = intervals[i][0];
                    max = intervals[i][1];
                }


            }
            List<Integer> out = new ArrayList<>();
            out.add(min);
            out.add(max);
            output.add(out);
        }
        int[][] intArray = output.stream().map(u -> u.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);

        return intArray;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] one = {4, 5};
        int[] two = {1, 4};
        int[][] intevals = new int[][]{one, two};

        int[][] output = sol.merge(intevals);
        for (int i = 0; i < output.length; i++) {
            System.out.println(Arrays.toString(output[i]));
        }

        /*
         * Input: [[1,3],[2,6],[8,10],[15,18]]
         * Output: [[1,6],[8,10],[15,18]]
         */
        one = new int[]{1, 3};
        two = new int[]{2, 6};
        int[] three = {8, 10};
        int[] four = {15, 18};
        int[][] intervals = new int[][]{one, two, three, four};
        int[][] output1 = sol.merge(intervals);
        for (int i = 0; i < output1.length; i++) {
            System.out.println(Arrays.toString(output1[i]));
        }

        one = new int[]{2, 5};
        two = new int[]{2, 3};
        int[][] intervals2 = new int[][]{one, two};
        int[][] output2 = sol.merge(intervals2);
        for (int i = 0; i < output2.length; i++) {
            System.out.println(Arrays.toString(output2[i]));
        }
    }

}
