/**
 * Created by chiko on 1/11/2017.
 */
public class LongestIncreasingSubsequence {
    public int longestIncreasingSubsequence(int[] arr){
        int[] len = new int[arr.length];
        int max = Integer.MIN_VALUE;
        for(int i=1; i<arr.length;i++){
            for(int j=0; j<i;j++){
                if(arr[i]>arr[j] && len[i]<len[j]+1){
                    len[i] = len[j]+1;
                    max = len[i];
                }
            }
        }
        return max+1;
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().longestIncreasingSubsequence(new int[]{1,2,7,4,8,3,10}));
    }
}
