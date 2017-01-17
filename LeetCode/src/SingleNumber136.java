/**
 * Created by chiko on 12/14/2016.
 */
public class SingleNumber136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums)
            result ^= i ;
        return result ;
    }
}
