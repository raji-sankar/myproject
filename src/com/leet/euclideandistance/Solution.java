package com.leet.euclideandistance;

import java.util.*;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 *
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 *
 *
 * Note:
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */
public class Solution {
    public int[][] kClosest(int[][] points, int K) {
        List<List<Integer>> output = new ArrayList<>();
        Map<Long,ArrayList<Integer>> squareMap = new HashMap<>();


        long[] square = new long[points.length];
        for(int i=0; i<points.length; i++){
            square[i] = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]) ;
            List<Integer> val = squareMap.computeIfAbsent(square[i], k -> new ArrayList<Integer>());
            val.add(i);

        }
        Arrays.sort(square);

        int count = 0;

        for(int i=0; i<K; i++){
            List<Integer> indices = squareMap.get(square[i]);
            if (indices != null  & indices.size() > 0){
                for (int j=0; j<indices.size(); j++){
                    count++;
                    List<Integer> out = new ArrayList<>();
                    out.add(points[indices.get(j)][0]);
                    out.add(points[indices.get(j)][1]);
                    output.add(out);

                }
            }
            if (count == K) break;
        }


        int[][] intArray = output.stream().map(u -> u.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);

        return intArray;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] one = {0, 1};
        int[] two = {1, 0};
        int[][] points = new int[][]{one, two};
        int[][] output = sol.kClosest(points, 2);
        for(int i=0; i<output.length; i++){
            System.out.println(Arrays.toString(output[i]));
        }

    }
}
