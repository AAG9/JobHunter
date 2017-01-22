package com.ameya.graph;

import java.util.*;

/**
 * Created by chiko on 1/16/2017.
 */
public class TopologicalSort {
    public void topologicalSort(Graph graph){


        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[graph.vertices];
        for(int i=0; i<graph.vertices;i++){
            if(!visited[i])
                topologicalSortUtil(i,graph,visited,stack);
        }

        while (!stack.isEmpty())
            System.out.print(stack.pop()+" ");
    }

    public static String serialize (List<String> words, List<Integer> pos){
        int currPos = 0;
        StringBuffer sb = new StringBuffer();
        for (String s : words){
            pos.add(currPos+s.length());
            currPos += s.length();
            sb.append(s);
        }
        return sb.toString();
    }

    public void topologicalSortUtil(int i, Graph g, boolean[] visited, Stack<Integer> stack){
        visited[i] = true;
        for (Integer n: g.vertexList[i]){
            if(!visited[n])
                topologicalSortUtil(n,g,visited,stack);
        }
        stack.push(i);
    }

    public static void main(String[] args) {
/*        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        TopologicalSort topologicalSort = new TopologicalSort();
        topologicalSort.topologicalSort(g);*/

        List list= new ArrayList();
        list.add("cat");
        list.add("dog");
        list.add("horse");
        List<Integer> pos = new ArrayList();
        String s = serialize(list, pos);
        System.out.println(s);
    }
}
