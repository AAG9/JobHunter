import java.util.Scanner;

/**
 * Created by chiko on 1/24/2017.
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int prefixLength = stdin.nextInt();
        int numberPrefix = stdin.nextInt();
        int baseLen = stdin.nextInt();
        int compLen = stdin.nextInt();
        stdin.nextLine();
        String[] baseLang = new String[baseLen];
        String[] compLang = new String[compLen];

        float le = (float) compLen/baseLen;
        float matchPer = (float) numberPrefix/100;
        float th = (float) prefixLength / 100;
        System.out.println(matchPer);
        if(le < matchPer){
            System.out.println(0);
            return;
        }
        for(int i =0; i< baseLen;i++){
            baseLang[i] = stdin.nextLine();
        }

        for(int i =0; i< baseLen;i++){
            compLang[i] = stdin.nextLine();
        }
        int matches = 0;
        for(int i = 0;i<baseLen;i++){
            if(compareLength(baseLang[i], compLang[i], th)){
                matches++;
                System.out.println("Match:"+matches);
            }else{
                continue;
            }
        }

        float actMatch = (float) matches/baseLen;
        System.out.println(actMatch);
        System.out.println(matchPer);
        if(actMatch > matchPer){
            System.out.println(Math.round((float)(matches/baseLen)*100));
        }else{
            System.out.println(0);
        }
    }

    private static boolean compareLength(String base, String comp, float th){
        int length = 0;
        int i = 0;
        int j = 0;
        while (i < base.length() && j<comp.length()){
            if(base.charAt(i++) == comp.charAt(j++)){
                length++;
            }
        }
        float a = (float) length/base.length();
        System.out.println(a);
        System.out.println(th);
        if(a>th){
            System.out.println("here");
            return true;
        }
        System.out.println("fale");
        return false;
    }
}
