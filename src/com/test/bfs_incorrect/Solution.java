package com.test.bfs_incorrect;



import java.util.*;

/**
 * Created by Raji on 4/4/2016.
 */

class Vertex{
    private int node;
    public Vertex(int node){
        this.node = node;
    }

    public int getNode() {
        return node;
    }
}

class Edge{
    private Vertex fromNode;
    private Vertex toNode;
    public Edge(int fromNode, int toNode){
        this.fromNode = new Vertex(fromNode);
        this.toNode = new Vertex(toNode);
    }

    public Vertex getToNode() {
        return toNode;
    }

    public Vertex getFromNode() {
        return fromNode;
    }
}
class Graph{
    private Vertex[] vertices;
    private Edge[] edges;

    public Graph(int nodes, int[][] edges){
        this.vertices = new Vertex[nodes];
        for (int i=0; i<nodes; i++){
            vertices[i] = new Vertex(i+1);
        }
        int edgeCount = edges.length * 2;
        this.edges = new Edge[edgeCount];
        for (int i=0; i<edges.length; i++){
            int j = i*2;
            //edges is a 2d array - with elements in each row
            this.edges[j] = new Edge(edges[i][0], edges[i][1]);
            this.edges[j+1] = new Edge(edges[i][1], edges[i][0]);
        }
    }

    public Vertex[] getVertices() {
        return vertices;
    }

    public Edge[] getEdges() {
        return edges;
    }

    /*
    Returns edges for given vertex
     */
    public Edge[] getEdges(Vertex v){

        List<Edge> e = new ArrayList<>();
        for (Edge edge : this.edges){
            if (edge.getFromNode().getNode() == v.getNode()){
                e.add(edge);
            }
        }
        Edge[] myEdges = new Edge[e.size()];
        return e.toArray(myEdges);
    }
}


public class Solution {

    public static final int DIST = 6;

    /*
    * Returns distance from the starting vertex for all other vertices in the graph
     */
    public static int[] bfs(Graph g, Vertex s){
        int[] distance = new int[g.getVertices().length];
        for (int i=0; i<distance.length; i++){
            distance[i] = -1;
        }
        boolean[] explored = new boolean[g.getVertices().length];
        explored[s.getNode() - 1] = true;
        Queue<Vertex> q = new LinkedList<>();
        q.add(s);
        int i = 0;
        while(q.peek() != null){
            Vertex v = q.poll();
            i++;
            for (Edge e: g.getEdges(v)){
                if (!explored[e.getToNode().getNode() -1]){
                    explored[e.getToNode().getNode() -1] = true;
                    distance[e.getToNode().getNode() -1] = i;
                    q.add(e.getToNode());
                }
            }
        }

        return distance;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int i=0; i<t; i++){
            int n = in.nextInt();
            int m = in.nextInt();
//            in.nextLine();
            int[][] edges = new int[m][2];
            for(int j=0; j<m; j++){
                for(int k=0; k<2; k++){
                    edges[j][k] = in.nextInt();
                }
                in.nextLine();
            }
            int startingNode = in.nextInt();

            Graph g = new Graph(n, edges);
            int [] dist = bfs(g, new Vertex(startingNode));
            //from dist array remove starting node
            List<Integer> distFiltered = new ArrayList<>();
            for (int k: dist){
                if (k == -1) {
                    distFiltered.add(k);
                } else {
                    distFiltered.add(k * DIST);
                }
            }
            //find the index of starting node and remove it
            distFiltered.remove(startingNode -1);
            for (int p: distFiltered) {
                System.out.print(p + " ");
            }
            System.out.println("");
        }



    }
}
