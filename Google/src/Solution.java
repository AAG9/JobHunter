import java.util.ArrayList;
import java.util.List;

/**
 * Created by chiko on 1/11/2017.
 */
public class Solution {
    public int solution(int X) {
        ArrayList<Integer> list = intToArr(X);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<list.size()-1;i++) {
            ArrayList<Integer> list1 = new ArrayList<>(list);
            double a = list1.remove(i);
            double b = list1.remove(i);
            int res = (int)Math.ceil((a+b)/2);
            list1.add(i,res);
            max = Integer.max(arrToInt(list1),max);
        }
        return max;
    }

    ArrayList<Integer> intToArr(int x){
        ArrayList<Integer> al = new ArrayList<>();
        while (x != 0){
            int num = x%10;
            al.add(0,num);
            x = x/10;
        }
        return al;
    }

/*    int arrToInt(ArrayList<Integer> al){
        StringBuilder strNum = new StringBuilder();

        for (int num : al)
        {
            strNum.append(num);
        }
        int finalInt = Integer.parseInt(strNum.toString());
        return finalInt;
    }*/

    int arrToInt(ArrayList<Integer> al){
        int number = 0;
        for(int i: al){
            number = number*10+i;
        }
        return number;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(1524));
    }
}
