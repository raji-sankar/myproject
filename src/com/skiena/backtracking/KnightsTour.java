package com.skiena.backtracking;

public class KnightsTour {

    static final int N = 8;

    static boolean isValid(int x, int y, int sol[][]){
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    static void printSolution(int[][] sol){
        for(int i=0; i< N; i++){
            for(int j=0; j<N; j++){
                System.out.print(sol[i][j]);
            }
            System.out.println();
        }
    }

    static boolean solve(){
        int[][] sol = new int[N][N];

        for (int x=0; x<N; x++){
            for(int y=0; y <N; y++){
                sol[x][y] = -1;
            }
        }

        int[] xMove = { 1, 1, -1, -1, 2, 2, -2, -2};
        int[] yMove = { 2, -2, 2, -2, 1, -1, 1, -1};

        sol[0][0] = 0;

        if (!solveUtil(0, 0, 1, sol, xMove, yMove)){
            System.out.println("Solution does not exist");
            return false;
        }
        printSolution(sol);
        return true;
    }

    private static boolean solveUtil(int x, int y, int move, int[][] sol, int[] xMove, int[] yMove) {

        int k = 0;
        int nextX = 0;
        int nextY = 0;
//        System.out.println("k =" + k + ", x = " + x + ", y = " + y);

        if(move == N*N)
            return true;

        for(k =0; k < N; k++){
            nextX = x + xMove[k];
            nextY = y + yMove[k];
            if(isValid(nextX, nextY, sol)){
                sol[nextX][nextY] = move;
                if (solveUtil(nextX, nextY, move+1, sol, xMove, yMove))
                    return true;
                else
                    sol[nextX][nextY] = -1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        solve();
    }
}
