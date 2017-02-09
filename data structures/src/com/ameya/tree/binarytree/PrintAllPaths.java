package com.ameya.tree.binarytree;

/**
 * Created by chiko on 1/27/2017.
 */
public class PrintAllPaths {

    public static void printPaths(TreeNode root){
        int[] path = new int[256];
        printPaths(root, path,0);

    }

    public static void printPaths(TreeNode root, int[] path, int pathLen){
        if(root == null)
            return;

        path[pathLen++] = root.data;

        if(root.left == null && root.right == null){
            printArray(path);
        }else {
            printPaths(root.left,path,pathLen);
            printPaths(root.right, path, pathLen);
        }
    }

    public static void printArray(int arr[]){
        for(int i: arr)
            System.out.print(i+" ");
    }
}
