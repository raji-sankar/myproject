package com.leet.invertbinarytree;

/**
 * 226. Invert Binary Tree
 * Easy
 *
 * 2789
 *
 * 43
 *
 * Add to List
 *
 * Share
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);

        root.left = right;
        root.right = left;
        return root;

    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        //[4,2,7,1,3,6,9]
        TreeNode root = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode seven = new TreeNode(7);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode nine = new TreeNode(9);

        root.left = two;
        root.right = seven;
        two.left = one;
        two.right = three;
        seven.left = six;
        seven.right = nine;

        TreeNode inverted = sol.invertTree(root);
        System.out.println(inverted.left.val);
        System.out.println(inverted.right.val);
        System.out.println(inverted.left.left.val);

    }
}