import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chiko on 1/17/2017.
 */
public class SlidingWindowSum {
    public static void main(String[] args) {
        int[] inputArray = new int[]{1,2,3,4,5,6,7,8};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));
        int window = 3;
        ArrayList<Integer> result = calculateWindowSums(list, window);
        for(Integer i: result){
            System.out.println(i);
        }
    }

    public static ArrayList<Integer> calculateWindowSums(ArrayList<Integer> list, int windowSize){
        if(list.isEmpty()) return list;

        ArrayList<Integer> resultList = new ArrayList<>();
        int resultListLength = list.size() - windowSize + 1;
        int initialSum = 0;
        for(int i=0; i<windowSize;i++){
            initialSum += list.get(i);
        }
        resultList.add(0,initialSum);
        for (int i=1;i<resultListLength;i++){
            int tempSum = resultList.get(i-1) - list.get(i-1) + list.get(i+windowSize-1);
            resultList.add(tempSum);
        }
        return resultList;
    }
}
