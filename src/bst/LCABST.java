package bst;

import binaryTrees.BinaryTreeNode;

public class LCABST {
    /*public static BSTNode<Integer> findLCA(BSTNode<Integer> tree,
                                           BSTNode<Integer> s,
                                           BSTNode<Integer> b) {
        BSTNode<Integer> p=tree;
      // if(p==null) return null;
        while (p!=null &&( s.data > p.data  || b.data < p.data) ) {
// Keep searching since p is outside of [s , b].
            while (p!=null && p.data < s.data) {
                p = p.right; // LCA must be in p’s right child.
            }
            while (p!=null && p.data > b.data) {
                p= p.left;;

// LCA must be in p’s left child.
            }
        }
// Now, s.data >= p.data && p.data <- b.data.
        return p;
    }*/

    private static BSTNode findLCA(BSTNode<Integer> tree,
                        BSTNode<Integer> s,
                        BSTNode<Integer> b){
        if(tree==null) return null;
        while(tree.data>Integer.max(s.data,b.data)){
            tree=tree.left;
        }
        while(tree.data<Integer.min(s.data,b.data)){
            tree=tree.right;
        }
        return tree;
    }

    public static void main(String[] args) {
        BSTNode root=new BSTNode(23);
        root.left=new BSTNode(12);
        root.right=new BSTNode(25);
        root.right.left=new BSTNode(24);
        root.right.right=new BSTNode(28);
        root.left.left=new BSTNode(11);
        root.left.right=new BSTNode(14);
        final BSTNode lca = findLCA(root,  root.left.left,root.left);
        System.out.println(lca.data);
    }
}