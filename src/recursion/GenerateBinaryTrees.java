package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryTrees {
  public static List<BinaryTreeNode<Integer>> generateBinaryTrees(Integer nosOfElements){
 List<BinaryTreeNode<Integer>> result=new ArrayList<>();
 if(nosOfElements==0){
     result.add(null);
 }
 for (int leftSubtree=0;leftSubtree<nosOfElements;leftSubtree++){
     int rightSubTree=nosOfElements-1-leftSubtree;
     List<BinaryTreeNode<Integer>> leftSubTrees = generateBinaryTrees(leftSubtree);
     List<BinaryTreeNode<Integer>> rightSubTrees = generateBinaryTrees(rightSubTree);
     for(BinaryTreeNode<Integer> left:leftSubTrees){
         for(BinaryTreeNode<Integer> right:rightSubTrees){
        result.add(new BinaryTreeNode<>(0,left,right));
         }
     }
 }
 return result;
  }


    public static void main(String[] args) {
      List<Integer> elements=new ArrayList<>();
        elements.add(1);
        elements.add(2);
        elements.add(3);
        System.out.println(generateBinaryTrees(3));
    }
}
class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left, right;

    BinaryTreeNode(T data){
        this.data=data;
    }

    public BinaryTreeNode(T i, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.data=i;
        this.left=left;
        this.right=right;
    }
}