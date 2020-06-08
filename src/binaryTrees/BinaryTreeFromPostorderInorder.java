package binaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeFromPostorderInorder {

    public static BinaryTreeNode<String> binaryTreeFromPreorderInorder(
            List<String> postorder, List<String> inorder) {
        Map<String, Integer> nodeToInorderIdx = new HashMap<String, Integer>();
        for (int i = 0; i < inorder.size(); ++i) {
            nodeToInorderIdx.put(inorder.get(i), i);
        }
        return  binaryTreeFromPostorderInorderHelper (
                postorder, 0, postorder.size () , 0, inorder.size (),nodeToInorderIdx);
    }
    private static BinaryTreeNode<String > binaryTreeFromPostorderInorderHelper (
            List<String > postorder, int postorderStart , int postorderEnd,
            int inorderStart , int inorderEnd ,
            Map<String, Integer> nodeToInorderIdx) {
        if (postorderEnd <= postorderStart || inorderEnd <= inorderStart) {
            return null ;
        }

        int rootInorderIdx = nodeToInorderIdx.get (postorder.get(postorderEnd)) ;
        int leftSubtreeSize = rootInorderIdx - inorderStart;
        BinaryTreeNode binaryTreeNode=new BinaryTreeNode <>(
                postorder.get (postorderEnd));
        binaryTreeNode.left= binaryTreeFromPostorderInorderHelper (
                postorder, postorderStart + 1, postorderStart + 1 + leftSubtreeSize ,
                inorderStart, rootInorderIdx, nodeToInorderIdx);
        binaryTreeNode.right=binaryTreeFromPostorderInorderHelper (
                postorder, postorderStart + 1 + leftSubtreeSize , postorderEnd,
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

       /* BinaryTreeNode root = new BinaryTreeNode("H");
        root.left = new BinaryTreeNode("B");
        root.right = new BinaryTreeNode("C");
        root.right.right = new BinaryTreeNode("D");
        root.right.right.right = new BinaryTreeNode("G");
        root.right.right.right.left = new BinaryTreeNode("I");
        root.left.left = new BinaryTreeNode("F");
        root.left.right = new BinaryTreeNode("E");
        root.left.right.left = new BinaryTreeNode("A");*/
        List<String> postOrder=new ArrayList<>();
        postOrder.add("F");postOrder.add("A");postOrder.add("E");postOrder.add("B");postOrder.add("I");postOrder.add("G");postOrder.add("D");postOrder.add("C");postOrder.add("H");
        List<String> inOrder=new ArrayList<>();
        inOrder.add("F");inOrder.add("B");inOrder.add("A");inOrder.add("E");inOrder.add("H");inOrder.add("C");inOrder.add("D");inOrder.add("I");inOrder.add("G");
        BinaryTreeFromPostorderInorder binaryTreeFromPostorderInorder=new BinaryTreeFromPostorderInorder();
        final BinaryTreeNode<String> stringBinaryTreeNode = binaryTreeFromPostorderInorder.binaryTreeFromPreorderInorder(postOrder, inOrder);
        binaryTreeFromPostorderInorder.inorder(stringBinaryTreeNode);
    }
}
