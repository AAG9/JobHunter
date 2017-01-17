/**
 * Created by chiko on 12/14/2016.
 */
public class ReverseString344 {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length()-1;
        for(int i=length; i>=0;i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public String reverseStringFaster(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() -1;
        while(i<j){
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return new String(word);
    }

    public int[] reverseIntArray(int[] arr){
        int i = 0;
        int j = arr.length - 1;
        while (i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }

    public static void main(String[] args) {
        ReverseString344 reverseString344 = new ReverseString344();
        System.out.println(reverseString344.reverseStringFaster("Ameya"));
        int[] arr = {1,2,3,455,5};
        int[] rev = reverseString344.reverseIntArray(arr);
        for (int i=0; i<rev.length;i++){
            System.out.print(rev[i]+" ");
        }

    }
}
