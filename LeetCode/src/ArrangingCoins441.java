/**
 * Created by chiko on 12/28/2016.
 */
public class ArrangingCoins441 {
    public int arrangeCoins(int n){
        int count = 0;
        for(int i=1; i<=n; i++){
            if(i>n)
                return count;
            count++;
            n = n-i;
        }
        return count;
    }

    public static void main(String[] args) {
        ArrangingCoins441 arrangingCoins441 = new ArrangingCoins441();
        System.out.println(arrangingCoins441.arrangeCoins(10));
    }
}



