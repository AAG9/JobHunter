package com.ameya.tree.binarytree;

/**
 * Created by chiko on 1/27/2017.
 */
public class SizeOfBT {
    public static int getSizeOfBT(TreeNode root){
        int left = (root.left == null) ? 0 : getSizeOfBT(root.left);
        int right = (root.right == null) ? 0 : getSizeOfBT(root.right);
        return 1+left+right;
    }

    public static void main(String[] args) {
        TreeNode root = Main.createBT();
        System.out.println(getSizeOfBT(root));
    }
}
