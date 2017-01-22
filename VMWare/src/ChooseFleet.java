import java.util.Arrays;

/**
 * Created by chiko on 1/18/2017.
 */
public class ChooseFleet {
    public static int[] chooseFleet(int[] wheels){
        int[] results = new int[wheels.length];
        int[] table = new int[wheels[0]+1];
        int[] typesOfWheels = new int[]{2,4};
        int m = typesOfWheels.length;


        for(int i = 0;i < wheels.length;i++){
            if(i!=0 && wheels[i] < table.length){
                results[i] = table[wheels[i]];
                continue;
            }

            table = new int[wheels[i]+1];

            // Base case (If given value is 0)
            table[0] = 1;

            // Pick all coins one by one and update the table[]
            // values after the index greater than or equal to
            // the value of the picked coin

            for (int j=0; j<m; j++)
                for (int k=typesOfWheels[j]; k<=wheels[i]; k++)
                    table[k] += table[k-typesOfWheels[j]];

            results[i] = table[wheels[i]];

        }
        return results;
    }

    public static void main(String[] args){
        int[] arr = {6,3,2,5,8,10,12};
        int[] results = chooseFleet(arr);

        for(int i:results){
            System.out.println(i);
        }
    }


}
