package com.fb.concentricrectarray;

import java.util.Arrays;

public class Solution {
    public static int[][] prettyPrint(int A) {
        int n = 2 * A - 1;
        int[][] result = new int[n][n];

        int[] row = new int[n];
        Arrays.fill(row, A);
        result[0] = row;
        result[n-1] = row;

        for(int i=1; i< n-1; i++){
            for(int j=0; j<n; j++){
                if(A-j > 0) {
                    result[i][j] = A - j;
                } else {
                    result[i][j] = A -(n-1-j);
                }
            }
        }
        for(int i =1; i<n-1; i++){
            for(int j=i; j<n-i; j++){
                if(i != j && i != n/2){
                    if(A-i > 0){
                        result[i][j] = A - i;
                    }
                }
            }
        }

        for(int i=A; i<n-1; i++){
            for(int j=1; j<n-1; j++){
                result[i][j] = result[n-1-i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] twod = prettyPrint(4);
        for(int i=0; i<twod.length; i++){
            Arrays.stream(twod[i]).forEach(System.out:: print);
            System.out.println("");
        }
    }


}
