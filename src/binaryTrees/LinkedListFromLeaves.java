package binaryTrees;

import java.util.LinkedList;
import java.util.List;

/*FORM A LINKED LIST FROM THE LEAVES OF A
BINARY TREE*/
public class LinkedListFromLeaves {

    Node root;

    // Returns sum of all root to leaf paths. The first parameter is
    // root of current subtree, the second parameter is value of the
    // number formed by nodes from root to this node

   static List<Integer> leafList=new LinkedList<>();
    void treePathsSumUtil(Node node)
    {
        if(node==null)
            return;
        // if current node is leaf, return the current value of val
        if (node.left == null && node.right == null)
            leafList.add(node.data);

        // recur sum of values for left and right subtree
        treePathsSumUtil(node.left);
        treePathsSumUtil(node.right);
    }

    // A wrapper function over treePathsSumUtil()
    void treePathsSum(Node node)
    {
        // Pass the initial value as 0 as there is nothing above root
        treePathsSumUtil(node);
    }

    // Driver program to test above functions
    public static void main(String args[])
    {
        LeavesOfaBinaryTree tree = new LeavesOfaBinaryTree();
        tree.root = new Node(6);
        tree.root.left = new Node(3);
        tree.root.right = new Node(5);
        tree.root.right.right = new Node(4);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(4);
        tree.root.left.right.left = new Node(7);


        tree.treePathsSum(tree.root);
        System.out.println(leafList);
    }
}
