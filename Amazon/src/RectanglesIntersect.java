/**
 * Created by chiko on 1/17/2017.
 */
public class RectanglesIntersect {
    public static void main(String[] args) {
        int[] coordinates = new int[]{-3,0,3,4,-4,-1,0,2};
        System.out.println(isIntersecting(coordinates));
    }

    public static boolean isIntersecting(int []arr){
        int A = arr[0];
        int B = arr[1];
        int C = arr[2];
        int D = arr[3];
        int E = arr[4];
        int F = arr[5];
        int G = arr[6];
        int H = arr[7];

        if(C < E || G < A)
            return false;
        if(H < B || D<F)
            return false;

        return true;
    }
}
