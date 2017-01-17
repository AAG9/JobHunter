package com.ameya.graph;

/**
 * Created by chiko on 1/16/2017.
 */
public class CycleDetectionUndirectedGraph {
    public boolean isCyclic(Graph graph){
        boolean[] visited = new boolean[graph.vertices];
        int parent = -1;
        for(int i=0;i<graph.vertices;i++){
            if(!visited[i])
                if(isCyclicUtil(i,graph, visited, parent))
                return true;
        }
        return false;
    }

    public boolean isCyclicUtil(int u,Graph graph, boolean[] visited, int parent){
        visited[u] = true;
        for (Integer v: graph.getAdjacentVertices(u)){
            if(!visited[v])
                if(isCyclicUtil(v,graph,visited,u))
                    return true;
            else if(v != parent && parent != -1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Graph g1 = new Graph(5);
        g1.addUndirectedEdge(1, 0);
        g1.addUndirectedEdge(0, 2);
        g1.addUndirectedEdge(0, 3);
        g1.addUndirectedEdge(3, 4);

        CycleDetectionUndirectedGraph cycleDetectionUndirectedGraph = new CycleDetectionUndirectedGraph();
        System.out.println(cycleDetectionUndirectedGraph.isCyclic(g1));
    }
}
