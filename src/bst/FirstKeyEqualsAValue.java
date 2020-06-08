package bst;
/*Variant: Write a program that takes as input a BST and a value, and returns the node
whose key equals the input value and appears first in an inorder traversal of the BST.
For example, when applied to the BST in Figure 15.2 on the next page, your program
should return Node B for 108, Node G for 285, and null for 143.*/
public class FirstKeyEqualsAValue {
    BinaryTreeNode a = null;

    void checkrecursive(BinaryTreeNode<Integer> node, int data) {
        if (node == null ) {
            return;
        }

        if (data == node.data) {
            a = node;
            checkrecursive(node.left, data);
        }
        if (data > node.data) {
            checkrecursive(node.right, data);
        }

    }
    BinaryTreeNode checkIterative(BinaryTreeNode<Integer> node, int data) {
        BinaryTreeNode a=null;
        while (node != null ) {

            if (data <= node.data) {
                if(data==node.data){
                    a = node;
                }

                node = node.left;
            }
            else
                node=node.right;
        }
        return a;
    }

    public static void main(String[] args) {
        FirstKeyEqualsAValue firstKeyEqualsAValue = new FirstKeyEqualsAValue();

        BinaryTreeNode root = new BinaryTreeNode(108);
        root.left = new BinaryTreeNode(108);
        root.left.left = new BinaryTreeNode(-10);
        root.left.left.left = new BinaryTreeNode(-14);
        root.left.left.right = new BinaryTreeNode(2);
        root.left.right = new BinaryTreeNode(108);
        root.right = new BinaryTreeNode(285);
        root.right.left = new BinaryTreeNode(243);
        root.right.right = new BinaryTreeNode(285);
        root.right.right.right = new BinaryTreeNode(401);

       // firstKeyEqualsAValue.checkrecursive(root, 3);
       // System.out.println(firstKeyEqualsAValue.a.data);
        System.out.println(firstKeyEqualsAValue.checkIterative(root, 143).data);
    }
}
