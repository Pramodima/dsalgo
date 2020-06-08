package bst;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderIteraive {
    public void getLevelOrderTraversal(Node root){
        if(root==null) return;
        Queue<Node> queue=new ArrayDeque<>();
        queue.add(root);
        Node dummyNode=new Node(-1);
        while(!queue.isEmpty()) {
            final Node node = queue.poll();
            if (node.data!= -1) {
                System.out.println(node.data);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            else{
                queue.add(dummyNode);
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

     levelorder traversal:1 2 3 4 5
      Time Complexity: O(n)

     The memory complexity of this solution is linear, O(n).
Iterative solution has O(n)O(n)O(n) memory complexity as it instantiates queues that can take space upto n/2n/2n/2 nodes.

*/

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        LevelOrderIteraive li=new LevelOrderIteraive();
        li.getLevelOrderTraversal(root);

    }

}
