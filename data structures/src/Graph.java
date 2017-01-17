import java.util.*;

/**
 * Created by chiko on 1/4/2017.
 */
public class Graph {
    private int vertices;
    public List<Integer> adj[];

    public Graph(int vertices){
        this.vertices = vertices;
        this.adj = new LinkedList[vertices];
        for (int i=0; i<vertices; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination){
        adj[source].add(destination);
    }

    public void dfs(int s){
        boolean[] visited = new boolean[vertices];
        dfsUtil(s, visited);
    }

    public void dfsUtil(int s, boolean[] visited){
        visited[s] = true;
        System.out.print(s+" ");

        Iterator<Integer> it = adj[s].listIterator();
        while (it.hasNext()){
            int n = it.next();
            if(!visited[n])
                dfsUtil(n,visited);
        }
    }


    public void bfs(int s){
        boolean[] visited = new boolean[this.vertices];
        visited[s] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while (!q.isEmpty()){
            int temp = q.poll();
            System.out.print(temp+" ");

            Iterator<Integer> it = adj[temp].iterator();
            while (it.hasNext()){
                int n = it.next();
                if(!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
    }


    /*public boolean isCyclic(){
        boolean[] visited = new boolean[vertices];
        boolean[] recStack = new boolean[vertices];

        for(int i=0; i<vertices;i++)
            if(isCyclicUtil(i,visited,recStack)) return true;

        return false;
    }

    public boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack){
        if(visited[i] == false){
            visited[i] = true;
            recStack[i] = true;

            Iterator<Integer> it = adj[i].iterator();
            while (it.hasNext()){
                int n = it.next();
                if(!visited[n] && isCyclicUtil(n,visited,recStack))
                    return true;
                else if(recStack[i])
                    return true;
            }
        }
        recStack[i] = false;
        return false;
    }*/

    public boolean isCyclic(){
        boolean visited[] = new boolean[vertices];
        boolean recStack[] = new boolean[vertices];

        for(int i=0; i< vertices; i++){
            if(isCyclicUtil(i,visited, recStack))    return true;
        }
        return false;
    }

    public boolean isCyclicUtil(int s, boolean[] visited, boolean[] recStack){
        if(!visited[s]){
            visited[s] = true;
            recStack[s] = true;

            Iterator<Integer> it = adj[s].iterator();
            while(it.hasNext()){
                int n = it.next();
                if(!visited[n] && isCyclicUtil(n,visited, recStack))
                    return true;
                else if(recStack[n])
                    return true;
            }
        }
        recStack[s] = false;
        return false;
    }

    public void topologicalSort(){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[this.vertices];

        for(int i=0; i<vertices; i++){
            if(!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        while (!stack.empty())
            System.out.print(stack.pop()+" ");
    }


    private void topologicalSortUtil(int i, boolean[] visited, Stack<Integer> stack){
        visited[i] = true;
        Integer n;

        Iterator<Integer> it = adj[i].iterator();
        while (it.hasNext()){
            n = it.next();
            if(!visited[n])
                topologicalSortUtil(n, visited, stack);
        }

        stack.push(new Integer(i));
    }


    public int[] shortestPathUnweighted(int s){
        int[] distance = new int[this.vertices];
        for(int i=0; i<this.vertices; i++) distance[i]=-1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        distance[s] = 0;
        int v,w;
        while (!queue.isEmpty()){
            v = queue.poll();

            Iterator<Integer> it = adj[v].iterator();
            while (it.hasNext()){
                w = it.next();
                if(distance[w] == -1){
                    distance[w] = distance[v]+1;
                    queue.add(w);
                }
            }
        }
        return distance;
    }

    public int[] shuffle(int[] nums) {
        int[] rand = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            int r = (int) (Math.random() * (i+1));
            rand[i] = rand[r];
            rand[r] = nums[i];
        }
        return rand;
    }


    public boolean isBipartite(int source){
        int[] colorArr = new int[vertices];
        boolean[] visited =new boolean[vertices];
        for(int i=0; i<vertices;i++)colorArr[i]=-1;
        Queue<Integer> q = new LinkedList<>();
        colorArr[source] = 0;
        q.add(source);
        while(!q.isEmpty()){
            int u = q.poll();
            Iterator<Integer> it = adj[u].iterator();
            while(it.hasNext()){
                int v = it.next();
                if(!visited[v]&&colorArr[v] == -1){
                    colorArr[v] = 1-colorArr[u];
                    q.add(v);
                }else if (!visited[v] && colorArr[v]==colorArr[u])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Create a graph given in the above diagram
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        //g.topologicalSort();

/*        int[] arr = g.shuffle(new int[] {1,2,3});
        for(Integer i: arr) System.out.print(i+" ");*/

        //System.out.println(g.isCyclic());

        if (g.isBipartite(0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
