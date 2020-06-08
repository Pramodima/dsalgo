package bst;

import java.util.ArrayList;
import java.util.List;

public class KLargestElementInABST {

    List<Integer> getKLargestElementInBST(BinaryTreeNode<Integer> node, int req) {
        List<Integer> k = new ArrayList<>();
        getKLargestElementInBSTHelper(node, k, req);
        return k;
    }

    private void getKLargestElementInBSTHelper(BinaryTreeNode<Integer> node, List<Integer> list, int req) {
        if (node == null || list.size() > req ) {
            return;
        }
        // Perform reverse inorder traversal .
        getKLargestElementInBSTHelper(node.right, list, req);
        if (list.size() < req) {
        list.add(node.data);
        getKLargestElementInBSTHelper(node.left, list, req);
        }
    }

    public static void main(String[] args) {
        KLargestElementInABST kLargestElementInABST = new KLargestElementInABST();

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
        root.right.right.right = new BinaryTreeNode(53);
        List kLargestElementInBST = kLargestElementInABST.getKLargestElementInBST(root, 8);
        System.out.println(kLargestElementInBST);
    }
}