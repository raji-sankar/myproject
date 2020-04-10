package com.interviewbit.pascaltriangle;

public class Solution {

    public int[][] solve(int A) {
        int[][] output = new int[A+1][];
        for(int i=1; i< A+1; i++){
            output[i] = new int[i];
            for(int j=0; j<i; j++){

                pascal(i, j, output);
            }
        }

        return output;
    }

    private void pascal(int i, int j, int[][] arr){
        if(j == 0 || i-1 == j){
            arr[i][j] = 1;
        } else {
            arr[i][j] = arr[i-1][j-1] +  arr[i-1][j] ;
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int [][] pas = sol.solve(10);

        for(int i=1; i< pas.length; i++){
            for(int j=0; j<pas[i].length; j++){
                System.out.print(pas[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
