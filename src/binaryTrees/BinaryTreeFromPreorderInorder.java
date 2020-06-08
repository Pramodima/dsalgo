package binaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeFromPreorderInorder {

    public static BinaryTreeNode<String> binaryTreeFromPreorderInorder(
            List<String> preorder, List<String> inorder) {
        Map<String, Integer> nodeToInorderIdx = new HashMap<String, Integer>();
        for (int i = 0; i < inorder.size(); ++i) {
            nodeToInorderIdx.put(inorder.get(i), i);
        }
return  binaryTreeFromPreorderInorderHelper (
            preorder, 0, preorder.size () , 0, inorder.size (),nodeToInorderIdx);
}
    private static BinaryTreeNode<String > binaryTreeFromPreorderInorderHelper (
            List<String > preorder, int preorderStart , int preorderEnd,
            int inorderStart , int inorderEnd ,
            Map<String, Integer> nodeToInorderIdx) {
        if (preorderEnd <= preorderStart || inorderEnd <= inorderStart) {
            return null ;
        }

        int rootInorderIdx = nodeToInorderIdx.get (preorder.get(preorderStart)) ;
        int leftSubtreeSize = rootInorderIdx - inorderStart;
        BinaryTreeNode binaryTreeNode=new BinaryTreeNode <>(
                preorder.get (preorderStart));
        binaryTreeNode.left= binaryTreeFromPreorderInorderHelper (
                preorder, preorderStart + 1, preorderStart + 1 + leftSubtreeSize ,
                inorderStart, rootInorderIdx, nodeToInorderIdx);
        binaryTreeNode.right=binaryTreeFromPreorderInorderHelper (
                preorder, preorderStart + 1 + leftSubtreeSize , preorderEnd,
                rootInorderIdx + 1, inorderEnd, nodeToInorderIdx);
       /* return new BinaryTreeNode <>(
                preorder.get (preorderStart) ,
// Recursively builds the left subtree.
                binaryTreeFromPreorderInorderHelper (
                preorder, preorderStart + 1, preorderStart + 1 + leftSubtreeSize ,
                inorderStart, rootInorderIdx, nodeToInorderIdx),
// Recursively builds the right subtree.
                binaryTreeFromPreorderInorderHelper (
                preorder, preorderStart + 1 + leftSubtreeSize , preorderEnd,
                        rootInorderIdx + 1, inorderEnd, nodeToInorderIdx));*/
       return binaryTreeNode;
}
private void inorder(BinaryTreeNode root){
        if(root==null)
            return;
    inorder(root.left);
    System.out.println(root.data);
    inorder(root.right);
}
    public static void main(String[] args) {

        BinaryTreeNode root = new BinaryTreeNode("H");
        root.left = new BinaryTreeNode("B");
        root.right = new BinaryTreeNode("C");
        root.right.right = new BinaryTreeNode("D");
        root.right.right.right = new BinaryTreeNode("G");
        root.right.right.right.left = new BinaryTreeNode("I");
        root.left.left = new BinaryTreeNode("F");
        root.left.right = new BinaryTreeNode("E");
        root.left.right.left = new BinaryTreeNode("A");
        List<String> preOrder=new ArrayList<>();
        preOrder.add("H");preOrder.add("B");preOrder.add("F");preOrder.add("E");preOrder.add("A");preOrder.add("C");preOrder.add("D");preOrder.add("G");preOrder.add("I");
        List<String> inOrder=new ArrayList<>();
        inOrder.add("F");inOrder.add("B");inOrder.add("A");inOrder.add("E");inOrder.add("H");inOrder.add("C");inOrder.add("D");inOrder.add("I");inOrder.add("G");
        BinaryTreeFromPreorderInorder binaryTreeFromPreorderInorder=new BinaryTreeFromPreorderInorder();
        final BinaryTreeNode<String> stringBinaryTreeNode = binaryTreeFromPreorderInorder.binaryTreeFromPreorderInorder(preOrder, inOrder);
        binaryTreeFromPreorderInorder.inorder(stringBinaryTreeNode);
    }
}
