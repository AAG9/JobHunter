package com.ameya.graph;

/**
 * Created by chiko on 1/14/2017.
 */
public class Edge implements Comparable<Edge>{
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight){
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight-o.weight;
    }

    public int getSource(){
        return source;
    }
    public int getDestination(){
        return destination;
    }
    public int getWeight(){
        return weight;
    }
    public int getAdjacentVertex(int k){
        if(k==source)
            return destination;
        if(k==destination)
            return source;
        return Integer.MIN_VALUE;
    }
}
