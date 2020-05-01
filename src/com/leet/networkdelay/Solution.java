package com.leet.networkdelay;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * There are N network nodes, labelled 1 to N.
 *
 * Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.
 *
 * Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 * Output: 2
 *
 *
 * Note:
 *
 * N will be in the range [1, 100].
 * K will be in the range [1, N].
 * The length of times will be in the range [1, 6000].
 * All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.
 */

public class Solution {
    class Node{
        int val;
        public Node(int val){
            this.val = val;
        }
    }

    class Edge{
        Node source;
        Node target;
        int time;
        public Edge(Node source, Node target, int time){
            this.source = source;
            this.target = target;
            this.time = time;
        }
    }

    class Graph{
        Set<Node> nodes;
        List<Edge> edges;
        Graph(){
            nodes = new HashSet<>();
            edges = new ArrayList<>();
        }

        Node getRootNode(){

            return null;
        }

        int calculateDelay(){
            int delay = 0;


            return delay;
        }
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        int networkDelay = 0;
        Graph g = new Graph();
        for (int i=0; i < times.length ; i++){
            Node source = new Node(times[i][0]);
            Node target = new Node(times[i][1]);
            Edge edge = new Edge(source, target, times[i][2]);
            g.edges.add(edge);
            g.nodes.add(source);
            g.nodes.add(target);
        }

        return networkDelay;
    }
}
