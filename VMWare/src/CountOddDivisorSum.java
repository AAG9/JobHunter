import java.util.HashSet;
import java.util.Set;

/**
 * Created by chiko on 1/20/2017.
 */
public class CountOddDivisorSum {
    static long countSum(int[] input) {
        long totalSum = 0;
        Set<Integer> hs;
        for(int inp: input ){
            int sum=0;
            hs = new HashSet<>();
            for(int i = 1; i <= Math.sqrt(inp)+1; i++)
            {
                if(inp % i == 0)
                {
                    int temp = inp/i;
                    if(i == temp  && i % 2 != 0 && !hs.contains(i)) {
                        sum += i;
                        hs.add(i);
                    }
                    else if(temp %2 != 0  && !hs.contains(temp)){
                        if(i %2 != 0 && !hs.contains(i))
                            sum += i;
                        sum += temp;
                        hs.add(temp);
                    }else if(i % 2 != 0 && !hs.contains(i)){
                        sum += i;
                        hs.add(i);
                    }
                }
            }
            hs.clear();
            totalSum+=sum;
        }
        return totalSum;
    }

    public static void main(String[] args) {
        int[] arr = {21,11,7};
        System.out.println(countSum(arr));
    }
}
