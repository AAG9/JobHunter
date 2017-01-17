package com.ameya.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by chiko on 1/16/2017.
 */
public class KruskalMST {

    public void sortEdges(List<Edge> edges){
        Collections.sort(edges);
    }

    public List<Edge> KruskalMST(Graph graph){
        sortEdges(graph.edges);
        DisjointSet disjointSet = new DisjointSet(graph.vertices);
        List<Edge> result = new ArrayList<>();
        for(Edge edge: graph.edges){
            int sRoot = disjointSet.find(edge.getSource());
            int dRoot = disjointSet.find(edge.getDestination());

            if(sRoot == dRoot)
                continue;

            result.add(edge);
            disjointSet.union(sRoot,dRoot);
        }
        return result;
    }

    public static void main(String[] args) {
        KruskalMST kruskalMST = new KruskalMST();
        Graph graph = new Graph(4);
        graph.addEdge(0,1,10);
        graph.addEdge(0,2,6);
        graph.addEdge(0,3,5);
        graph.addEdge(1,3,15);
        graph.addEdge(2,3,4);
        List<Edge> edgeList = kruskalMST.KruskalMST(graph);
        for (Edge edge: edgeList)
            System.out.println(edge.getSource()+"-->"+edge.getDestination()+","+edge.getWeight());
    }

}
