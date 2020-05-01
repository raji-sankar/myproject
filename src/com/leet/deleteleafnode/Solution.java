package com.leet.deleteleafnode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree root and an integer target, delete all the leaf nodes with value target.
 *
 * Note that once you delete a leaf node with value target, if it's parent node becomes a leaf node and has the value target, it should also be deleted (you need to continue doing that until you can't).
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,2,3,2,null,2,4], target = 2
 * Output: [1,null,3,null,4]
 * Explanation: Leaf nodes in green with value (target = 2) are removed (Picture in left).
 * After removing, new nodes become leaf nodes with value (target = 2) (Picture in center).
 * Example 2:
 *
 *
 *
 * Input: root = [1,3,3,3,2], target = 3
 * Output: [1,3,null,null,2]
 * Example 3:
 *
 *
 *
 * Input: root = [1,2,null,2,null,2], target = 2
 * Output: [1]
 * Explanation: Leaf nodes in green with value (target = 2) are removed at each step.
 * Example 4:
 *
 * Input: root = [1,1,1], target = 1
 * Output: []
 * Example 5:
 *
 * Input: root = [1,2,3], target = 1
 * Output: [1,2,3]
 *
 *
 * Constraints:
 *
 * 1 <= target <= 1000
 * Each tree has at most 3000 nodes.
 * Each node's value is between [1, 1000].
 */
public class Solution {


    public TreeNode removeLeafNodes(TreeNode root, int target) {

        return delete(root, target) ? null : root;

    }

    private boolean delete(TreeNode node, int target){
        if(node == null){
            return true;
        }

        if(node.val == target && node.left == null && node.right == null){
            return true;
        }

        boolean deleteLeft = delete(node.left, target);
        boolean deleteRight = delete(node.right, target);

        if(deleteLeft){
            node.left = null;
        }
        if(deleteRight){
            node.right = null;
        }

        return deleteLeft && deleteRight && node.val == target;

    }



    public static TreeNode arrayToBinaryTree(Integer[] input){
        if(input.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(input[0]);
        TreeNode[] tree = new TreeNode[input.length];
        tree[0] = root;

        for(int i=1; i<input.length; i+=2){
            TreeNode parent = tree[i/2];
            if(input[i] != null){
                tree[i] = new TreeNode(input[i]);
                parent.left = tree[i];
            }
            if(input[i+1] != null) {
                tree[i+1] = new TreeNode(input[i + 1]);
                parent.right = tree[i+1];
            }
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        root.left = left1;
        root.right = right1;
        TreeNode left21 = new TreeNode(2);
        left1.left = left21;
        TreeNode left22 = new TreeNode(2);
        TreeNode right22 = new TreeNode(4);
        right1.left = left22;
        right1.right = right22;

        Solution sol = new Solution();
//        TreeNode res = sol.removeLeafNodes(root, 2);
//        System.out.println(res.val);

        TreeNode root1 = arrayToBinaryTree(new Integer[]{1, 2, 3, 2, null, 2, 4});
        TreeNode res = sol.removeLeafNodes(root1, 2);
        System.out.println(res.val);
    }
}
