package com.leet.numberofislands;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 200. Number of Islands
 * Medium
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class Solution {

    public int numIslands(char[][] grid) {

        int res = 0;

        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[0].length; ++j) {

                if(grid[i][j] == '1') {
                    res ++;
                    bfs(grid, i, j);
                }

            }
        }
        return res;
    }

    public void bfs(char[][] grid, int r, int c) {

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r,c});
        int[][] dir = { {0,1}, {1,0}, {0,-1}, {-1, 0}};

        while(!queue.isEmpty()) {

            int[] node = queue.poll();
            int i = node[0], j = node[1];

            if(isValidNode(grid, i, j)) {
                grid[i][j] = '2';

                for(int k = 0; k < dir.length; k++){
                    queue.add(new int[]{i+dir[k][0], j+dir[k][1]});
                }
            }
        }

    }

    public boolean isValidNode(char[][] grid, int r, int c) {
        int m = grid.length, n = grid[0].length;
        return (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1');
    }

    public static void main(String[] args) {
        Solution sol = new Solution();


        char[][] grid = {{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1', '1','0','0','0'},
                { '0','0','0','0','0'}};
        System.out.println(sol.numIslands(grid));
    }

}
