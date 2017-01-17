/**
 * Created by chiko on 12/28/2016.
 */
public class PlusOne66 {
    public int[] plusOne(int[] arr){
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i] < 9){
                arr[i] = arr[i]+1;
                return arr;
            }
            arr[i] = 0;
        }
        int[] newArr = new int[arr.length+1];
        newArr[0] = 1;
        return newArr;
    }

}
