import java.util.HashMap;
import java.util.Map;

/**
 * Created by chiko on 12/14/2016.
 */
public class StringDifference389 {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> hm = createHashMap(s);
        return compareFunction(t,hm);
    }

    public Map<Character, Integer> createHashMap(String s){
        Map<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<s.length();i++){
            char key = s.charAt(i);
            if(!hm.containsKey(key)){
                hm.put(key,1);
            }else{
                int count = hm.get(key);
                hm.put(key, ++count);
            }
        }
        return hm;
    }

    public char compareFunction(String t, Map<Character, Integer> hm){
        for(int i=0; i<t.length();i++){
            char key = t.charAt(i);
            if(hm.containsKey(key)){
                int count = hm.get(key);
                hm.put(key, --count);
            }else{
                return key;
            }
        }
        for(int j=0; j<t.length();j++){
            char key = t.charAt(j);
            int count = hm.get(key);
            if(count != 0){
                return key;
            }
        }
        return ' ';
    }
}
