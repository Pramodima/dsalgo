package bst;

public  class BSTNode<T> {
    public T data;
    public BSTNode<T> left, right;

    public BSTNode(T data){
        this.data=data;
    }
    public BSTNode(T data, BSTNode<T> left, BSTNode<T> right) {
        this.data=data;
        this.left=left;
        this.right=right;
    }
}
