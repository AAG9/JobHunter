package com.ameya.tree.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by chiko on 1/20/2017.
 */
public class Inorder {
    public static List<Integer> inOrder(TreeNode root){
        if(root == null) return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resultList = new ArrayList<>();
        TreeNode currentNode = root;
        boolean flag = false;
        while (!flag){
            if(currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }else {
                if(stack.isEmpty()){
                    flag = true;
                }else {
                    currentNode = stack.pop();
                    resultList.add(currentNode.data);
                    currentNode = currentNode.right;
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(13);
        System.out.println(inOrder(root));
    }
}
