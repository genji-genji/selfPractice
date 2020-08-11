package staudyTest;

import java.io.UnsupportedEncodingException;
import java.rmi.StubNotFoundException;

class AutoUnboxingTest {

    private static int a;
    private int b;

    static class gogogo{
        public void test(){
            System.out.println(a);
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        Integer a = new Integer(3);
        Integer b = 3;                  // 将3自动装箱成Integer类型
        int c = 3;
        System.out.println(a == b);     // false 两个引用没有引用同一对象
        System.out.println(a == c);     // true a自动拆箱成int类型再和c比较
        byte[] bytes= "str".getBytes();
        String string=new String("中".getBytes("ISO-8859-1"),"UTF-8");
        for (byte b1 : bytes){
            System.out.println(b1);
        }
        System.out.println(string);


    }
}
class NormalTest{
    public static void main(String[] args){
        int a=1;
        int b=2;
        int c=a;
        System.out.println(a+" "+b+" "+c);
        c=5;
        System.out.println(a+" "+b+" "+c);

        Student student1=new Student();
        student1.setNum(3);

        Student student2 = student1;

        System.out.println(student2==student1);

        student2.setNum(4);

        System.out.println(student1.getNum()+" "+student2.getNum());

        studentAdd(student2);

        System.out.println(student1.getNum()+" "+student2.getNum());



    }

    public static void studentAdd (Student student){
        student.setNum(student.getNum()+1);
    }
}

class Student{
    private int num;
    public Student(){};
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }




}
