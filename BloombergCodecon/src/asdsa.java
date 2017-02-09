import java.util.Scanner;

/**
 * Created by chiko on 1/24/2017.
 */
public class asdsa {
    public static void main(String[] args)
    {

        Scanner stdin = new Scanner(System.in);
        while(stdin.hasNext())
        {
            int N = stdin.nextInt();
            int K = stdin.nextInt();
            int num = K-1;
            if(K < 1 || K > Math.pow(2,N)){
                System.out.println(-1);
                continue;
            }


            String result = retDigit(num/2,N);

            System.out.println(result.charAt(num%2));
        }
        stdin.close();
    }

    private static String retDigit(int num,int level){
        if(level == 0)
            return "0";
        String fin = retDigit(num/2,level-1);
        if(fin.charAt(num%2) == '0')
            return "01";
        else
            return "10";
    }
}


