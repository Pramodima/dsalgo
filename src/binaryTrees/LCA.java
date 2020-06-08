package binaryTrees;

public class LCA {

    private static class Status {
        public int numTargetNodes ;
        public BinaryTreeNode <Integer > ancestor;
        public Status(int numTargetNodes, BinaryTreeNode <Integer> node) {
            this .numTargetNodes = numTargetNodes;
            this . ancestor = node ;
        }
    }
/*    private static class BinaryTreeNode<T> {
        public T data;
        public BinaryTreeNode<T> left, right;
    }*/
    public static BinaryTreeNode<Integer> LCA (BinaryTreeNode <Integer> tree,
                                                BinaryTreeNode <Integer> node0,
                                                BinaryTreeNode <Integer> node1) {
        return LCAHelper( tree , node0, node1 ).ancestor ;
    }
    // Returns an object consisting of an int and a node. The int field is
// 0, 1, or 2 depending on how many of {node0 , node1} are present in
// the tree. If both are present in the tree , when ancestor is
// assigned to a non-null value, it is the LCA.
              /*    1
                 /   \
                2     3
                /      \
                 4     5
                / \
                6  7
                /
                8
                */

    private static Status LCAHelper(BinaryTreeNode <Integer> tree,
                                    BinaryTreeNode <Integer> node0,
                                    BinaryTreeNode <Integer> node1) {
        if (tree== null)
               {
            return new Status (0, null);
        }
        Status leftResult = LCAHelper ( tree.left , node0, node1);
        if (leftResult . numTargetNodes == 2) {
// Found both nodes in the left subtree.
            return leftResult;
        }
        Status rightResult = LCAHelper(tree .right , node0, node1);
        if (rightResult .numTargetNodes == 2) {
// Found both nodes in the right subtree.
            return rightResult;
        }
        int numTargetNodes
                =
                leftResult.numTargetNodes + rightResult.numTargetNodes+
         (tree == node0 ? 1 : 0) + (tree == node1 ? 1 : 0) ;
        return new Status (numTargetNodes , numTargetNodes == 2 ? tree : null);
    }

    public static void main(String[] args) {
        BinaryTreeNode root=new BinaryTreeNode(23);
        root.left=new BinaryTreeNode(12);
        root.right=new BinaryTreeNode(25);
        root.right.left=new BinaryTreeNode(24);
        root.right.right=new BinaryTreeNode(28);
        root.left.left=new BinaryTreeNode(11);
        root.left.right=new BinaryTreeNode(14);
        final BinaryTreeNode lca = LCA(root,  root.left.left, root.left.right);
        System.out.println(lca.data);
    }
}
