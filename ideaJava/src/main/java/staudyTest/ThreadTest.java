package staudyTest;

import java.util.Collection;

public class ThreadTest {
    public static void main(String[] args)  {
        Thread thread =Thread.currentThread();

        System.out.println("thread name: "+thread);


        Thread thread_2 =new MyThread();
        thread_2.setPriority(4);
        thread_2.start();

        MyThread_2 thread_3 =new MyThread_2("first");
        MyThread_2 thread_4 =new MyThread_2("second");
        try {
            thread_3.setJoin(thread_4);
            thread_3.getThread().join();
            thread_4.getThread().join();
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("end Main"+Integer.SIZE);

    }
}

 class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5;i++){
            try {
                Thread.sleep(1000);

                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class MyThread_2 implements Runnable{

    private Thread thread;
    private Thread thread1;
    private String name;

    public MyThread_2(String name){
        this.name=name;
        thread=new Thread(this,name);
        System.out.println("Start: "+thread);
        thread.start();
    }
//join测试
    public void setJoin(Runnable T){
        try {
           MyThread_2 thread_2 =(MyThread_2) T;
            thread1 = thread_2.getThread();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 5;i++){
            if (this.thread1!=null){
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
                System.out.println(thread.getName()+":"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
}
