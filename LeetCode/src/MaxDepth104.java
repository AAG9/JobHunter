/**
 * Created by chiko on 12/14/2016.
 */
public class MaxDepth104 {

    class TreeNode{
        TreeNode left, right;
        int val;
        TreeNode(int val){
            this.val = val;
        }
    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }else{
            int lDepth = maxDepth(root.left);
            int rDepth = maxDepth(root.right);

            if(lDepth>rDepth){
                return lDepth+1;
            }else{
                return rDepth+1;
            }
        }
    }
}
