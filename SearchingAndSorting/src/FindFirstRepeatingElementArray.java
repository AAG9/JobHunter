import java.util.*;

/**
 * Created by chiko on 1/18/2017.
 */
public class FindFirstRepeatingElementArray {
    public static int getFirstRepeatingElementSet(int[] arr){
        int min = Integer.MAX_VALUE;
        Set<Integer> hashSet = new HashSet<>();

        for(int i=arr.length-1;i>=0;i--){
            if(hashSet.contains(arr[i]))
                min = (i < min) ? i:min;
            hashSet.add(arr[i]);
        }
        return arr[min];
    }


    public static void main(String[] args) {
        int[] arr = new int[]{6, 10, 5, 4, 9, 120, 4, 6, 10};
        System.out.println(getFirstRepeatingElementSet(arr));
    }
}
