package com.leet.pathsum;

/**
 * 112. Path Sum
 * Easy
 *
 * 922
 *
 * 296
 *
 * Favorite
 *
 * Share
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
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
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null){
            return false;
        } else {
            boolean answer = false;

            int subsum = sum - root.val;
            if(subsum == 0 && root.left == null && root.right == null){
                return true;
            }
            if(root.left != null){
                answer = answer || hasPathSum(root.left, subsum);
            }
            if(root.right != null){
                answer = answer || hasPathSum(root.right, subsum);
            }
            return answer;
        }


    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode eight = new TreeNode(8);
        TreeNode eleven = new TreeNode(11);
        TreeNode thirteen = new TreeNode(13);
        TreeNode a4 = new TreeNode(4);
        TreeNode seven = new TreeNode(7);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);

        root.left = four;
        root.right = eight;
        four.left = eleven;
        eight.left = thirteen;
        eight.right = a4;
        eleven.left = seven;
        eleven.right = two;
        a4.right = one;

        Solution solution = new Solution();
        System.out.println(solution.hasPathSum(root, 22));


    }

}
