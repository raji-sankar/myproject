package com.leet.smalleststring;



/**
 * 88. Smallest String Starting From Leaf
 * Medium
 *
 * Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.
 *
 * Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
 *
 * (As a reminder, any shorter prefix of a string is lexicographically smaller: for example, "ab" is lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: [0,1,2,3,4,3,4]
 * Output: "dba"
 * Example 2:
 *
 *
 *
 * Input: [25,1,3,1,3,0,2]
 * Output: "adz"
 * Example 3:
 *
 *
 *
 * Input: [2,2,1,null,1,0,null,0]
 * Output: "abc"
 *
 *
 * Note:
 *
 * The number of nodes in the given tree will be between 1 and 8500.
 * Each node in the tree will have a value between 0 and 25.
 * Accepted
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

    String answer = "~";

    public String smallestFromLeaf(TreeNode root) {

        //brute force
        dfs(root, new StringBuilder());

        return answer;
    }

    public void dfs(TreeNode node, StringBuilder sb){

        if (node == null){
            return;
        }

        sb.append((char)('a' + node.val));
        if (node.left == null && node.right == null) {
            sb.reverse();
            String candidate = sb.toString();
            sb.reverse();
            isASolution(candidate);
        }
        dfs(node.left, sb);
        dfs(node.right, sb);
        sb.deleteCharAt(sb.length() - 1);

    }

    private void isASolution(String candidate) {
        if (candidate.compareTo(answer) < 0){
            answer = candidate;
        }
    }


    public static void main(String[] args) {
        // * Input: [0,1,2,3,4,3,4]
        // * Output: "dba"
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        Solution solution = new Solution();
        System.out.println(solution.smallestFromLeaf(root));

    }
}
