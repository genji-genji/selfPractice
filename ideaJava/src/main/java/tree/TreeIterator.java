package tree;

public class TreeIterator<T extends Comparable<T>> {
    private BinarTree<T> first;

    public TreeIterator(BinarTree<T> first){
        this.first = first;
    }

    public void recursionPre(){
        if (first != null) {
            recursionPre(first);
        }
    }
    public void recursionPre(BinarTree<T> Node){
        if (Node != null) {
            System.out.println(Node.getData());
            recursionPre(Node.getLeftChild());
            recursionPre(Node.getRightChild());
        }
    }

    public void recursionMid(){
        if (first != null) {
            recursionMid(first);
        }
    }
    public void recursionMid(BinarTree<T> Node){
        if (Node != null) {
            recursionMid(Node.getLeftChild());
            System.out.println(Node.getData());
            recursionMid(Node.getRightChild());
        }
    }
    public void recursionLast(){
        if (first != null) {
            recursionLast(first);
        }
    }
    public void recursionLast(BinarTree<T> Node){
    if (Node != null) {

        System.out.println(Node.getData());
        recursionLast(Node.getLeftChild());
        recursionLast(Node.getRightChild());
    }
}

}
