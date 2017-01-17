/**
 * Created by chiko on 1/11/2017.
 */
public class LongestUniqueSubstring {
    public int longestUniqueSubstring(String s){
        int currentLength = 1;
        int maxLength = 1;
        int prevIndex;
        int[] visited  = new int[256];
        int i;
        for(i=0; i<visited.length;i++)visited[i] = -1;
        visited[s.charAt(0)] = 0;
        for (i=1; i<s.length();i++){
            prevIndex = visited[s.charAt(i)];
            if(prevIndex == -1 || i-currentLength > prevIndex)
                currentLength++;
            else {
                if(maxLength < currentLength)maxLength = currentLength;
                currentLength = i - prevIndex;
            }
            visited[s.charAt(i)] = i;
        }

        if(currentLength > maxLength) maxLength = currentLength;
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestUniqueSubstring().longestUniqueSubstring("geeksforgeeks"));
    }
}
