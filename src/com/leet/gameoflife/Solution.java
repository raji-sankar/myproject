package com.leet.gameoflife;

import java.util.Arrays;

public class Solution {
    public void gameOfLife(int[][] board) {

        if(board.length == 0){
            return ;
        }

        int[][] next = new int[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                int D1T = i>0 && j>0 ? board[i-1][j-1] : 0;
                int T = i>0 ? board[i-1][j] : 0;
                int D2T = i>0 && j<board[i].length -1 ? board[i-1][j+1] : 0;
                int L = j>0 ? board[i][j-1] : 0;
                int R = j <board[i].length-1 ? board[i][j+1] :0;
                int D2B = i <board.length-1 && j>0? board[i+1][j-1] : 0;
                int B = i <board.length -1 ? board[i+1][j] : 0;
                int D1B = i <board.length -1 && j<board[i].length -1 ? board[i+1][j+1] : 0;

                int sum = D1T + T + D2T + L + R + D2B + B + D1B;
                //rule s
                if(board[i][j] == 1 && sum < 2){
                    next[i][j] = 0;
                }
                if(board[i][j] == 1 && (sum == 2 || sum == 3) ){
                    next[i][j] = 1;
                }
                if(board[i][j] == 1 && sum > 3){
                    next[i][j] = 0;
                }
                if(board[i][j] == 0 && sum == 3){
                    next[i][j] = 1;
                }
            }
            System.out.println(Arrays.toString(next[i]));
        }

    }

    public static void main(String[] args) {
        int[][] board = new int[4][3];
        board[0] = new int[]{0,1,0};
        board[1] = new int[]{0,0,1};
        board[2] = new int[]{1,1,1};
        board[3] = new int[]{0,0,0};
        Solution sol = new Solution();
        sol.gameOfLife(board);
    }
}
