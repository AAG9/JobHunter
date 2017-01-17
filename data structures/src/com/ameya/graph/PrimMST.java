package com.ameya.graph;

import java.util.*;

/**
 * Created by chiko on 1/17/2017.
 */
public class PrimMST {

    static int MAX = Integer.MAX_VALUE;
    static Queue<Node> pq = new PriorityQueue<>();
    static Map<Integer, Node> heapMap = new HashMap<>();
    static Map<Integer, List<Edge>> vertexEdgeList = new HashMap<>();
    static Map<Integer, Edge> vertexEdge = new HashMap<>();
    static List<Edge> resultMST = new ArrayList<>();

    static class Node implements Comparable<Node>{
        int node;
        int weight;

        public Node(int node, int weight){
            this.node = node;
            this.weight = weight;
        }

        public int getNode(){
            return this.node;
        }

        public int getWeight(){
            return this.weight;
        }

        public int compareTo(Node e){
            return this.weight - e.getWeight();
        }
    }

    public static int getMSTSum(){
        int sum = 0;
        for(Edge edge:resultMST){
            sum += edge.getWeight();
        }
        return sum;
    }

    public static void updateMinHeapVal(int node, int weight){
        pq.remove(heapMap.get(node));
        Node temp = new Node(node, weight);
        pq.offer(temp);
        heapMap.put(node,temp);
    }

    public static void primMST(){
        while (!heapMap.isEmpty()){
            int current = pq.poll().getNode();
            heapMap.remove(current);
            resultMST.add(vertexEdge.remove(current));

            for(Edge edge : vertexEdgeList.get(current)){
                int adjV = edge.getAdjacentVertex(current);
                if(heapMap.containsKey(adjV)){
                    int weight = heapMap.get(adjV).getWeight();
                    if(weight > edge.getWeight()){
                        updateMinHeapVal(adjV,edge.getWeight());
                        vertexEdge.put(adjV,edge);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        while (n>0){
            Node node = new Node(n,MAX);
            pq.offer(node);
            heapMap.put(n,node);
            n--;
        }
        sc.nextLine();
        while (m-->0){
            int source = sc.nextInt();
            int destination = sc.nextInt();
            int weight = sc.nextInt();

            Edge edge = new Edge(source,destination,weight);

            List<Edge> adjList1 = new ArrayList<>();
            List<Edge> adjList2 = new ArrayList<>();

            if(vertexEdgeList.containsKey(source)){
                adjList1 = vertexEdgeList.get(source);
            }
            if(adjList2.contains(destination)){
                adjList2 = vertexEdgeList.get(destination);
            }

            adjList1.add(edge);
            adjList2.add(edge);

            vertexEdgeList.put(source,adjList1);
            vertexEdgeList.put(destination,adjList2);
        }

        int startingVertex = sc.nextInt();
        sc.close();

        updateMinHeapVal(startingVertex,0);
        primMST();
        System.out.println(getMSTSum());
    }
}
