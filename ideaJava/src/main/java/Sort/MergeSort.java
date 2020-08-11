package Sort;

import java.util.List;

public class MergeSort {
    public static void mergeSort(int[] arr ,int left,int right){

        if (left<right) {

            int mid = (left + right) / 2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);

        }
    }

    public static void merge(int[] arr,int l,int mid,int r){
        int lf=l;
        int tempI=l;
        int rf=mid+1;
        int[] temp=new int[arr.length];

        while (lf<=mid&&rf<=r){
            if (arr[lf]>arr[rf]){
                temp[tempI++]=arr[rf++];
            }else{
                temp[tempI++]=arr[lf++];
            }
        }

        while(lf<=mid){
            temp[tempI++]=arr[lf++];
        }
        while (rf<=r){
            temp[tempI++]=arr[rf++];
        }

        for (int i=l;i<=r;i++){
            arr[i]=temp[i];
        }
    }
    public static void mergeSort(List<Integer> arr ,int left,int right){

        if (left<right) {

            int mid = (left + right) / 2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);

        }
    }

    public static void merge(List<Integer> arr, int l, int mid, int r){
        int lf=l;
        int tempI=l;
        int rf=mid+1;
        int[] temp=new int[arr.size()];

        while (lf<=mid&&rf<=r){
            if (arr.get(lf)>arr.get(rf)){
                temp[tempI++]=arr.get(rf++);
            }else{
                temp[tempI++]=arr.get(lf++);
            }
        }

        while(lf<=mid){
            temp[tempI++]=arr.get(lf++);
        }
        while (rf<=r){
            temp[tempI++]=arr.get(rf++);
        }

        for (int i=l;i<=r;i++){
            arr.set(i,temp[i]);
        }
    }
}
