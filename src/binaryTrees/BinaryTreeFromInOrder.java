package binaryTrees;

import java.util.ArrayList;
import java.util.List;
/*Design an algorithm for reconstructing a binary tree from a inorder traversal visit
sequence that uses null to mark empty children.*/
public class BinaryTreeFromInOrder {
    private static Integer leftsubtreeldx=9;
    private static Integer rightsubtreeldx=9;
    public static BinaryTreeNode<String> reconstructPreorder(List<String> preorder) {

        return reconstructPreorderSubtree(preorder,true);
    }

    // Reconstructs the subtree that is rooted at subtreeldx .
    private static BinaryTreeNode<String> reconstructPreorderSubtree(
            List<String> inOrder,boolean left) {
        String subtreeKey=null;
        if(left && leftsubtreeldx>0) {
             subtreeKey = inOrder.get(leftsubtreeldx);
            --leftsubtreeldx;
        }
        if(!left && rightsubtreeldx<inOrder.size()){
            subtreeKey = inOrder.get(rightsubtreeldx);
            rightsubtreeldx++;
        }
        if (subtreeKey == null) {
            return null;
        }

        BinaryTreeNode<String> leftSubtree = reconstructPreorderSubtree(inOrder,true);
        BinaryTreeNode<String> rightSubtree = reconstructPreorderSubtree(inOrder,false);
        BinaryTreeNode bn=new BinaryTreeNode(subtreeKey, leftSubtree, rightSubtree);
        return bn;
    }
    private static void inorder(BinaryTreeNode root){
       /* if(root==null)
            return;*/
        if(root!=null)
            inorder(root.left);
        if(root!=null)
            System.out.print(root.data+" ");
        else
            System.out.print(root+" ");
        if(root!=null)
            inorder(root.right);
    }
    private static void postorder(BinaryTreeNode root){
       /* if(root==null)
            return;*/
        if(root!=null)
            postorder(root.left);

        if(root!=null)
            postorder(root.right);

        if(root!=null)
            System.out.print(root.data+" ");
        else
            System.out.print(root+" ");
    }
    public static void main(String[] args) {
        List<String> inOrder=new ArrayList<>();
        //null F null B null A null E null H null C null D null I null G null
        inOrder.add(null);inOrder.add("F");inOrder.add(null);inOrder.add("B");inOrder.add(null);
        inOrder.add("A");inOrder.add(null);inOrder.add("E");inOrder.add(null);inOrder.add("H");inOrder.add(null);
        inOrder.add("C");inOrder.add(null);inOrder.add("D");inOrder.add(null);inOrder.add("I");inOrder.add(null);
        inOrder.add("G");inOrder.add(null);

        final BinaryTreeNode<String> stringBinaryTreeNode = reconstructPreorder(inOrder);
        inorder(stringBinaryTreeNode);
        System.out.println();
        postorder(stringBinaryTreeNode);
    }
}
