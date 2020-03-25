package com.knapsack;

public class Solution {

    public int solution(int[] values, int[] weights, int capacity){
        return knapsack(values, weights, capacity, 0);
    }

    private int knapsack(int[] values, int[] weights, int capacity, int currentIndex){
        if (currentIndex >= values.length || capacity <= 0){
            return 0;
        }

        int withCurrent = 0;
        if (weights[currentIndex] <= capacity)
            withCurrent = values[currentIndex] + knapsack(values, weights, capacity-weights[currentIndex], currentIndex+1);

        int withoutCurrent = 0;
        withoutCurrent = knapsack(values, weights, capacity, currentIndex+1);

        return Math.max(withCurrent, withoutCurrent);

    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] values = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int capacity = 7;
        System.out.println(sol.solution(values, weights, capacity));
    }
}
