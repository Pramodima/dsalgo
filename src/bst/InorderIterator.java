package bst;



// non-recursive java program for inorder traversal
import java.util.Stack;

/* Class containing left and right child of
current node and key value*/


public class InorderIterator {
    Stack<Node> stack = new Stack<Node>();
    private boolean hasNext(){
      return !stack.empty();
    }
    private Node next(){
        Node temp;
        if(stack==null)
            return null ;
        Node node = stack.pop();

        temp = node.right;
        doInorderSetUp(temp);
        return node;
    }
    void doInorderSetUp(Node root)
    {
        if (root == null)
            return;

        Node curr = root;

        // traverse the tree
        while (curr != null )
        {
            /* Reach the left most Node of the
            curr Node */
            while (curr !=  null)
            {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
                stack.push(curr);
                curr = curr.left;
            }
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
        iterateTree(root);

    }

    private static void iterateTree(Node root) {
        InorderIterator in=new InorderIterator();
        in.doInorderSetUp(root);
        if(root!=null){
            while(in.hasNext()){
                System.out.println(in.next().data);
            }


      }
    }
}
