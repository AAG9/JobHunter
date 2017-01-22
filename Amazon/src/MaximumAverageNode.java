import java.util.ArrayList;

/**
 * Created by chiko on 1/21/2017.
 */
public class MaximumAverageNode {
    class Node{
        int val = 0;
        ArrayList<Node> subNode = new ArrayList<Node>();
    }

    static class MaxNode{
        Node max;
        float avg = 0;
    }

    public static Node findMaxNode(Node root){
        MaxNode maxNode = new MaxNode();
        findMaxNodeUtil(root, maxNode);
    }

    public static MaxNode findMaxNodeUtil(Node root, MaxNode maxNode){

        for(Node node: root.subNode){
            if(!node.subNode.isEmpty())
                findMaxNodeUtil(node, maxNode);
            else {
                float currentAvg = calculateAverage(node);
                if(currentAvg > maxNode.avg){
                    maxNode.max = node;
                    maxNode.avg = currentAvg;
                }
                return maxNode;
            }
        }
    }

    public static float calculateAverage(Node node){
        float avg = 0;
        if(node.subNode.isEmpty())
            return avg;
        int tempSum = 0;
        for (Node temp : node.subNode){
            tempSum += temp.val;
        }
        int size = node.subNode.size();
        avg = (tempSum+node.val)/size+1;
        return avg;
    }
}
