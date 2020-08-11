package Sort;

public class HeapSort {
    public static void swap(int[] arr ,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void sort(int[] arr){

        bulidMaxHeap(arr);

        int len=arr.length-1;

        while(len>0){
            swap(arr,0,len);
            len--;
            maxHeap(arr,0,len);
        }


    }

    public static void bulidMaxHeap(int[] arr){

        int len = arr.length-1;

        for(int i=(len-1)/2;i>=0;i--) {
            maxHeap(arr,i,len);
        }

    }
    public static void maxHeap(int [] arr ,int i,int len){

        int first=i;

        for (int j = i*2+1;j<=len;j = j*2+1){

            if (j+1 <= len && arr[j]<arr[j+1]){
                j=j+1;
            }
            if (arr[j]>arr[first]){
                swap(arr,j,first);
                first=j;
            }
//            证明下方已经没有需要交换的值
            else {
                break;
            }

        }

    }

}
