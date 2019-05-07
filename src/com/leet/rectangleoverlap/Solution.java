package com.leet.rectangleoverlap;

/**
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner,
 * and (x2, y2) are the coordinates of its top-right corner.
 *
 * Two rectangles overlap if the area of their intersection is positive.  To be clear, two rectangles that only touch
 * at the corner or edges do not overlap.
 *
 * Given two (axis-aligned) rectangles, return whether they overlap.
 *
 * Example 1:
 *
 * Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * Output: true
 * Example 2:
 *
 * Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * Output: false
 * Notes:
 *
 * Both rectangles rec1 and rec2 are lists of 4 integers.
 * All coordinates in rectangles will be between -10^9 and 10^9.
 */

public class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec1[2];
        int y2 = rec1[2];
        int x3 = rec2[0];
        int y3 = rec2[1];
        int x4 = rec2[2];
        int y4 = rec2[3];

        int x5 = Math.max(x1, x3);
        int y5 = Math.max(y1, y3);
        int x6 = Math.min(x2, x4);
        int y6 = Math.min(y2, y4);

        return (x5 < x6 && y5 < y6);

    }

    public static void main(String[] args) {
        int[] rec1 = {0,0,2,2};
        int[] rec2 = {1,1,3,3};

        Solution sol = new Solution();
        System.out.println(sol.isRectangleOverlap(rec1, rec2));

        int[] rec3 = {0,0,1,1};
        int[] rec4 = {1,0, 2, 1};
        System.out.println(sol.isRectangleOverlap(rec3, rec4));

        int[] rec5 = {2, 17, 6, 20};
        int[] rec6 = {3, 8, 6, 20};
        System.out.println(sol.isRectangleOverlap(rec5, rec6));
    }
}
