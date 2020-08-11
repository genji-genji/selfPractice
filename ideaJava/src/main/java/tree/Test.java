package tree;

import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        BlanceTree<Integer> blanceTree = new BlanceTree<Integer>();
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while(!sc.hasNext("&")){

            blanceTree.add(sc.nextInt());
        }
        blanceTree.recursionMid();
        sc.next();
        blanceTree.delete(sc.nextInt());
        blanceTree.recursionMid();



    }
}
