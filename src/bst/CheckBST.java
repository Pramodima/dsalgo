package bst;

import java.util.LinkedList;
import java.util.Queue;

public class CheckBST {


        public BinaryTreeNode <Integer> treeNode ;
        public Integer lowerBound , upperBound ;
        public CheckBST(BinaryTreeNode <Integer> treeNode, Integer lowerBound,
                          Integer upperBound) {
            this.treeNode = treeNode;
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }

    public static boolean isBinaryTreeBST1(BinaryTreeNode<Integer> tree){
        return areKeysInRange(tree , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }
    private static boolean areKeysInRange(BinaryTreeNode <Integer> tree,
                                          Integer lower, Integer upper) {
        if (tree == null) {
            return true ;
        } else if (Integer.compare(tree.data , lower) < 0
|| Integer.compare(tree.data , upper) > 0) {
            return false;
        }
        return areKeysInRange(tree.left , lower, tree.data)
                && areKeysInRange(tree.right , tree.data, upper);
    }

    public static boolean isBinaryTreeBST(BinaryTreeNode <Integer> tree) {
        Queue<CheckBST> BFSQueue = new LinkedList<>();
        BFSQueue.add(new CheckBST(tree , Integer.MIN_VALUE , Integer.MAX_VALUE));
        CheckBST headEntry;
        while ((headEntry = BFSQueue.poll())!= null) {
            if (headEntry.treeNode != null) {
                if (headEntry.treeNode.data < headEntry.lowerBound
                        || headEntry.treeNode.data > headEntry.upperBound) {
                    return false;
                }
                BFSQueue.add(new CheckBST(headEntry.treeNode.left ,
                        headEntry.lowerBound ,
                        headEntry.treeNode.data));
                BFSQueue.add(new CheckBST(headEntry.treeNode.right ,
                        headEntry.treeNode.data,
                        headEntry.upperBound));
            }
        }
        return true ;
}
static void preorder(BinaryTreeNode node){
      if(node == null) return;
      preorder(node.left);
      System.out.print(node.data+" ");
      preorder(node.right);
}
    public static void main(String[] args) {
        BinaryTreeNode root=new BinaryTreeNode(19);
        root.left=new BinaryTreeNode(7);
        root.left.left=new BinaryTreeNode(3);
        root.left.left.left=new BinaryTreeNode(2);
        root.left.left.right=new BinaryTreeNode(5);
        root.left.right=new BinaryTreeNode(11);
        root.left.right.right=new BinaryTreeNode(17);
        root.left.right.right.left=new BinaryTreeNode(13);
        root.right=new BinaryTreeNode(43);
        root.right.left=new BinaryTreeNode(23);
        root.right.left.right=new BinaryTreeNode(37);
        root.right.left.right.left=new BinaryTreeNode(29);
        root.right.left.right.left.right=new BinaryTreeNode(31);
        root.right.left.right.right=new BinaryTreeNode(41);
        root.right.right=new BinaryTreeNode(47);
        root.right.right=new BinaryTreeNode(53);
        System.out.println(isBinaryTreeBST(root) )  ;
       // preorder(root);
    }
}
  class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left, right;

      BinaryTreeNode(T data){
          this.data=data;
      }
}