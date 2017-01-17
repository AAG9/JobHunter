import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

/**
 * Created by chiko on 1/11/2017.
 */
public class LongestAbsoluteFilePath388 {
    public static class Node{
        String name;
        Node parent;
        int tab;
        public Node(String name, Node parent, int tab){
            this.name = name;
            this.parent = parent;
            this.tab = tab;
        }
    }

    public static int solution(String s){
        BufferedReader in = new BufferedReader(new ByteArrayInputStream(s.getBytes()));
        Node dummyNode = new Node("", null,0);
        int maxLength = 0;
        Node previousNode = dummyNode;
        while (in.hasNext()){
            String currentName = in.nextLine();
            int currentTabs = countTabs(currentName);

            Node parentDir = previousNode;
            while (parentDir.tab != currentTabs)
                parentDir = parentDir.parent;

            // create new node and assign parent
            Node currentNewNode = new Node(currentName.trim(), parentDir, currentTabs + 1);
            previousNode = currentNewNode;

            // if it is a image file, calculate parent path length
            Node node = currentNewNode;
            if (isFile(currentName.trim())) {
                int currentDirLineSize = node.name.trim().length();
                while (node.parent != null) {
                    currentDirLineSize += (node.parent.name.length() + 1);
                    node = node.parent;
                }
                maxLength = Math.max(maxLength, currentDirLineSize);
            }
        }
        return maxLength-1;
    }

    private static int countTabs(String s){
        int tab = 0;
        for(int i=0; i<s.length();i++){
            if(s.charAt(i) == '\t')
                tab++;
        }
        return tab;
    }

    private static boolean isFile(String fileName){
        if(fileName.contains(".")){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }
}
