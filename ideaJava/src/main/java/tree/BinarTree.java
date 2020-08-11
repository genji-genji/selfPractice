package tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;

public class BinarTree<T extends Comparable<T>>{
    private T data;
    private BinarTree<T> leftChild;
    private BinarTree<T> rightChild;
    private BinarTree<T> parent;
    private int high;

    public BinarTree(){
        this.data = null;
        high = 1;
    };

    public BinarTree(T data){
        this.data = data;
        high = 1;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinarTree<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinarTree<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinarTree<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinarTree<T> rightChild) {
        this.rightChild = rightChild;
    }

    public BinarTree<T> getParent() {
        return parent;
    }

    public void setParent(BinarTree<T> parent) {
        this.parent = parent;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }
}
