import java.util.ArrayList;
import java.util.List;

/**
 * Created by chiko on 1/5/2017.
 */
public class FindDuplicates442 {
    public static List<Integer> findDuplicates(int[] nums) {
       List<Integer> result = new ArrayList<>();
       for(int i=0; i<nums.length; i++){
           int index = Math.abs(nums[i]) - 1;
           if(nums[index] < 0){
               result.add(Math.abs(index+1));
           }
           nums[index] = -nums[index];
       }
       return result;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[] {4,3,2,7,8,2,3,1}));
    }
}
