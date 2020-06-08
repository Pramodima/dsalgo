package bst;

public class InorderSuccessorInBST {
    public Node findMin(Node node){
        if(node ==null) return null;
        while(node.left!=null){
            node=node.left;
        }
        return node;
    }
    public Node getInorderSuccessor(Node node,int data){
        if(node==null){
            return null;
        }
        Node successor=null;
        while (node!=null) {
            if (node.data < data) {
                node = node.right;
            } else if (node.data > data) {
                successor = node;
                node = node.left;
            } else {
                if (node.right != null) {
                    successor = findMin(node.right);
                }
                break;
            }
        }
     return successor;
    }
    public static void main(String args[])
    {

        /* creating a binary tree and entering
        the nodes
                  3
                /   \
                2     4
                /       \
               1         5


      inorder traversal:1 2 3 4 5
      Time Complexity: O(n)

     Memory Complexity: O(h)

     The iterative solution has O(h) memory complexity as it instantiates a stack that has to store
     information up to the height of binary tree h. It will be O(log n) for a balanced tree and can
     be O(n) in the worst case.
*/

        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(4);
        root.left.left = new Node(1);
        root.right.right = new Node(5);
       InorderSuccessorInBST is=new InorderSuccessorInBST();
        final Node inorderSuccessor = is.getInorderSuccessor(root, 5);
        if(inorderSuccessor!=null) {
            System.out.println(inorderSuccessor.data);
        }
        else{
            System.out.println("No inorder successor");
        }
    }
}
