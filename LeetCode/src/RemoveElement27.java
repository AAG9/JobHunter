/**
 * Created by chiko on 12/28/2016.
 */
public class RemoveElement27 {
    public int removeElement(int[] arr, int val){
        int i = 0;
        int n = arr.length;
        while (i<n){
            if(arr[i] == val){
                arr[i] = arr[n-1];
                n--;
            }else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] arr =  new int[]{1,2,2,2,3};
        RemoveElement27 removeElement27 = new RemoveElement27();
        System.out.println(removeElement27.removeElement(arr,2));
    }
}
