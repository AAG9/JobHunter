import sun.plugin2.gluegen.runtime.CPU;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by chiko on 1/13/2017.
 */
public class ShantanuAmazon {
    static String longestPalSubstr( String str )
    {
        int n = str.length(); // get length of input string

        // table[i][j] will be false if substring str[i..j]
        // is not palindrome.
        // Else table[i][j] will be true
        boolean table[][] = new boolean[n][n];

        // All substrings of length 1 are palindromes
        int maxLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = true;

        // check for sub-string of length 2.
        int start = 0;
        for (int i = 0; i < n-1; ++i)
        {
            if (str.charAt(i) == str.charAt(i+1))
            {
                table[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for lengths greater than 2. k is length
        // of substring
        for (int k = 3; k <= n; ++k)
        {
            // Fix the starting index
            for (int i = 0; i < n-k+1 ; ++i)
            {
                // Get the ending index of substring from
                // starting index i and length k
                int j = i + k - 1;

                // checking for sub-string from ith index to
                // jth index iff str[i+1] to str[j-1] is a
                // palindrome
                if (table[i+1][j-1] && str.charAt(i) == str.charAt(j))
                {
                    table[i][j] = true;

                    if (k > maxLength)
                    {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }

        System.out.println("Longest palindrome substring is: ");

        return str.substring(start, start+maxLength); // return length of LPS;
    }

    static void printSubStr( String str, int low, int high )
    {
        for( int i = low; i <= high; ++i )
            System.out.println(str.charAt(i));
    }

    class CPoint{
        public double x;
        public double y;
    }

    public static CPoint[] closestK(CPoint[] myList, int k){
        Map<Double, CPoint> tMap = new TreeMap<>();

        for(int i=0; i<myList.length; i++){
            double x = myList[i].x;
            double y = myList[i].y;

            double distanceFromOrigin = Math.sqrt(x*x + y*y);
            tMap.put(distanceFromOrigin,myList[i]);
        }

        int count = 0;
        CPoint[] cPoints = new CPoint[k];

        for(Map.Entry<Double, CPoint> entry: tMap.entrySet()){
            if(count < k){
                cPoints[count++] = entry.getValue();
            }
        }
        return cPoints;
    }

    public static void main(String[] args) {
        System.out.println(longestPalSubstr("abbabbaxabbabba"));
    }
}
