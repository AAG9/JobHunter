/**
 * Created by chiko on 12/14/2016.
 */
public class AddDigits258 {
    public int addDigits(int num) {
        if(num<10)
            return num;
        return 1+(num-1)%9;
    }
}
