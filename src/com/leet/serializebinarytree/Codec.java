package com.leet.serializebinarytree;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        //use BFS to serialize
        if(root != null){
            boolean isRoot = true;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty()){
                TreeNode node = q.remove();
                // System.out.println(node != null ? node.val : "null");
                if(isRoot){
                    sb.append(node.val);
                    isRoot = false;
                }else {
                    sb.append(",");
                    String v = (node != null) ? Integer.toString(node.val) : "null";
                    sb.append(v);
                }
                if(node != null){
                    q.add(node.left);
                    q.add(node.right);
                }

            }

        }

        sb.append("]");
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = null;
        if(data == null || data.length() <= 2){
            return root;
        }

        data = data.replace("[", "");
        data = data.replace("]", "");
        String[] parts = data.split(",");
        if(parts.length > 0){
            root = new TreeNode(Integer.parseInt(parts[0]));
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            int idx = 0;

            while(!q.isEmpty()){
                TreeNode node = q.remove();
                idx++;
                if(parts[idx].equals("null")){
                    node.left = null;
                }else {
                    TreeNode newNode = new TreeNode(Integer.parseInt(parts[idx]));
                    node.left = newNode;
                    q.add(node.left);
                }
                idx++;
                if(parts[idx].equals("null")){
                    node.right = null;
                }else {
                    TreeNode newNode = new TreeNode(Integer.parseInt(parts[idx]));
                    node.right = newNode;
                    q.add(node.right);
                }
            }


        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        root.left = two;
        root.right = three;
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        three.left = four;
        three.right = five;

        Codec codec = new Codec();
        String ser = codec.serialize(root);
        System.out.println(ser);
        codec.deserialize(ser);
    }
}
