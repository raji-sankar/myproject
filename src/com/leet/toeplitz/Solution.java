package com.leet.toeplitz;

/**
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 *
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 *
 *
 * Example 1:
 *
 * Input:
 * matrix = [
 *   [1,2,3,4],
 *   [5,1,2,3],
 *   [9,5,1,2]
 * ]
 * Output: True
 * Explanation:
 * In the above grid, the diagonals are:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
 * In each diagonal all elements are the same, so the answer is True.
 * Example 2:
 *
 * Input:
 * matrix = [
 *   [1,2],
 *   [2,2]
 * ]
 * Output: False
 * Explanation:
 * The diagonal "[1, 2]" has different elements.
 *
 * Note:
 *
 * matrix will be a 2D array of integers.
 * matrix will have a number of rows and columns in range [1, 20].
 * matrix[i][j] will be integers in range [0, 99].
 */
public class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        //create diagonal array
        int i, j = 0;

        for (i=0; i < matrix[0].length; i++){
            if (!checkDiagonal(matrix, 0, i))
                return false;
        }
        for (j=1; j<matrix.length; j++){
            if (!checkDiagonal(matrix, j, 0))
                return false;
        }

        return true;
    }

    private boolean checkDiagonal(int[][] matrix, int i, int j){
        int diag = matrix[i][j];
        while(++i < matrix.length && ++j < matrix[0].length)
            if (matrix[i][j] != diag)
                return false;
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] row1 = {1,2,3,4};
        int[] row2 = {5,1,2,3};
        int[] row3 = {9,5,1,2};
        int[][] matrix = new int[][] {row1, row2, row3};
        System.out.println(sol.isToeplitzMatrix(matrix));

        int[] row01 = {1,2};
        int[] row02 = {2,2};
        int[][] matrix01 = new int[][] {row01, row02};
        System.out.println(sol.isToeplitzMatrix(matrix01));
    }


}
