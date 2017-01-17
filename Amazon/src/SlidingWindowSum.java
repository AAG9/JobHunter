/**
 * Created by chiko on 1/17/2017.
 */
public class SlidingWindowSum {
    public static void main(String[] args) {
        int[] inputArray = new int[]{1,2,3,4,5,6,7,8};
        int window = 3;
        int[] result = getSlidingWindowSum(inputArray, window);
        for(Integer i: result){
            System.out.println(i);
        }
    }

    public static int[] getSlidingWindowSum(int[] arr, int w){
        int result[] = new int[arr.length - w+1];

        for(int i=0;i<w;i++){
            result[0] += arr[i];
        }

        for (int i=1;i<result.length;i++){
            result[i] = result[i-1] - arr[i-1] + arr[i+w-1];
        }
        return result;
    }
}
