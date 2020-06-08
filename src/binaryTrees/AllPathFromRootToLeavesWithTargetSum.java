package binaryTrees;

public class AllPathFromRootToLeavesWithTargetSum {

    // Java program to find sum of all numbers that are formed from root
// to leaf paths

    // A binary tree node



    Node root;

    // Returns sum of all root to leaf paths. The first parameter is
    // root of current subtree, the second parameter is value of the
    // number formed by nodes from root to this node
    void treePathsSumUtil(Node node,int[] path, int val,int pathLength,int target)
    {
        // Base case
        if (node == null)
            return ;

        // Update val
        val = (val * 10 + node.data);
        path[pathLength++]=node.data;

        // if current node is leaf, return the current value of val
        if (node.left == null && node.right == null && val==target) {
            printArray(path, pathLength);
        }
        // recur sum of values for left and right subtree
         treePathsSumUtil(node.left,path,val,pathLength ,target);
         treePathsSumUtil(node.right,path, val,pathLength,target);
    }

    private void printArray(int[] path,int len) {

        int i;
        for (i = 0; i < len; i++)
        {
            System.out.print(path[i] + " ");
        }
        System.out.println("");
    }

    // A wrapper function over treePathsSumUtil()
    void treePathsSum(Node node)
    {
        // Pass the initial value as 0 as there is nothing above root
        int[] a=new int[100];
         treePathsSumUtil(node, a,0,0,632);
    }

    // Driver program to test above functions
    public static void main(String args[])
    {
        AllPathFromRootToLeavesWithTargetSum tree = new AllPathFromRootToLeavesWithTargetSum();
        tree.root = new Node(6);
        tree.root.left = new Node(3);
        tree.root.right = new Node(3);
           tree.root.right.right = new Node(2);
            tree.root.left.left = new Node(2);
            tree.root.left.right = new Node(5);
            tree.root.left.right.right = new Node(4);
            tree.root.left.right.left = new Node(7);


                tree.treePathsSum(tree.root);
    }


// This code has been contributed by Mayank Jaiswal

}
