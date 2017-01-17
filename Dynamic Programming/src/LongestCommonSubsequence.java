/**
 * Created by chiko on 1/11/2017.
 */
public class LongestCommonSubsequence {
    public int LCS(String s1, String s2){
        int [][] matrix = new int[s1.length()+1][s2.length()+1];
        int i,j;
        for(i=0; i<=s1.length();i++){
            for(j=0; j<=s2.length();j++){
                if(i==0 || j==0)
                    matrix[i][j] = 0;
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                else
                    matrix[i][j] = Math.max(matrix[i][j-1], matrix[i-1][j]);
            }
        }
        return matrix[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().LCS("ABCDGH","AEDFHR"));
    }
}
