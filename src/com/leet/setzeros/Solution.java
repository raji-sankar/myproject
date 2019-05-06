package com.leet.setzeros;

import java.util.*;

/**
 * 73. Set Matrix Zeroes
 * Medium
 *
 * 992
 *
 * 189
 *
 * Favorite
 *
 * Share
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * Example 2:
 *
 * Input:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * Output:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * Follow up:
 *
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */

public class Solution {

    public void setZeroes(int[][] matrix) {
        Set<Map.Entry<Integer, Integer>> zeros = new HashSet<>();

        for (int i=0; i < matrix.length; i++){

            for (int j=0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    zeros.add(Pair.of(i, j));
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry: zeros){
            int i = entry.getKey();
            int j = entry.getValue();
            for(int k=0; k < matrix[i].length; k++){
                matrix[i][k] = 0;
            }
            for(int k=0; k < matrix.length; k++){
                matrix[k][j] = 0;
            }
        }

    }

    static class Pair {
        public static <T,U> Map.Entry<T,U> of (T first, U second){
            return new AbstractMap.SimpleEntry<>(first, second);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a = {1,1,1};
        int[] b = {1,0,1};
        int[] c = {1,1,1};
        int[][] arr = new int[3][3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        for (int i=0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        sol.setZeroes(arr);
        for (int i=0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

        int[] x = {0,1,2,0};
        int[] y = {3,4,5,2};
        int[] z = {1,3,1,5};
        int[][] arr2 = new int[3][4];
        arr2[0] = x;
        arr2[1] = y;
        arr2[2] = z;
        for (int i=0; i < arr2.length; i++) {
            System.out.println(Arrays.toString(arr2[i]));
        }
        sol.setZeroes(arr2);
        for (int i=0; i < arr2.length; i++) {
            System.out.println(Arrays.toString(arr2[i]));
        }

    }

}
