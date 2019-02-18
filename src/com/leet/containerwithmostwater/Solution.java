package com.leet.containerwithmostwater;

public class Solution {

    /**
     * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
     *
     * Note: You may not slant the container and n is at least 2.
     *
     * Brute force - o(n squared)
     * for every point calculate area with every other point
     *
     *          1   8   6   2   5   4   8   3   7
     *      1       1   2   3   4   5   6   7   8
     *      8           6   4   15  16  40  24  49
     *      6               2   10  12  24  15  36
     *      2                   2   4   6   8   10
     *      5                       4   10  9   20
     *      4                           4   6   12
     *      8                               3   14
     *      3                                   3
     *      7
     *
     * Two pointer approach
     * 1. the height is the shorter of the two
     * 2. Max distance between them the larger the area
     */
    public int maxArea_bruteforce(int[] height) {

        int max = 0;

        for (int i = 0; i < height.length; i++){
            for(int j = i + 1; j < height.length; j++){
                int area = Math.min(height[i], height[j]) * (j -i);
                max = Math.max(max, area);
            }
        }
        return max;

    }

    public int maxArea(int[] height){
        int max = 0;
        int i = 0;
        int j = height.length - 1;

        while(i < height.length && j > i){
            int area = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(max, area);
            if (height[i] > height[j]){
                j--;
            } else {
                i++;
            }
        }


        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] input = {1,8,6,2,5,4,8,3,7};
        System.out.println(sol.maxArea(input));

    }
}
