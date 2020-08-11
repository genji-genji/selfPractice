package staudyTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PoolThreadTest {
    public static void main(String[] args){
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(3,5,30
                , TimeUnit.SECONDS
                , new ArrayBlockingQueue<Runnable>(8));
        ThreadPoolExecutor threadPoolExecutor_2=new ThreadPoolExecutor(3,5,30
                , TimeUnit.SECONDS
                , new ArrayBlockingQueue<Runnable>(8));


        for (int i = 0; i < 100;i++){
            threadPoolExecutor.execute(new Thread_1(Integer.toString(i)));
            threadPoolExecutor_2.execute(new MyThread());
            System.out.println("now :"+i);
        }
    }


}
class Thread_1 implements Runnable{

    private String name;

    public Thread_1(String name){
        this.name=name;
    }

    @Override
    public void run(){
        System.out.println(name);
    }

}
