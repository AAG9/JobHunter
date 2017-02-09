package com.ameya.tree.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by chiko on 1/20/2017.
 */
public class Preorder {
    public static List<Integer> preOrder(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if(temp.right != null){
                stack.push(temp.right);
            }

            if(temp.left != null){
                stack.push(temp.left);
            }

            resultList.add(temp.data);
        }
        return resultList;
    }

    public static void preOrdereRec(TreeNode root){
        if(root != null){
            System.out.println(root.data+" ");
            preOrdereRec(root.left);
            preOrdereRec(root.right);
        }
    }

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(13);
        System.out.println(preOrder(root));
        preOrdereRec(root);*/

        System.out.println(Main.getInstance().addNumbers(5,6));

    }
}
