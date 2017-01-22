import java.util.*;

/**
 * Created by chiko on 1/17/2017.
 */
public class MinimumSets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Map<Character,List<Integer>> tMap = new TreeMap<>();
        Set<Character> set = new HashSet<>();
        in.nextLine();
        while (N-->0){
            String line = in.nextLine();
            if(line.charAt(0) == '^'){
                char setName = line.charAt(1);
                if(!tMap.containsKey(setName)){
                    tMap.put(setName, new ArrayList<>());
                }if(!isOpen(setName, set)){
                    set.add(setName);
                }
            }else if(line.charAt(0) == '/'){
                char setName = line.charAt(1);
                if(isOpen(setName,set)){
                    set.remove(setName);
                }
            }else{
                int val = Integer.parseInt(line);
                for (Character c: set){
                    tMap.get(c).add(val);
                }
            }
        }

        for(Map.Entry<Character, List<Integer>> entry: tMap.entrySet()){
            Collections.sort(entry.getValue());
        }

        for(Map.Entry<Character, List<Integer>> entry: tMap.entrySet()){
            StringBuilder op = new StringBuilder();
            op.append(entry.getKey()+" ");
            for (Integer i: entry.getValue()){
                op.append(i+" ");
            }
            System.out.println(op.toString().trim());
        }
    }

    public static boolean isOpen(Character c, Set<Character> set){
        if(!set.contains(c))return false;
        return true;
    }

}
