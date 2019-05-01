package com.test.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raji on 5/30/2016.
 */
public class Graph {
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
