package Math;

import java.util.Scanner;

public class prime {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num;
        int[] arr;

        while(sc.hasNext()) {
            num = sc.nextInt();
            arr = s(num);

            for (int i = 0; i < arr.length && arr[i] != 0; i++) {
                System.out.println(arr[i]);
            }
        }
    }

    public static int[] s(int num){
        int index=0;
        boolean jage;
        int[] back = new int[num];
        for(int i = 2;i <= num ;i++){
            jage =false;
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i%j==0){
                    jage=true;
                }
            }
            if(!jage){
                back[index++]=i;
            }
        }
        return back;
    }
}
