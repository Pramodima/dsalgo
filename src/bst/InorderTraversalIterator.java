package bst;



// non-recursive java program for inorder traversal
import java.util.Stack;

/* Class containing left and right child of
current node and key value*/
class Node
{
    int data;
    Node left, right;

    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}



public class InorderTraversalIterator {
    void inorder(Node root)
    {
        if (root == null)
            return;


        Stack<Node> s = new Stack<Node>();
        Node curr = root;

        // traverse the tree
        while (curr != null || s.size() > 0)
        {

            /* Reach the left most Node of the
            curr Node */
            while (curr !=  null)
            {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
                s.push(curr);
                curr = curr.left;
            }

            /* Current must be NULL at this point */
            curr = s.pop();

            System.out.print(curr.data + " ");

            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
            curr = curr.right;
        }
    }
    public static void main(String args[])
    {

        /* creating a binary tree and entering
        the nodes
                  1
                /   \
                2      3
               /  \
              4     5

      inorder traversal:4 ,2, 5, 1, 3
      Time Complexity: O(n)

     Memory Complexity: O(h)

     The iterative solution has O(h) memory complexity as it instantiates a stack that has to store
     information up to the height of binary tree h. It will be O(log n) for a balanced tree and can
     be O(n) in the worst case.
*/

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        InorderTraversalIterator ii=new InorderTraversalIterator();
        ii.inorder(root);
    }
}
