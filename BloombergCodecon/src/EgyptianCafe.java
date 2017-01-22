import java.util.*;

/**
 * Created by chiko on 1/21/2017.
 */
public class EgyptianCafe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer,Integer> queue = new LinkedHashMap<>();
        while(n-->0){
            queue.put(sc.nextInt(), queue.size());
        }


    }

    public static int getProcessTime(Map<Integer, Integer> queue, int m){
        boolean isOrderProcessed = false;
        int i=0, j=0;
        while (!isOrderProcessed){
            int max = findMax(queue);
            if(queue.get(0) != max){
                int temp = queue.get(0);
                queue.remove(0);
                int size = queue.size();
                queue.add(temp);
                j++;
            }else if(queue.get(0) == max){

            }
        }
    }

    public static int findMax(Map<Integer, Integer> queue){
        int max = Integer.MAX_VALUE;
        for(int i : queue.keySet()){
            if(i>max)
                max = i;
        }
        return max;
    }
}
