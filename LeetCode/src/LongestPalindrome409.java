import java.util.HashMap;
import java.util.Map;

/**
 * Created by chiko on 12/21/2016.
 */
public class LongestPalindrome409 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = createHashMap(s);
        return getCount(map);
    }

    public Map<Character, Integer> createHashMap(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i< s.length();i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,1);
            }
            else{
                int count = map.get(c);
                map.put(c, ++count);
            }
        }
        return map;
    }

    public int getCount(Map<Character, Integer> map){
        int count=0; boolean flag = false;
        for(Integer c: map.values()){
            if(c>1){
                if(c%2==0){
                    count = count + c;
                }else{
                    count = count+ c-1;
                }
            }else{
                if(!flag){
                    count++;
                    flag=true;
                }
            }
            if(c%2 != 0 && !flag){
                count = count + c%2;
                flag = true;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LongestPalindrome409 longestPalindrome409 = new LongestPalindrome409();
        System.out.println(longestPalindrome409.longestPalindrome("bananas"));
    }

}
