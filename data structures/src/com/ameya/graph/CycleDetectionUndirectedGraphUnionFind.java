package com.ameya.graph;

/**
 * Created by chiko on 1/16/2017.
 */
public class CycleDetectionUndirectedGraphUnionFind {

    public boolean isCyclic(Graph graph, DisjointSet disjointSet){
        for(Edge edge: graph.edges){
            int x = disjointSet.find(edge.getSource());
            int y = disjointSet.find(edge.getDestination());

            if(x==y)
                return true;
            disjointSet.union(x,y);
        }
        return false;
    }

    public static void main(String[] args) {
        Graph g1 = new Graph(5);
        g1.addUndirectedEdge(1, 0);
        g1.addUndirectedEdge(0, 2);
        g1.addUndirectedEdge(0, 3);
        g1.addUndirectedEdge(3, 4);

        DisjointSet disjointSet = new DisjointSet(g1.vertices);
        CycleDetectionUndirectedGraphUnionFind cycleDetectionUndirectedGraphUnionFind = new CycleDetectionUndirectedGraphUnionFind();
        System.out.println(cycleDetectionUndirectedGraphUnionFind.isCyclic(g1,disjointSet));
    }
}
