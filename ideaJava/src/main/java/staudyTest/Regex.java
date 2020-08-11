package staudyTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args){
        String string="123654789fdsfsdf";
        String string2="4654654";
        String string3="sfsdfsdfsfdc";
        String regex= "\\d+";

        Pattern pattern=Pattern.compile(regex);

        Matcher matcher_1 = pattern.matcher(string);
        Matcher matcher_2 = pattern.matcher(string2);
        Matcher matcher_3 = pattern.matcher(string3);

        System.out.println(matcher_1.matches()+" "+string.matches(regex)+" "+string.replaceAll(regex,"x"));
        System.out.println(matcher_1.replaceAll("x"));
        System.out.println(matcher_1.matches()+" "+matcher_2.matches()+" "+matcher_3.matches());
        System.out.println(string);
        System.out.println('A'-'a');

    }
}
