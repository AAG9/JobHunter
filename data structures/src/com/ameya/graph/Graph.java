package com.ameya.graph;

import java.util.*;

/**
 * Created by chiko on 1/16/2017.
 */
public class Graph {
    int vertices;
    List<Integer> vertexList[];
    List<Edge> edges;
    boolean[] visited;

    public Graph(int vertices){
        this.vertices = vertices;
        visited = new boolean[vertices];
        this.vertexList = new ArrayList[this.vertices];
        this.edges = new ArrayList<Edge>();
        for (int i = 0; i < vertices; i++)
            vertexList[i] = new ArrayList<>();
    }

    public Graph(int[] vertexArr){
        this.vertices = vertexArr.length;
        visited = new boolean[vertices];
        this.vertexList = new ArrayList[vertices];
        this.edges = new ArrayList<>();
        for (int i=0;i<vertices;i++)
            vertexList[vertexArr[i]] = new ArrayList<>();
    }


    public void addEdge(int src, int dest){
        Edge edge = new Edge(src,dest, 1);
        edges.add(edge);
        vertexList[src].add(dest);
    }

    public void addEdge(int src, int dest, int weight){
        Edge edge = new Edge(src,dest,weight);
        edges.add(edge);
        vertexList[src].add(dest);
    }

    public void addUndirectedEdge(int src, int dest){
        Edge edge = new Edge(src,dest, 1);
        edges.add(edge);
        vertexList[src].add(dest);
        vertexList[dest].add(src);
    }

    public void addUndirectedEdge(int src, int dest, int weight){
        Edge edge = new Edge(src,dest,weight);
        edges.add(edge);
        vertexList[src].add(dest);
        vertexList[dest].add(src);
    }

    public List<Integer> getAdjacentVertices(int vertex){
        return vertexList[vertex];
    }
}


