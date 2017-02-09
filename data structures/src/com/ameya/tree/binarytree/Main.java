package com.ameya.tree.binarytree;

/**
 * Created by chiko on 1/27/2017.
 */
public class Main {

    static Main _instance = null;
    private Main(){

    }
    public static Main getInstance(){
        if(_instance == null)
            _instance = new Main();
        return _instance;
    }

    int addNumbers(int a, int b){
        return a+b;
    }

    public static TreeNode createBT() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(11);

        return root;
    }

    public static void main(String[] args){
        Main main = new Main();
        System.out.println(Main.getInstance().addNumbers(5,6));
        System.out.println(main.addNumbers(1,2));
    }
}
