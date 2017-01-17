    import java.util.ArrayList;

    class solution{


    public static int solution(String S) {
            String[] arr = S.split("\n");
            Node root = new Node(-1);
            root.len = 0;
            Node curr = root;
            int max = Integer.MIN_VALUE;
            int sum=0;
            for(int i=0;i<arr.length;i++) {
            Node nn = new Node(arr[i]);
            while(curr != null && nn != null) {
            if(nn.space > curr.space) {
            nn.parent=curr;
            if(nn.isImage()) {
            sum = curr.len;
            max = Integer.max(sum, max);
            }
            nn.len = nn.name.length() + curr.len;
            curr = nn;
            break;
            } else {
            curr = curr.parent;
            }
            }
            }
            return max;
            }

    static class Node {
        String name="";
        int space=0;
        int len=0;
        Node parent;
        Node(String str) {
            name = "/"+str.trim();
            space = str.length()-str.trim().length();
        }
        Node(int spaceLen) {
            space = spaceLen;
        }
        boolean isImage(){
            if(name.contains(".jpeg") || name.contains(".png") || name.contains(".gif")) {
                return true;
            }
            return false;
        }


    }
        public static void main(String[] args) {
            System.out.println( solution("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
        }
    }