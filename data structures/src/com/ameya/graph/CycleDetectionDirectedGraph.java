package com.ameya.graph;

/**
 * Created by chiko on 1/16/2017.
 */
public class CycleDetectionDirectedGraph {

    public boolean isCyclic(Graph graph){
        boolean[] visited= new boolean[graph.vertices];
        boolean[] recStack = new boolean[graph.vertices];

        for (int i=0; i<graph.vertices;i++){
            if(isCyclicUtil(i, graph,visited,recStack))
                return true;
        }
        return false;
    }

    public boolean isCyclicUtil(int u, Graph graph, boolean[] visited, boolean[] recStack){
        visited[u] = true;
        recStack[u] = true;

        for(Integer v: graph.getAdjacentVertices(u)){
            if(!visited[v])
                isCyclicUtil(v,graph,visited,recStack);
            else if(recStack[v])
                return true;
        }
        recStack[u] = false;
        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        CycleDetectionDirectedGraph cycleDetectionDirectedGraph = new CycleDetectionDirectedGraph();
        System.out.println(cycleDetectionDirectedGraph.isCyclic(g));
    }
}
