package com.leet.binarytreeordertraversal;

import java.util.*;

/**
 * 107. Binary Tree Level Order Traversal II
 * Easy
 *
 * 1128
 *
 * 203
 *
 * Add to List
 *
 * Share
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * /**
 *  * Definition for a binary tree node.
 *  * public class TreeNode {
 *  *     int val;
 *  *     TreeNode left;
 *  *     TreeNode right;
 *  *     TreeNode(int x) { val = x; }
 *  * }
 *
 */

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root ==  null){
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();

        TreeNode current = root;
        queue.add(current);

        while(!queue.isEmpty()){
            int nodesInLevel = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i = 0; i< nodesInLevel; i++){
                current = queue.remove();
                if(current != null){
                    levelList.add(current.val);

                    if(current.left != null){
                        queue.add(current.left);
                    }

                    if(current.right != null){
                        queue.add(current.right);
                    }
                }
            }
            result.add(0, levelList);
        }

        return result;
    }


    /*
     * Given binary tree [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode leaf1 = new TreeNode(9);
        TreeNode middle = new TreeNode(20);
        TreeNode leaf2 = new TreeNode(15);
        TreeNode leaf3 = new TreeNode(7);

        middle.left = leaf2;
        middle.right =  leaf3;
        root.left = leaf1;
        root.right = middle;
        Solution sol = new Solution();
        List<List<Integer>> result = sol.levelOrderBottom(root);
        result.stream().forEach(System.out::println);
    }
}
