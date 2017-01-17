/**
 * Created by chiko on 1/11/2017.
 */
public class MinimumCostPath {

    private static int min(int x, int y, int z)
    {
        if (x < y)
            return (x < z)? x : z;
        else
            return (y < z)? y : z;
    }

    public int minCostPath(int[][] cost, int m, int n){
        int[][] tc = new int[m][n];
        int i,j;
        tc[0][0] = cost[0][0];
        for(i=1; i<m;i++) tc[i][0] = tc[i-1][0]+cost[i][0];
        for(j=1; j<n;j++) tc[0][j] = tc[0][j-1]+cost[0][j];

        for(i=1; i<m;i++){
            for(j=1;j<n;j++){
                tc[i][j] = min(tc[i-1][j],tc[i][j-1],tc[i-1][j-1])+cost[i][j];
            }
        }
        return tc[m-1][j-1];
    }

    public static void main(String[] args) {
        int[][] arr  = new int[][]{{1,2,3},{4,8,2},{1,5,3}};
        System.out.println(new MinimumCostPath().minCostPath(arr, 3, 3));
    }
}
