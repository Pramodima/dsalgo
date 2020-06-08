package binaryTrees;

import java.util.LinkedList;
import java.util.List;

public class ExteriorOfABinaryTree {
    public static List<BinaryTreeNode<Integer>> exteriorBinaryTree(
            BinaryTreeNode<Integer> tree) {
        List<BinaryTreeNode<Integer>> exterior = new LinkedList<>();
        if (tree != null) {
            exterior.add(tree);
            exterior.addAll(leftBoundaryAndLeaves(tree.left, true));
            exterior.addAll(rightBoundaryAndLeaves(tree.right, true));
        }
        return exterior;
    }
    // Computes the leaves in left-to-right order followed by the rightmost leaf
// to the root path in subtreeRoot.
    private static List<BinaryTreeNode<Integer>> rightBoundaryAndLeaves(
            BinaryTreeNode<Integer> subtreeRoot, boolean isBoundary) {
        List<BinaryTreeNode<Integer>> result = new LinkedList<>();
        if (subtreeRoot != null) {
            result.addAll(rightBoundaryAndLeaves(
                    subtreeRoot.left, isBoundary && subtreeRoot.right == null));
            result.addAll(rightBoundaryAndLeaves(subtreeRoot.right, isBoundary));
            if (isBoundary || isLeaf(subtreeRoot)
            ) {
                result.add(subtreeRoot);
            }
        }
        return result;
    }
    // Computes the leaves in left-to-right order followed by the rightmost leaf
// to the root path in subtreeRoot.
    private static List<BinaryTreeNode<Integer>> leftBoundaryAndLeaves(
            BinaryTreeNode<Integer> subtreeRoot, boolean isBoundary) {
        List<BinaryTreeNode<Integer>> result = new LinkedList<>();
        if (subtreeRoot != null) {
            if (isBoundary || isLeaf(subtreeRoot)
            ) {
                result.add(subtreeRoot);
            }
            result.addAll(leftBoundaryAndLeaves(subtreeRoot.left, isBoundary));
            result.addAll(leftBoundaryAndLeaves(
                    subtreeRoot.right, isBoundary  && subtreeRoot.left == null));
        }
        return result;
    }

    /*
       6
 /          \
3            5
/ \         /    \
2   8       10    4
   / \      /
   7  9     13
   /   / \    \
 12      11   14
 */
    private static boolean isLeaf (BinaryTreeNode <Integer> node) {
        return node. left == null && node. right == null;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(6);
        root.left = new BinaryTreeNode(3);
        root.right = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(4);
        root.right.left = new BinaryTreeNode(10);
        root.right.left.left = new BinaryTreeNode(13);
        root.right.left.left.right = new BinaryTreeNode(14);
        root.left.left = new BinaryTreeNode(2);
        root.left.right = new BinaryTreeNode(8);
        root.left.right.right = new BinaryTreeNode(9);
        root.left.right.right = new BinaryTreeNode(11);
        root.left.right.left = new BinaryTreeNode(7);
        root.left.right.left.left = new BinaryTreeNode(12);



        final List<BinaryTreeNode> list = exteriorBinaryTree(root);
        list.forEach(e-> System.out.print(e.data+"  "));
       // System.out.println(list);
    }
}