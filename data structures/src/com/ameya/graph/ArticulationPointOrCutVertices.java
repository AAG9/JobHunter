package com.ameya.graph;

/**
 * Created by chiko on 1/16/2017.
 */
public class ArticulationPointOrCutVertices {

    int time = 0;
    static int NIL = -1;

    public void ArticulationPoints(Graph graph){
        boolean[] visited = new boolean[graph.vertices];
        int[] parent = new int[graph.vertices];
        int[] low = new int[graph.vertices];
        int[] disc = new int[graph.vertices];
        boolean[] AP = new boolean[graph.vertices];

        for (int i=0; i< graph.vertices;i++){
            parent[i] = NIL;
            visited[i] = false;
            AP[i] = false;
        }

        for (int i = 0; i<graph.vertices; i++){
            if(!visited[i])
                ArticulationPointsUtil(i, graph, parent, low, disc, visited, AP);
        }

        for (int i=0; i<graph.vertices;i++){
            if(AP[i]) System.out.print(i+" ");
        }
    }

    public void ArticulationPointsUtil(int u,Graph graph, int[] parent, int[] low, int[] disc, boolean[] visited, boolean[] AP){
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;
        for (Integer v : graph.getAdjacentVertices(u)){
            if(!visited[v]) {
                children++;
                parent[v] = u;
                ArticulationPointsUtil(v, graph, parent, low, disc, visited, AP);

                low[u] = Math.min(low[u], low[v]);

                if (parent[u] == NIL && children > 1)
                    AP[u] = true;

                if (parent[u] != NIL && low[v] >= disc[u])
                    AP[u] = true;
            }
            else if(v != parent[u])
                low[u] = Math.min(low[u],low[v]);
        }

    }

    public static void main(String[] args) {
        ArticulationPointOrCutVertices articulationPointOrCutVertices = new ArticulationPointOrCutVertices();
        // Create graphs given in above diagrams
        System.out.println("Articulation points in first graph ");
        Graph g1 = new Graph(5);
        g1.addUndirectedEdge(1, 0);
        g1.addUndirectedEdge(0, 2);
        g1.addUndirectedEdge(2, 1);
        g1.addUndirectedEdge(0, 3);
        g1.addUndirectedEdge(3, 4);
        articulationPointOrCutVertices.ArticulationPoints(g1);
        System.out.println();

        System.out.println("Articulation points in Second graph");
        Graph g2 = new Graph(4);
        g2.addUndirectedEdge(0, 1);
        g2.addUndirectedEdge(1, 2);
        g2.addUndirectedEdge(2, 3);
        articulationPointOrCutVertices.ArticulationPoints(g2);
        System.out.println();

        System.out.println("Articulation points in Third graph ");
        Graph g3 = new Graph(7);
        g3.addUndirectedEdge(0, 1);
        g3.addUndirectedEdge(1, 2);
        g3.addUndirectedEdge(2, 0);
        g3.addUndirectedEdge(1, 3);
        g3.addUndirectedEdge(1, 4);
        g3.addUndirectedEdge(1, 6);
        g3.addUndirectedEdge(3, 5);
        g3.addUndirectedEdge(4, 5);
        articulationPointOrCutVertices.ArticulationPoints(g3);
    }
}
