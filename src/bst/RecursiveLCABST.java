package bst;

public class RecursiveLCABST {

    private static BSTNode findLCA(BSTNode<Integer> tree,BSTNode<Integer> s,BSTNode<Integer> b){
        if(tree==null) return null;
        if(tree.data>Integer.max(s.data,b.data)){
            tree=tree.left;
            findLCA(tree,s,b)  ;
        }
        if(tree.data<Integer.min(s.data,b.data)){
            tree=tree.right;
            findLCA(tree,s,b)  ;
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
        final BSTNode lca = findLCA(root,  root.left.left,root.left.right);
        System.out.println(lca.data);
    }
}
