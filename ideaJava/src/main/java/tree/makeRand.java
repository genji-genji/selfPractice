package tree;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class makeRand {
    public static void main(String[] args){
        rand(100);

    }
    public static void rand(int Max){

        Random random = new Random();
        Set<Integer> set = new LinkedHashSet<Integer>();
        File file = new File("rand.txt");
        try {

            if (!file.exists()){
                file.createNewFile();
            }

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("rand.txt"),"UTF-8"));

        for (int i = 0; i < Max; i++){
            set.add(random.nextInt(100));
        }
        for (int i : set){
            bufferedWriter.write(i+"");
            bufferedWriter.newLine();
        }
        bufferedWriter.close();



        }catch (Exception e){
            System.out.println(e);
        }


    }
}
