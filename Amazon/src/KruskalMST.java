/**
 * Created by chiko on 1/17/2017.
 */
import java.util.*;
public class KruskalMST {
    static class Edge implements Comparable<Edge>{
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public int compareTo(Edge e){
            return this.weight - e.weight;
        }

        public int getSource(){
            return this.source;
        }

        public int getDestination(){
            return this.destination;
        }

        public int getWeight(){
            return this.weight;
        }
    }

    static class DisjointSet{
        int[] parent, rank;
        int n;

        public DisjointSet(int n){
            this.n = n;
            parent = new int[n];
            rank = new int[n];
            makeSet();
        }

        public  void makeSet(){
            for(int i=0;i<n;i++)
                parent[i] = i;
        }

        public  int findSet(int x){
            if(parent[x] != x){
                parent[x] = findSet(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y){
            int xRoot = findSet(x);
            int yRoot = findSet(y);

            if(xRoot == yRoot)
                return;

            if(rank[xRoot] > rank[yRoot]){
                parent[yRoot] = xRoot;
            }else if(rank[yRoot]>rank[xRoot]){
                parent[xRoot] = yRoot;
            }else{
                parent[yRoot] = xRoot;
                rank[xRoot] += 1;
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> vertexMap = new HashMap<>();
        List<Edge> edgeList = new ArrayList<>();

        int n = sc.nextInt();
        int m = sc.nextInt();


        while(m-->0){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();

            if(!vertexMap.containsKey(src))
                vertexMap.put(src, vertexMap.size());
            if(!vertexMap.containsKey(dest))
                vertexMap.put(dest, vertexMap.size());

            Edge edge = new Edge(vertexMap.get(src), vertexMap.get(dest), weight);
            edgeList.add(edge);
        }
        DisjointSet disjointSet = new DisjointSet(n);
        System.out.println(getMSTSum(edgeList, disjointSet));
    }

    public static int getMSTSum(List<Edge> edgeList, DisjointSet disjointSet){
        Collections.sort(edgeList);
        List<Edge> resultList = new ArrayList<>();
        for(Edge edge: edgeList){
            int x = disjointSet.findSet(edge.source);
            int y = disjointSet.findSet(edge.destination);

            if(x == y)
                continue;

            resultList.add(edge);
            disjointSet.union(x,y);
        }

        int sum=0;

        for(Edge edge: resultList){
            sum += edge.weight;
        }
        return sum;
    }

    /*Input Format:
4 6
1 2 5
1 3 3
4 1 6
2 4 7
3 2 4
3 4 5*/
}
