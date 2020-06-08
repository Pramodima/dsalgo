package binaryTrees;

import java.util.ArrayList;
import java.util.List;

/*Design an algorithm for reconstructing a binary tree from a preorder traversal visit
sequence that uses null to mark empty children.*/
public class BinaryTreeFromPreOrder {

    private static Integer subtreeldx;

    public static BinaryTreeNode<String> reconstructPreorder(List<String> preorder) {
        subtreeldx = 0;

        return reconstructPreorderSubtree(preorder);
    }

    // Reconstructs the subtree that is rooted at subtreeldx .
    private static BinaryTreeNode<String> reconstructPreorderSubtree(
            List<String> preorder) {
        String subtreeKey = preorder.get(subtreeldx);
        ++subtreeldx;

        if (subtreeKey == null) {
            return null;
        }

        BinaryTreeNode<String> leftSubtree = reconstructPreorderSubtree(preorder);
        BinaryTreeNode<String> rightSubtree = reconstructPreorderSubtree(preorder);
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
        List<String> preOrder=new ArrayList<>();
        preOrder.add("H");preOrder.add("B");preOrder.add("F");preOrder.add(null);preOrder.add(null);
        preOrder.add("E");preOrder.add("A");preOrder.add(null);preOrder.add(null);preOrder.add(null);
        preOrder.add("C");preOrder.add(null);preOrder.add("D");preOrder.add(null);preOrder.add("G");preOrder.add("I");
        preOrder.add(null);preOrder.add(null);preOrder.add(null);

        final BinaryTreeNode<String> stringBinaryTreeNode = reconstructPreorder(preOrder);
        inorder(stringBinaryTreeNode);
        System.out.println();
        postorder(stringBinaryTreeNode);
    }
}