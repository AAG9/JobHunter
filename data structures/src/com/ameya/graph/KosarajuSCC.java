package com.ameya.graph;

import java.util.Stack;

/**
 * Created by chiko on 1/16/2017.
 */
public class KosarajuSCC {

    public Graph getTransposedGraph(Graph graph){
        Graph transposedGraph = new Graph(graph.vertices);
        for (int i=0; i<graph.vertices;i++){
            for(Integer n: graph.vertexList[i]){
                transposedGraph.addEdge(n,i);
            }
        }
        return transposedGraph;
    }

    public void fillOrder(int s,Graph graph, Stack<Integer> stack, boolean[] visited){
        visited[s] = true;
        for(Integer i: graph.vertexList[s]){
            if(!visited[i])
                fillOrder(i,graph,stack,visited);
        }
        stack.push(s);
    }

    public void printStronglyConnectedComponents(Graph graph){
        boolean[] visited = new boolean[graph.vertices];
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i< graph.vertices;i++){
            if(!visited[i])
                fillOrder(i,graph, stack, visited);
        }
        Graph transposedGraph = getTransposedGraph(graph);
        visited = new boolean[transposedGraph.vertices];
        while (!stack.isEmpty()){
            int pop = stack.pop();
            if(!visited[pop]) {
                new Traversals().dfsUtil(pop, visited, transposedGraph);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        new KosarajuSCC().printStronglyConnectedComponents(graph);
    }
}
