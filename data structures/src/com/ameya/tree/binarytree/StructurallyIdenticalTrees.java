package com.ameya.tree.binarytree;

/**
 * Created by chiko on 1/27/2017.
 */
public class StructurallyIdenticalTrees {
    public static boolean areStructurallyIdentical(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;

        return areStructurallyIdentical(root1.left,root2.right) && areStructurallyIdentical(root1.right, root2.left);
    }
}
