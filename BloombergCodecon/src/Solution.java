import java.util.Scanner;

/**
 * Created by chiko on 1/24/2017.
 */
public class Solution {
    public static void main(String[] args)
    {

        Scanner stdin = new Scanner(System.in);
        int inputPosition = stdin.nextInt();
        int targetPosition = stdin.nextInt();
        if(((inputPosition%8) + (((inputPosition-1)%16)/8))%2 != ((targetPosition%8) + (((targetPosition-1)%16)/8))%2){
            System.out.println(-1);
            return;
        }
        if(inputPosition == targetPosition){
            System.out.println(0);
            return;
        }
        if(inputPosition % 7 == targetPosition%7)
            System.out.println(1);
        else if(inputPosition %9 == targetPosition%9)
            System.out.println(1);
        else
            System.out.println(2);
        stdin.close();
    }
}
