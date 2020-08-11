package tree;

import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

public class BlanceTree<T extends Comparable<T>> {
    private BinarTree<T> first;
    private T tempDate;

    public BlanceTree(){

        this.first=null;
        first = new BinarTree<T>();
    }

    public void add(T data){

        if (first.getData() == null){
            first.setData(data);
        }
        else {
            this.tempDate = data;
            add(first);
        }

    }

    protected void add(BinarTree<T> binarTree) {

        int compare;
//        树为空


        compare = tempDate.compareTo(binarTree.getData());
        //            若是data插入树存在等于data的值则不予插入
        if (compare == 0) return;

        if (compare == -1) {
            if (binarTree.getLeftChild() == null){
                binarTree.setLeftChild(new BinarTree<T>(tempDate));
                binarTree.getLeftChild().setParent(binarTree);
            }
            else {
                add(binarTree.getLeftChild());
            }

        } else if (compare == 1) {
            if (binarTree.getRightChild() == null){
                binarTree.setRightChild(new BinarTree<T>(tempDate));
                binarTree.getRightChild().setParent(binarTree);
            }
            else {
                add(binarTree.getRightChild());
            }
        }
//            更新树高
        updateHigh(binarTree);
        check(binarTree);


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

//    更新节点高度
    protected void updateHigh(BinarTree<T> binarTree){
        int left;
        int right;

        if (binarTree.getLeftChild() != null && binarTree.getRightChild() != null) {

            left = binarTree.getLeftChild().getHigh();
            right = binarTree.getRightChild().getHigh();
            binarTree.setHigh(left>right ? left + 1: right +1);

        }else if (binarTree.getLeftChild() != null ){

            left = binarTree.getLeftChild().getHigh();
            binarTree.setHigh(left+1);

        }else if (binarTree.getRightChild() != null){

            right = binarTree.getRightChild().getHigh();
            binarTree.setHigh(right+1);

        }
        else {
            binarTree.setHigh(1);
        }


    }
    protected int highLevel(BinarTree<T> binarTree){

        int high = 0;
        if (binarTree.getLeftChild() != null && binarTree.getRightChild() != null) {

          high = binarTree.getLeftChild().getHigh()-binarTree.getRightChild().getHigh();

        }else if (binarTree.getLeftChild() != null ){

            high = binarTree.getLeftChild().getHigh();

        }else if (binarTree.getRightChild() != null){

            high = -binarTree.getRightChild().getHigh();

        }
//        若没有子节点高度差自然为零
        return high;
    }
    //            检测是否需要旋转
    protected void check(BinarTree<T> binarTree){

        if (highLevel(binarTree) == 2){
            if (highLevel(binarTree.getLeftChild()) == 1){
                rRotation(binarTree);
            }
            else if (highLevel(binarTree.getLeftChild()) == -1){
                lRotation(binarTree.getLeftChild());
                rRotation(binarTree);

            }
        }else if (highLevel(binarTree) == -2){
            if (highLevel(binarTree.getRightChild()) == 1){

                rRotation(binarTree.getRightChild());
                lRotation(binarTree);

            }
            else if (highLevel(binarTree.getRightChild()) == -1){
                lRotation(binarTree);
            }
        }
    }
//    左旋
    /**需要重写**/
    protected void lRotation(BinarTree<T> binarTree) {
        BinarTree<T> temp = binarTree.getRightChild();
        BinarTree<T> temp_l = temp.getLeftChild();
        BinarTree<T> parent = binarTree.getParent();

        binarTree.setRightChild(temp_l);
        temp.setLeftChild(binarTree);
        binarTree.setParent(temp);
        if (temp_l != null){
            temp_l.setParent(binarTree);
        }
        if (parent != null){
            temp.setParent(parent);
            if (parent.getLeftChild() == binarTree){
                parent.setLeftChild(temp);
            }else if (parent.getRightChild() == binarTree){
                parent.setRightChild(temp);
            }
        }else {
            first = temp;
        }
        updateHigh(binarTree);
        updateHigh(temp);



    }
//    右旋
    protected void rRotation(BinarTree<T> binarTree){
        BinarTree<T> temp = binarTree.getLeftChild();
        BinarTree<T> temp_r = temp.getRightChild();
        BinarTree<T> parent = binarTree.getParent();


        binarTree.setLeftChild(temp_r);
        temp.setRightChild(binarTree);
        binarTree.setParent(temp);
        temp.setParent(parent);
        if (temp_r != null){
            temp_r.setParent(binarTree);
        }
        if (parent != null){
            temp.setParent(parent);
            if (parent.getLeftChild() == binarTree){
                parent.setLeftChild(temp);
            }else if (parent.getRightChild() == binarTree){
                parent.setRightChild(temp);
            }
        }else {
            first = temp;
        }
        updateHigh(binarTree);
        updateHigh(temp);



    }

    /**仅用于binartree不是叶子节点**/
    protected BinarTree<T> findPre(BinarTree<T> binarTree){
        BinarTree<T> pre = binarTree.getLeftChild();
        while (pre.getRightChild() != null){
            pre = pre.getRightChild();
        }
        return pre;
    }


    public void delete(T data){
        tempDate=data;
        delete(first);
    }
    /****/
    protected void delete (BinarTree<T> binarTree){
        BinarTree<T> l = binarTree.getLeftChild();
        BinarTree<T> r = binarTree.getRightChild();
        BinarTree<T> pre;
        BinarTree<T> pre_parent;
        BinarTree<T> parent = binarTree.getParent();

        T data = binarTree.getData();
        int compare = tempDate.compareTo(data);
        if (compare == 0){
            if ( r != null && l != null) {
//                找到前序节点
                pre = findPre(binarTree);
//                删除节点等价于节点获得前序节点的值并删除前序节点
                binarTree.setData(pre.getData());

                pre_parent=pre.getParent();
//                相当于删除了用于替换了的前序节点
                tempDate = pre.getData();
                delete(pre);

                while(pre_parent != binarTree){
                    updateHigh(pre_parent);
                    check(pre_parent);
                    pre_parent = pre_parent.getParent();
                }
                updateHigh(binarTree);
                check(binarTree);


            }
            else if (r == null && l != null){
                l.setParent(parent);
                if (parent.getLeftChild() == binarTree){
                    parent.setLeftChild(l);
                }else if (parent.getRightChild() == binarTree){
                    parent.setRightChild(l);
                }

            } else if (r != null && l == null){
                r.setParent(parent);
                if (parent.getLeftChild() == binarTree){
                    parent.setLeftChild(r);
                }else if (parent.getRightChild() == binarTree){
                    parent.setRightChild(r);
                }
            } else {
                if (parent.getLeftChild() == binarTree){
                    parent.setLeftChild(null);
                }else if (parent.getRightChild() == binarTree){
                    parent.setRightChild(null);
                }
            }
        } else if (compare == -1){
            if (l == null) {
                System.out.println(data+"不存在");
            }else {
                delete(l);
                updateHigh(binarTree);
                check(binarTree);
            }
        }else  if (compare == 1){
            if (r == null){
                System.out.println(data + "不存在");
            }
            else {
                delete(r);
                updateHigh(binarTree);
                check(binarTree);
            }
        }
    }


}
