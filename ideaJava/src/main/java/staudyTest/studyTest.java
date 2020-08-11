package staudyTest;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class studyTest{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            long num = sc.nextLong();
            int[] arr = s(num);

            for(int i = 0; i < arr.length && arr[i] != 0; i++){
                System.out.print(arr[i]+" ");
            }

        }

    }
    public static int[] s(long num){
        long temp = num;
        int[] arr = new int[10000];
        int index = 0;
        for (int i = 2; num > 1 && i<temp ;){
            if (num % i==0){
                num = num / i;
                arr[index++] = i;
            }
            else {
                i++;
            }

        }
        return arr;
    }


}
