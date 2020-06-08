package binaryTrees;

import java.util.ArrayList;
import java.util.List;

/*Design an algorithm for reconstructing a binary tree from a postorder traversal visit
sequence that uses null to mark empty children.*/
public class BinaryTreeFromPostOrder {
        private static Integer subtreeldx;

        public static BinaryTreeNode<String> reconstructPreorder(List<String> postorder) {
            subtreeldx = postorder.size()-1;

            return reconstructPostorderSubtree(postorder);
        }

        // Reconstructs the subtree that is rooted at subtreeldx .
        private static BinaryTreeNode<String> reconstructPostorderSubtree(
                List<String> postorder) {
            String subtreeKey = postorder.get(subtreeldx);
            --subtreeldx;

            if (subtreeKey == null) {
                return null;
            }
            BinaryTreeNode<String> rightSubtree = reconstructPostorderSubtree(postorder);
            BinaryTreeNode<String> leftSubtree = reconstructPostorderSubtree(postorder);

            BinaryTreeNode bn=new BinaryTreeNode(subtreeKey, leftSubtree, rightSubtree);
            return bn;
        }
        private static void inorder(BinaryTreeNode root){
       /* if(root==null)
            return;*/
            if(root!=null)
                inorder(root.left);
            if(root!=null)
                System.out.print(root.data+" ");
            else
                System.out.print(root+" ");
            if(root!=null)
                inorder(root.right);
        }
        private static void postorder(BinaryTreeNode root){
       /* if(root==null)
            return;*/
            if(root!=null)
                postorder(root.left);

            if(root!=null)
                postorder(root.right);

            if(root!=null)
                System.out.print(root.data+" ");
            else
                System.out.print(root+" ");
        }
        public static void main(String[] args) {
            List<String> postOrder=new ArrayList<>();
            postOrder.add(null);postOrder.add(null);postOrder.add("F");postOrder.add(null);postOrder.add(null);
            postOrder.add("A");postOrder.add(null);postOrder.add("E");postOrder.add("B");postOrder.add(null);
            postOrder.add(null);postOrder.add(null);postOrder.add(null);postOrder.add("I");postOrder.add(null);postOrder.add("G");postOrder.add("D");
            postOrder.add("C");postOrder.add("H");

            final BinaryTreeNode<String> stringBinaryTreeNode = reconstructPreorder(postOrder);
             inorder(stringBinaryTreeNode);
            System.out.println();
            postorder(stringBinaryTreeNode);
        }
    }

