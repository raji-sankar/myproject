package com.leet.maxpathsum;

/**
 * Binary Tree Maximum Path Sum
 * Hard
 *
 * 1537
 *
 * 111
 *
 * Favorite
 *
 * Share
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 */

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
