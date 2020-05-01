package com.leet.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */

public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();


        inOrderRecursive(root, inorder);

        return inorder;
    }

    public void inOrderRecursive(TreeNode node, List<Integer> inorder) {
        if(node != null){
            inorder.add(node.val);
            inOrderRecursive(node.left, inorder);
            inOrderRecursive(node.right, inorder);
        }

    }

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
        (sol.inorderTraversal(root)).stream().forEach(System.out::println);

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        one.right = two;
        two.left = three;
        (sol.inorderTraversal(one)).stream().forEach(System.out::println);

    }
}
