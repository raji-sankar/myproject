package com.leet.trappingrainwater;

public class Solution {
    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
     *
     *
     * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water
     * (blue section) are being trapped. Thanks Marcos for contributing this image!
     *
     * Example:
     *
     * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     * @param height
     * @return
     */

    public int trap(int[] height) {

        //1. we need min 3 points
        if (height.length < 3){
            return 0;
        }

        int ans = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        max_left[0] = height[0];
        for (int i=1; i<height.length; i++) {
            max_left[i] = Math.max(height[i], max_left[i-1]);
        }

        max_right[height.length -1] = height[height.length -1];
        for(int i=height.length-2; i>0; i--){
            max_right[i] = Math.max(height[i], max_right[i+1]);
        }
        for (int i=1; i<height.length; i++){
            ans += Math.min(max_left[i], max_right[i]) - height[i];

        }

        return ans;
    }

    public int bruteForce(int [] height){
        int ans = 0;


        for (int i=1; i<height.length; i++){
            int max_left = 0;
            int max_right = 0;
            for(int j = i; j >= 0; j--){
                max_left = Math.max(max_left, height[j]);
            }
            for(int j = i; j < height.length; j++){
                max_right = Math.max(max_right, height[j]);
            }

            ans += Math.min(max_left, max_right) - height[i];
        }

        return ans;
    }

    public int twoPointers(int[] height){
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int left_max = 0;
        int right_max = 0;
        while(left < right){
            if(height[left] < height[right]){
                if (height[left] >= left_max){
                    left_max = height[left];
                } else {
                    ans += left_max - height[left];
                }
                left++;
            } else {
                if(height[right] >= right_max){
                    right_max = height[right];
                } else {
                    ans +=  right_max - height[right];
                }
                right--;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(sol.bruteForce(height));
        System.out.println(sol.trap(height));
        System.out.println(sol.twoPointers(height));
    }
}
