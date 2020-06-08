package bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversalIterator {

    public List<Integer> postorderTraversalV1(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        if(root == null) return list;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            root = stack.pop();
            list.addFirst( root.data);
            if(root.left != null) stack.push(root.left);
            if(root.right != null) stack.push(root.right);
        }
        return list;
    }
    public List<Integer> postorderTraversalV2(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            root = stack.pop();
            list.add(0, root.data);
            if(root.left != null) stack.push(root.left);
            if(root.right != null) stack.push(root.right);
        }
        return list;
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

      postorder traversal:4 5 2 3 1
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
        PostOrderTraversalIterator ii=new PostOrderTraversalIterator();
        final List<Integer> list = ii.postorderTraversalV2(root);
        System.out.println(list);

    }
}
