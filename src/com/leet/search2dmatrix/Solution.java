package com.leet.search2dmatrix;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //search a 2D sorted matrix
        //merge all the elements into one array and do a binary search
        if(matrix.length ==0 || matrix[0].length == 0){
            return false;
        }
        int[] arr = new int[matrix.length *matrix[0].length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                arr[i*matrix[0].length + j] = matrix[i][j];
            }
        }
        return binarySearch(arr, target);

    }

    public boolean binarySearch(int[] array, int target){

        int floor = -1;
        int ceiling = array.length ;

        while(floor +1 < ceiling){
            int midPoint = (floor + ceiling)/2;
            if(array[midPoint] == target){
                return true;
            } else if(array[midPoint] > target){
                ceiling = midPoint;
            } else {
                floor = midPoint;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = new int[1][1];
        matrix[0][0] = 1;
        System.out.println(sol.searchMatrix(matrix, 1));

        matrix = new int [3][4];
        matrix[0] = new int[]{1,   3,  5,  7};
        matrix[1] = new int[]{10, 11, 16, 20};
        matrix[2] = new int[]{23, 30, 34, 50};

        System.out.println(sol.searchMatrix(matrix, 3));
    }
}
