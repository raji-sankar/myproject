package com.interviewbit.arrayspiral;

public class Solution {

    public static void printArray(int[][] input){
        for(int i=0; i<input.length; i++){
            for(int j=0; j<input[i].length; j++){
                System.out.print(input[i][j] + " ");
            }
        }

    }

    public static void printSpiral(int[][] input){
        int top = 0;
        int bottom = input.length -1;
        int left = 0;
        int right = input[0].length - 1;

        int dir = 0;
        while(top <= bottom && left <= right){
            if(dir == 0){
                for(int i=left; i<=right; i++){
                    System.out.print(input[top][i] + ", ");
                }
                top++;
            }  else if(dir == 1){
                for(int i=top; i<=bottom; i++){
                    System.out.print(input[i][right] + ", ");
                }
                right--;
            } else if(dir == 2){
                for(int i=right; i>=left; i--){
                    System.out.print(input[bottom][i] + ",");
                }
                bottom--;
            } else if(dir == 3){
                for(int i=bottom; i>= top; i--){
                    System.out.print(input[i][left] + ", ");
                }
                left++;
            }
            dir++;
            dir = dir % 4;
        }

    }

    public static int[] spiralOrder(final int[][] A) {

        int[] result = new int[A.length * A[0].length];

        int top = 0;
        int bottom = A.length -1;
        int left = 0;
        int right = A[0].length - 1;
        int j = 0;

        int dir = 0;
        while(top <= bottom && left <= right){
            if(dir == 0){
                for(int i=left; i<=right; i++){
                    result[j] = A[top][i];
                    j++;

                }
                top++;
            }  else if(dir == 1){
                for(int i=top; i<=bottom; i++){
                    result[j] = A[i][right];
                    j++;
                }
                right--;
            } else if(dir == 2){
                for(int i=right; i>=left; i--){
                    result[j] = A[bottom][i];
                    j++;
                }
                bottom--;
            } else if(dir == 3){
                for(int i=bottom; i>= top; i--){
                    result[j] = A[i][left];
                    j++;
                }
                left++;
            }
            dir++;
            dir = dir % 4;

        }

        return result;
    }

    public static void main(String[] args) {
        int[][] input = new int[4][4];
        int count = 1;
        for(int i=0; i<input.length; i++){
            for(int j=0; j<input[i].length; j++){
                input[i][j] = count++;
            }
        }
        printArray(input);
        System.out.println(" ");
        printSpiral(input);

        int[][] d1 = {{1}};
        System.out.println(d1[0][0]);
        int[] r1 = spiralOrder(d1);
        for(int x: r1){
            System.out.println(x);
        }

        int[][] A = {{1,2},
                    {3, 4},
                    {5, 6}};

        int[] res = spiralOrder(A);
        for(int x : res){
            System.out.print(x +", ");
        }
    }
}
