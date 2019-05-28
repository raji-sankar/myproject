package com.uber.longestenvelopesequence;

// QUESTION:
//
// Given an array of envelopes, find the longest sequence
// such that you are able to fit a envelope inside another
// for all envelopes in that sequence.
//
// The envelopes can be rotated 90 degrees in order to fit inside another envelope.
// An envelope fits inside another if both side lengths are strictly less.
//
// Ex.
// Input =  { {2,2}, {10,10}, {1,2}, {10,8}, {9,9}, {20,20}, {3,8}, {6,1}, {7, 2}, {1,1}, {3,4}, {20,20} }
// Return: { {10,10}, {9,9}, {3,8}, {7,2}, {1,1} }

// 10,10 -> 1,2
// 10,10 -> 9,9
//              9,9  -> 3,8
//                          3,8 -> 6,1
//                          3,8 -> 7,2
//                                      7,2 -> 1,1
//                          3,8 -> 1,1
//              9,9  -> 6,1
//              9,9  -> 7,2
//                          7,2 -> 1,1
//              9,9  -> 1,1
//              9,9  -> 3,4
// 10,10 -> 3,8
// 10,10 -> 6,1
// 10,10 -> 7,2
// 10,10 -> 1,1
// 10,10 -> 3,4
//
// Input =  { {2,2}, {3,3}, {4,5}, {6,8}, {9,9}, {20,100} }
// Return: { any one element }

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    static List<Node> answer = new ArrayList<>();

    static class Node{
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {

            return Objects.hash(x, y);
        }
    }

    static class Edge{
        Node node1;
        Node node2;
        Edge(Node node1, Node node2){
            this.node1 = node1;
            this.node2 = node2;
        }
    }

    static class Graph{
        List<Node> orderedNodes = new ArrayList<>();
        Set<Node> nodes = new HashSet<>();
        List<Edge> edges = new ArrayList<>();
        Graph(int[][] input){
            for (int i=0; i < input.length; i++){
                Node node1 = new Node(input[i][0], input[i][1]);
                orderedNodes.add(node1);
                for(int j=i+1; j<input.length; j++){
                    if (canFit(input[i], input[j])){

                        Node node2 = new Node(input[j][0], input[j][1]);
                        nodes.add(node1);
                        nodes.add(node2);
                        edges.add(new Edge(node1, node2 ));
                    }
                }
            }
        }

        List<Edge> getEdges(Node node){
            List<Edge> edg = new ArrayList<>();
            for(Edge edge: edges){
                if (edge.node1.equals(node)){
                    edg.add(edge);
                }
            }
            return edg;
        }



    }

    public static boolean canFit(int[] a, int[] b){
        return Math.max(b[0], b[1]) < Math.max(a[0], a[1]) && Math.min(b[0], b[1]) < Math.min(a[0], a[1]);
    }

    public static void dfs(Graph graph, Node node, List<Node> path){
        if(node == null){
            return;
        }
        path.add(node);
        if (graph.getEdges(node).size() == 0){
            //this is a leaf node
            isASolution(path);
        }

        for(Edge edge: graph.getEdges(node)){
            dfs(graph, edge.node2, path);
        }
        path.remove(path.size() -1);
    }

    private static void isASolution(List<Node> path) {
        if(path.size() > answer.size()){

            //deep copy
            answer = new ArrayList<>();
            answer.addAll(path);
        }
    }


    public static int[][] biggestEnvelopeSequence(int[][] input){


        Graph graph = new Graph(input);
        for (Node node: graph.orderedNodes)
            dfs(graph, node, new ArrayList<>());
        List<Node> ans = answer;
        List<int[]> outputList = new ArrayList<>();
        for (int i=0; i<ans.size(); i++){
            Node node = ans.get(i);
            int[] nodexy = {node.x, node.y};
            outputList.add(nodexy);
        }



        return input;
    }



    public static void main(String args[] ) throws Exception {
        // { {2,2}, {10,10}, {1,2}, {10,8}, {9,9}, {20,20}, {3,8}, {6,1}, {7, 2}, {1,1}, {3,4}, {20,20} };
        int[][] input = { {2,2}, {10,10}, {1,2}, {10,8}, {9,9}, {20,20}, {3,8}, {6,1}, {7, 2}, {1,1}, {3,4}, {20,20} };

        System.out.println((canFit(new int[]{10,10}, new int[]{9,5})));
        int[][] output = biggestEnvelopeSequence(input);
        for(int i=0; i<output.length; i++) {
            System.out.println("{" + input[i][0] + ", " + input[i][1] + "}");
        }



    }
}
