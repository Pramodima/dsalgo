package bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversalIterator {

    public void preorderIteratorV1(Node root) {
        Stack<Node> stack=new Stack<>();
        if (root == null)
            return;
        Node curr = root;
        while (true) {

            while (curr!=null) {
                System.out.println(curr.data);
                stack.push(curr);
                curr = curr.left;
            }
            if(stack.isEmpty()){
                break;
            }
            final Node r = stack.pop();
            curr = r.right;
        }
    }
    public void preorderIteratorV2(Node root) {
        Stack<Node> stack=new Stack<>();
        if (root == null)
            return;
        Node curr = root;
        stack.push(curr);
        while (!stack.isEmpty()) {
              curr = stack.pop();
            System.out.println(curr.data);
                if(curr.right!=null){
                 stack.push(curr.right);
               }
            if(curr.left!=null){
                stack.push(curr.left);
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

      preorder traversal:1 2 4 5  3
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
        PreorderTraversalIterator ii=new PreorderTraversalIterator();
        ii.preorderIteratorV2(root);

    }
}
