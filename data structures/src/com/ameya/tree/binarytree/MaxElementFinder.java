package com.ameya.tree.binarytree;

/**
 * Created by chiko on 1/27/2017.
 */
public class MaxElementFinder {
    public static int getMaxElement(TreeNode root){
        int max = Integer.MIN_VALUE;
        if(root != null){
            int leftMax = getMaxElement(root.left);
            int rightMax = getMaxElement(root.right);

             max = (leftMax > rightMax) ? leftMax:rightMax;
            if(max < root.data)
                max = root.data;
        }
        return max;
    }

    public static void main(String[] args) {
        TreeNode root = Main.createBT();
        System.out.println(getMaxElement(root));
    }
}
