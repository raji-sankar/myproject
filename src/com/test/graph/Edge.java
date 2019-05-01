package com.test.graph;

/**
 * Created by Raji on 5/30/2016.
 */
public class Edge {
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
