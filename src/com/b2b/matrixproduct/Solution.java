package com.b2b.matrixproduct;

public class Solution {

    public static int matrixProduct(int[][] matrix){


        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int product = matrix[0][0];
        int i = 0;
        int j = 0;

        while(i <= matrix.length-1 && j <= matrix[0].length-1){
            boolean iReached = i == matrix.length -1;
            boolean jReached = j == matrix[0].length -1;

            if(iReached && jReached){
                break;
            }

            if(!jReached && (iReached || product * matrix[i][j+1] >= product * matrix[i+1][j])){
                product *= matrix[i][j+1];
                j++;
            } else {
                product *= matrix[i+1][j];
                i++;
            }
        }

        return product;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{1, 2, 3};
        matrix[1] = new int[]{4, 5, 6};
        matrix[2] = new int[]{7, 8, 9};

        System.out.println(matrixProduct(matrix));

        matrix[0][0] = -1;
        matrix[1][2] = -6;
        System.out.println(matrixProduct(matrix));
    }
}
