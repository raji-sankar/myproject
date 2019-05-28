package com.leet.sumroottoleaf;

/**
 * 129. Sum Root to Leaf Numbers
 * Medium
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 *
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
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

    public int sumNumbers(TreeNode root) {

        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode node, int sum){

        if(node == null){
            return sum;
        }

        sum = sum * 10 + node.val;

        if (node.left != null && node.right != null) {
            sum = sumNumbers(node.left, sum) + sumNumbers(node.right, sum);
        } else if (node.left == null && node.right != null){
            sum = sumNumbers(node.right, sum);
        } else if (node.left != null && node.right == null){
            sum = sumNumbers(node.left, sum);
        }
        return sum;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        Solution solution = new Solution();
        System.out.println(solution.sumNumbers(root));

    }

    /**
     * Success
     * Details
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum Root to Leaf Numbers.
     * Memory Usage: 33.8 MB, less than 100.00% of Java online submissions for Sum Root to Leaf Numbers.
     */

}
