import java.util.ArrayList;
import java.util.List;

/**
 * Created by chiko on 12/14/2016.
 */
public class FizzBuzz412 {
    public List<String> fizzBuzz(int n) {
        List<String> al = new ArrayList<>();
        for(int i=1;i<=n;i++){
            int remainderThree = i%3;
            int remainderFive = i%5;
            if(remainderThree!=0 && remainderFive!=0){
                al.add(Integer.toString(i));
            }else if(remainderThree==0 && remainderFive==0){
                al.add("FizzBuzz");
            }else if(remainderThree==0 && remainderFive!=0){
                al.add("Fizz");
            }else{
                al.add("Buzz");
            }
        }
        return al;
    }

    public static void main(String[] args) {
        FizzBuzz412 fizzBuzz412 = new FizzBuzz412();
        System.out.print(fizzBuzz412.fizzBuzz(15));
    }
}
