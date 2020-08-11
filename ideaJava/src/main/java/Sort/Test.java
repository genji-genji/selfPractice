package Sort;

import java.util.*;

public class Test {
    public static void main(String args[]){
        int[] a={1,8,9,5,6,8,11,3,4};


       HeapSort.sort(a);
        for (int i=0;i < a.length;i++){
            System.out.println(a[i]);
        }
        System.out.println(a);
    }

}
class CollectionTest{
    public static void main(String args[]){
        int[] a={1,8,9,5,6,8,11,3,4};

//        检验底层实现区别
        List<Integer> list=new ArrayList<Integer>();
        Set<Integer> hashSet= new HashSet<Integer>();
        Set<Integer> linkHashSet= new LinkedHashSet<Integer>();
        Set<Integer> treeSet = new TreeSet<Integer>();


        for (int i:a){
            list.add(i);
            hashSet.add(i);
            linkHashSet.add(i);
            treeSet.add(i);
    }
//        测试迭代原理
        Iterator<Integer> iterable_1 = list.iterator();
        Iterator<Integer> iterator_2 = hashSet.iterator();
        Iterator<Integer> iterator_3 = linkHashSet.iterator();
        Iterator<Integer> iterator_4 = treeSet.iterator();
        ListIterator<Integer> iterator_5= list.listIterator();



//        快速失败和安全失败
        List<Integer> listTest1 = new ArrayList<Integer>(list);
        List<Integer> listTest2 = new ArrayList<Integer>(list);
        int num=0;
        for (int i:listTest1){
            System.out.println(i);
            listTest1.set(num,0);
            num++;
        }
        for (int i = 0;i < listTest2.size();i++){
            System.out.println(listTest2.get(i));
        }



        System.out.println(list+" "+ hashSet+" "+linkHashSet+" "+treeSet+"\n");

        while(iterable_1.hasNext()){
            System.out.println(iterable_1.next());
        }
        while(iterator_2.hasNext()){
            System.out.println(iterator_2.next());
        }
        while(iterator_3.hasNext()){
            System.out.println(iterator_3.next());
        }
        while(iterator_4.hasNext()){
            System.out.println(iterator_4.next());
        }

    }

    class TestCollectionSafe implements Runnable {

        @Override
        public void run() {

        }
    }
}
