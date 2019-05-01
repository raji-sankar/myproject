package com.leet.tree;

import java.util.*;

public class Solution {

    public List<Integer> preorderTraversalRecursive(TreeNode root){
        List<Integer> preorder = new ArrayList<>();

            preorderRecursive(root, preorder);

        return preorder;
    }

    private void preorderRecursive(TreeNode current, List<Integer> preorder) {

        preorder.add(current.val);

        if (current.left == null && current.right == null) {
            return;
        }
        if (current.left != null){
            preorderRecursive(current.left, preorder);
        }
        if (current.right != null){
            preorderRecursive(current.right, preorder);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        Map<TreeNode,Boolean> seen = new HashMap<>();

        TreeNode current = root;

        Stack<TreeNode> stack = new Stack<>();

        while(current != null){
            boolean alreadySeen = seen.getOrDefault(current, false);

            if (!alreadySeen){
                preorder.add(current.val);
                stack.push(current);
                seen.put(current, true);
            }

            if (current.left != null && !seen.getOrDefault(current.left, false)){

                current = current.left;

            } else if (current.right != null && !seen.getOrDefault(current.right, false)){

                current = current.right;
            } else {
                stack.pop();
                if (!stack.empty())
                    current = stack.peek();
                else
                    break;
            }
        }

        return preorder;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();

        inorderRecursive(root, inorder);

        return inorder;
    }

    private void inorderRecursive(TreeNode current, List<Integer> inorder) {


        if (current.left == null && current.right == null) {
            inorder.add(current.val);
            return;
        }
        if (current.left != null){
            inorderRecursive(current.left, inorder);
        }
        inorder.add(current.val);
        if (current.right != null){
            inorderRecursive(current.right, inorder);
        }

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();

        if (root != null)
            postorderRecursive(root, postorder);

        return postorder;
    }

    private void postorderRecursive(TreeNode current, List<Integer> postorder) {

        if (current.left == null && current.right == null) {
            postorder.add(current.val);
            return;
        }
        if (current.left != null){
            postorderRecursive(current.left, postorder);
        }

        if (current.right != null){
            postorderRecursive(current.right, postorder);
        }
        postorder.add(current.val);

    }

    public List<Integer> bfs(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        Map<TreeNode,Boolean> seen = new HashMap<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(queue.peek() != null){
            TreeNode current = queue.remove();
            boolean alreadySeen = seen.getOrDefault(current, false);

            if (!alreadySeen){
                order.add(current.val);
                seen.put(current, true);
                if (current.left != null)
                    queue.add( current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
        }

        return order;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        List<List<Integer>> levels = new ArrayList<>();
        Map<Integer, List<Integer>> nodeLevel = new HashMap<>();
        Map<TreeNode, Integer> nodes = new HashMap<>();
        int level = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) {
            queue.add(root);
            order.add(root.val);


            nodes.put(root, 0);
            nodeLevel.put(level, order);
        }

        while(queue.peek() != null){
            TreeNode current = queue.remove();
            level = nodes.get(current);
            order = nodeLevel.putIfAbsent(level + 1, new ArrayList<>());
            if (order == null){
                order = new ArrayList<>();
                nodeLevel.put(level + 1, order);
            }
            if (current.left != null) {
                queue.add(current.left);
                nodes.put(current.left, level + 1);
                order.add(current.left.val);

            }
            if (current.right != null) {
                queue.add(current.right);
                order.add(current.right.val);
                nodes.put(current.right, level + 1);
            }

        }

        for(int key: nodeLevel.keySet()){
            if(nodeLevel.get(key).size() > 0) {
                levels.add(nodeLevel.get(key));
            }
        }

        return levels;
    }

    public int maxDepth(TreeNode root) {
        int answer = 0;
        int depth = 1;
        max_depth(root, depth, answer);

        answer = Math.max(answer, depth);
        return answer;
    }

    private void max_depth(TreeNode node, int depth, int answer){
        if (node == null)
            return ;
        answer = Math.max(answer, depth);
        max_depth(node.left, depth + 1, answer);
        max_depth(node.right, depth + 1, answer);

    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(0);
        TreeNode B = new TreeNode(1);
        TreeNode C = new TreeNode(2);
        TreeNode D = new TreeNode(3);
        TreeNode E = new TreeNode(4);
        TreeNode F = new TreeNode(5);
        TreeNode G = new TreeNode(6);
        TreeNode I = new TreeNode(7);
        TreeNode H = new TreeNode(8);

        F.left = B;
        B.left = A;
        B.right = D;
        D.left = C;
        D.right = E;
        F.right = G;
        G.right = I;
        I.left = H;

        Solution sol = new Solution();
        System.out.println(sol.maxDepth(F));
        System.out.println(sol.preorderTraversal(F));
        System.out.println(sol.preorderTraversalRecursive(F));
        System.out.println(sol.inorderTraversal(F));
        System.out.println(sol.postorderTraversal(F));
        System.out.println(sol.bfs(F));
        System.out.println(sol.levelOrder(F));
    }
}
