import java.util.Scanner;

/**
 * Created by chiko on 1/24/2017.
 */
public class Aolution3 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        int M = stdin.nextInt();
        int P = stdin.nextInt();
        int[] Q = new int[P];

        for(int i = 0; i < P; i++){
            Q[i] = stdin.nextInt();
        }


        for(int j = 0; j < P; j++){
            int total = 0;
            int wTemp = 0;
            total += Q[j]/N;
            wTemp += Q[j]/N;
            for(int k = 0; k < 100; k++){
                int tempM = wTemp%M;
                wTemp = wTemp/M;
                total += wTemp;
                wTemp += tempM;
            }

            System.out.println(total);
        }
    }
}
