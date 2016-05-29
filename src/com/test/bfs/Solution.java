package com.test.bfs;

import java.io.File;
import java.io.FileNotFoundException;
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
    public Edge(Vertex fromNode, Vertex toNode){
        this.fromNode = fromNode;
        this.toNode = toNode;
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
        int edgeCount = edges.length *2;
        this.edges = new Edge[edgeCount];
        for (int i=0; i<edges.length; i++){
            //edges is a 2d array - with elements in each row
            int j = i*2;
            this.edges[j] = new Edge(this.vertices[edges[i][0] - 1],
                    this.vertices[edges[i][1] - 1]);
            this.edges[j+1] = new Edge(this.vertices[edges[i][1] - 1],
                    this.vertices[edges[i][0] - 1]);
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

        List<Edge> edg = new ArrayList<>();
        for (Edge edge : this.edges){
            if (edge.getFromNode().getNode() == v.getNode()){
                edg.add(edge);
            }
        }
        Edge[] myEdges = new Edge[edg.size()];
        for (int i=0; i<edg.size(); i++){
            myEdges[i] = edg.get(i);
        }
        return myEdges;
    }
}


public class Solution {

    public static final int DIST = 6;

    /*
    * Returns distance from the starting vertex for all other vertices in the graph
     */
    public static int[] bfs(Graph g, Vertex s){
        int[] path = new int[g.getVertices().length];
        for (int i=0; i<path.length; i++){
            path[i] = -1;
        }
        boolean[] explored = new boolean[g.getVertices().length];
        Vertex[] parent = new Vertex[g.getVertices().length];
        explored[s.getNode() - 1] = true;
        Queue<Vertex> q = new LinkedList<>();
        q.add(s);


        while(q.peek() != null){
            Vertex v = q.poll();

            for (Edge e: g.getEdges(v)){
                if (!explored[e.getToNode().getNode() -1]){
                    explored[e.getToNode().getNode() -1] = true;
                    if(parent[e.getToNode().getNode() -1] == null){
                        parent[e.getToNode().getNode() -1] = v;
                    }

                    q.add(e.getToNode());
                }
            }
        }
        for (int j=0; j<g.getVertices().length; j++){
            path[j] = find_path(s, g.getVertices()[j],parent );
        }

        return path;
    }

    public static int find_path(Vertex start, Vertex end, Vertex[] parents){
        if ((start == end)){
            return 0;
        } else if (parents[end.getNode() -1] == null){
            return -1;
        } else {
            return find_path(start, parents[end.getNode() -1], parents) + 1;
        }
    }



    public static void main(String[] args) throws FileNotFoundException {
        Scanner in;
        if (args!=null && args.length>0 && args[0].equals("-d")){
            in = new Scanner(new File(args[1]));
        } else {
            in = new Scanner(System.in);
        }
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
            int [] dist = bfs(g, g.getVertices()[startingNode -1]);
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
