package bst;

//FIND THE FIRST KEY GREATER THAN A GIVEN VALUE IN A BST
/*Write a program that takes as input a BST and a value, and returns the first key
        that would appear in an inorder traversal which is greater than the input value.*/
public class FirstKeyGreaterThanAValue {
    int a = 0;

    void checkrecursive(BinaryTreeNode<Integer> node, int data) {
        if (node == null ) {
           return;
        }

        if (data < node.data) {
            a = node.data;
            checkrecursive(node.left, data);
        }
        if (data > node.data) {
            checkrecursive(node.right, data);
        }

    }
    int checkIterative(BinaryTreeNode<Integer> node, int data) {
        int a=0;
        while (node != null ) {

        if (data < node.data) {
            a = node.data;
            node = node.left;
        }
        else
            node=node.right;
        }
       return a;
    }

    public static void main(String[] args) {
        FirstKeyGreaterThanAValue firstKeyGreaterThanAValue = new FirstKeyGreaterThanAValue();

        BinaryTreeNode root = new BinaryTreeNode(19);
        root.left = new BinaryTreeNode(7);
        root.left.left = new BinaryTreeNode(3);
        root.left.left.left = new BinaryTreeNode(2);
        root.left.left.right = new BinaryTreeNode(5);
        root.left.right = new BinaryTreeNode(11);
        root.left.right.right = new BinaryTreeNode(17);
        root.left.right.right.left = new BinaryTreeNode(13);
        root.right = new BinaryTreeNode(43);
        root.right.left = new BinaryTreeNode(23);
        root.right.left.right = new BinaryTreeNode(37);
        root.right.left.right.left = new BinaryTreeNode(29);
        root.right.left.right.left.right = new BinaryTreeNode(31);
        root.right.left.right.right = new BinaryTreeNode(41);
        root.right.right = new BinaryTreeNode(47);
        root.right.right = new BinaryTreeNode(53);
        firstKeyGreaterThanAValue.checkrecursive(root, 2);
        System.out.println(firstKeyGreaterThanAValue.a);
        System.out.println(firstKeyGreaterThanAValue.checkIterative(root, 2));
    }
}