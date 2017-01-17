package com.ameya.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chiko on 1/16/2017.
 */
public class Traversals {
    public void dfs(int source, Graph g){
        boolean[] visited = new boolean[g.vertices];
        dfsUtil(source,visited,g);
    }

    public void dfsUtil(int source, boolean[] visited, Graph g){
        visited[source]  = true;
        System.out.print(source+" ");
        for(int n: g.vertexList[source]){
            if(!visited[n])
                dfsUtil(n, visited,g);
        }
    }

    public void bfs(int source, Graph g){
        Queue<Integer> queue = new LinkedList<>()    ;
        queue.add(source);
        boolean visited[] = new boolean[g.vertices];
        while (!queue.isEmpty()){
            int temp = queue.poll();
            System.out.print(temp+" ");
            visited[temp] = true;
            for(int n: g.vertexList[temp]){
                if(!visited[n])
                    queue.add(n);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        Traversals traversals = new Traversals();
        traversals.bfs(2,g);
    }
}
