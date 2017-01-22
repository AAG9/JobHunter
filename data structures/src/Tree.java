import com.sun.org.apache.regexp.internal.RE;
import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * Created by chiko on 12/23/2016.
 */
public class Tree {
    class Node{
        int data;
        Node left=null,right=null;

        public Node(int data){
            this.data = data;
        }

        public Node(int data, int left, int right){
            this.data = data;
            this.left = new Node(left);
            this.right = new Node(right);
        }
    }

    private Node root;


    public void createBT(){
        root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(12);
        root.left.left = new Node(7);
        root.left.right = new Node(9);
        root.right.left = new Node(11);
        root.right.right = new Node(13);
    }


    public void preOrder(Node root){
        if(root != null){
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }


    public void preOrderIterative(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node temp = stack.pop();
            System.out.print(temp.data+" ");
            if(temp.right != null)
                stack.push(temp.right);
            if(temp.left != null)
                stack.push(temp.left);
        }
    }


    public void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }



    public void inOrderIterative(){
        Stack<Node> stack = new Stack<>();
        Node currentNode = root;
        boolean done = false;
        while (!done){
            if(currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }else {
                if(stack.isEmpty()){
                    done = true;
                }else{
                    currentNode = stack.pop();
                    System.out.print(currentNode.data+" ");
                    currentNode = currentNode.right;
                }
            }
        }
    }


    public void postOrder(Node root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
    }


    public void postOrderIterative(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node prev = null;
        while (!stack.isEmpty()){
            Node current = stack.peek();
            if(prev == null || prev.left == current || prev.right == current){
                if(current.left != null)
                    stack.push(current.left);
                else if(current.right != null)
                    stack.push(current.right);
            }else if(current.left == prev){
                if(current.right != null)
                    stack.push(current.right);
            }else {
                System.out.print(current.data+" ");
                stack.pop();
            }
            prev = current;
        }
    }


    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.data+" ");
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
    }


    public List<List<Integer>> levelOrderStructured(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> wrapList = new ArrayList<>();

        while (!queue.isEmpty()){
            int levelLen = queue.size();
            List<Integer> subList = new ArrayList<>();
            for(int i=0 ; i<levelLen;i++){
                if(queue.peek().left != null) queue.add(queue.peek().left);
                if (queue.peek().right != null) queue.add(queue.peek().right);
                subList.add(queue.poll().data);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }


    public int maxElement(Node temp){
        int maxElement = Integer.MIN_VALUE;
        if(temp != null){
            int leftMax = maxElement(temp.left);
            int rightMax = maxElement(temp.right);

            if(leftMax > rightMax)
                maxElement = leftMax;
            else
                maxElement = rightMax;

            if(temp.data > maxElement)
                maxElement = temp.data;
        }

        return maxElement;
    }


    public int maxElementLevelOrder(){
        if(root == null) return -1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.data > max)
                max = temp.data;

            if(temp.left != null)queue.add(temp.left);
            if(temp.right != null) queue.add(temp.right);
        }

        return max;
    }


    public boolean searchElementRecursive(Node temp, int key){
        if(temp == null)return false;
        if(temp.data == key)
            return true;
        return searchElementRecursive(temp.left,key) || searchElementRecursive(temp.right,key);
    }


    public boolean searchElementLevelOrder(int key){
        if(root == null) return false;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.data == key)
                return true;

            if(temp.left != null)queue.add(temp.left);
            if(temp.right != null) queue.add(temp.right);
        }

        return false;
    }


    public void insertElementLevelOrder(int data){
        if(root == null) root = new Node(data);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.left != null)queue.add(temp.left);
            else {temp.left = new Node(data); return;}
            if(temp.right != null) queue.add(temp.right);
            else {temp.right = new Node(data);return;}
        }
    }


    public int size(Node temp){
        int lCount = (temp.left == null) ? 0:size(temp.left);
        int rCount = (temp.right == null) ? 0:size(temp.right);
        return 1+lCount+rCount;
    }


    public int numberOfLeaves(){
        if(root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.left == null && temp.right == null) ++count;
            if(temp.left != null)queue.add(temp.left);
            if(temp.right != null) queue.add(temp.right);
        }
        return count;
    }


    public boolean isStructurallyIdentical(Node root1, Node root2){
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null )
            return false;

        return isStructurallyIdentical(root1.left, root2.right) && isStructurallyIdentical(root1.right, root2.left);
    }

    int diameter=0;
    public int diameterOfTree(Node root){
        int left, right;
        if(root == null) return 0;
        left = diameterOfTree(root.left);
        right = diameterOfTree(root.right);

        if(left + right > diameter)
            diameter = left+right;

        return Math.max(left,right)+1;
    }


    public int levelWithMaxSum(){
        if(root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int maxSum=0, currentSum = 0;
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp != null){
                currentSum += temp.data;
                if(temp.left != null)queue.add(temp.left);
                if(temp.right != null)queue.add(temp.right);
            }else{
                if(currentSum > maxSum) maxSum = currentSum;
                currentSum = 0;
                if(!queue.isEmpty()) queue.add(null);
            }
        }
        return maxSum;
    }


    public void printPaths(){
        if(root == null) return;
        int[] paths = new int[256];
        printPaths(root,paths, 0);
    }

    public void printPaths(Node root, int[] paths, int pathLength){
        if(root == null) return;
        paths[pathLength++] = root.data;
        if(root.left == null && root.right == null)
            printArray(paths,pathLength);
        else {
            printPaths(root.left, paths, pathLength);
            printPaths(root.right, paths, pathLength);
        }
    }


    public void printArray(int[] path, int len){
        for (int i = 0; i< len; i++){
            System.out.println(path[i]+" ");
        }
        System.out.println();
    }


    public Node mirrorOfBinaryTree(Node root){
        Node temp;
        if(root != null){
            mirrorOfBinaryTree(root.left);
            mirrorOfBinaryTree(root.right);
            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }


    public boolean areMirrors(Node root1, Node root2){
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        if(root1.data != root2.data)
            return false;

        return areMirrors(root1.left, root2.right) && areMirrors(root1.right,root2.left);
    }


    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.createBT();
        tree.inOrderIterative();
        /*tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.inOrderIterative();
        System.out.println();
        tree.postOrder(tree.root);
        System.out.println();
        tree.postOrderIterative();
        System.out.println();
        tree.levelOrder();
        System.out.println("\n"+tree.levelOrderStructured());

        System.out.println(tree.maxElement(tree.root));
        System.out.println(tree.maxElementLevelOrder());*/

        /*System.out.println(tree.searchElementRecursive(tree.root,0));
        System.out.println(tree.searchElementLevelOrder(9));*/

        /*tree.insertElementLevelOrder(15);
        System.out.println(tree.levelOrderStructured());*/

        //System.out.println(tree.size(tree.root));

        //System.out.println(tree.numberOfLeaves());

        //System.out.println(tree.levelWithMaxSum());

        //tree.printPaths();
        /*tree.mirrorOfBinaryTree(tree.root);
        tree.levelOrder();*/
    }
}
