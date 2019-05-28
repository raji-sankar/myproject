package com.leet.maxpathsum;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}

public class Solution {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;

    }

    private int helper(TreeNode node){
        if (node == null){
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);
        int maxChild = Math.max(node.val, Math.max(node.val+left, node.val+right));
        max = Math.max(max, Math.max(node.val + left +right, maxChild));
        return maxChild;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        Solution solution = new Solution();
        System.out.println(solution.maxPathSum(root));
    }
}
