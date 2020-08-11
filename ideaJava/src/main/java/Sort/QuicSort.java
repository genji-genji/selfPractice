package Sort;

public class QuicSort {
    public static void main(String args[]){

        int[] a={5,8,9,1,6,8,11,3,4};
        QuicSort t=new QuicSort();
        t.sort(a,0,a.length-1);
        for (int i=0;i < a.length;i++){
            System.out.println(a[i]);
        }
        System.out.println(a);

    }

    public void sort(int[] a,int l,int r){

        if (l>=r){
            return;
        }

        int temp;
        int jage=0;
        int mid=0;
        int i=l;
        int j=r;

        while (i<=j){
            if (a[i]>a[j]){
                temp=a[i];
                a[i]=a[j];
                a[j]=temp;
                jage++;
            }
//            只存在两种模式 尾部为基准的首部下标增加 和 首部为基准的 尾部下标减少
            jage=jage%2;

            if (i==j){
                mid=i;
            }

            if (jage==0){
               j--;
            }
            else if (jage==1){
              i++;
            }
        }
        sort(a,l,mid-1);
        sort(a,mid+1,r);


    }

}


