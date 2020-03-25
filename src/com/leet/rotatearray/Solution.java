package com.leet.rotatearray;

/**
 *
 * Rotate Array
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 *
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */

public class Solution {

    public void rotate(int[] nums, int k) {


        int n = nums.length;
        int tmp = 0;
        int tmpIdx = 0;
        k = k%n;
        for(int i=0; i < n; i++ ){
            tmpIdx = (i + (n-k)) % n;
            tmp = nums[i];
            nums[i] = nums[(i + (n-k)) % n];
            nums[tmpIdx] = tmp;
        }

    }

    public void rotateUsingNewArray(int[] nums, int k) {

        //new array
        int n = nums.length;
        int[] answer = new int[n];
        k = k%n;
        for(int i=0; i < n; i++ ){
            answer[i] = nums[(i + (n-k)) % n];
        }
        for(int i=0; i < n; i++ ){
            nums[i] = answer[i];
        }
    }

    public  void rotateAndPrint(int[] nums, int k){

        rotate(nums, k);
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + ",");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {1,2,3,4,5,6,7};
        sol.rotateAndPrint(nums, 3);

        int[] a = {-1,-100,3,99};

        sol.rotateAndPrint(a, 2);

        int[] b = {1, 2};
        sol.rotateAndPrint(b, 3);
    }
}
