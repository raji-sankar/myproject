package com.leet.maximumbinarytree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if(start == end){
            return new TreeNode(nums[start]);
        } else if (start > end){
            return null;
        }

        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                maxIndex = i;
                max = nums[i];
            }
        }

        TreeNode left = helper(nums, start, maxIndex - 1);
        TreeNode right = helper(nums, maxIndex + 1, end);
        TreeNode root = new TreeNode(max, left, right);

        return root;
    }

    public static void main(String[] args) {
        int nums[] = {3, 2, 1, 6, 0, 5};
        Solution sol = new Solution();
        TreeNode node = sol.constructMaximumBinaryTree(nums);
        System.out.println(node);

    }

}

