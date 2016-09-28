/**
 * Created by au_j on 28/09/2016.
 */

/*
input: 7
output: a0

input: 7792875
output: atlassian
 */


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class SampleBaseAtlassian {

/*
 * Complete the function below.
 */

    static String convert(long input) {

        String result = "";
        String inputStr = Long.toString(input, 7);
        for (int i = 0; i < inputStr.length(); i++) {
            result = result + base7Map(Character.digit(inputStr.charAt(i), 10));
        }
        return result;
    }

    private static String base7Map(int value) {
        switch(value) {
            case 1 :
                return "a";
            case 2 :
                return "t";
            case 3 :
                return "l";
            case 4 :
                return "s";
            case 5 :
                return "i";
            case 6 :
                return "n";
            default :
                return "0";
        }
    }

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
//        final String fileName = System.getenv("OUTPUT_PATH");
//        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        long _in;
        _in = Long.parseLong(in.nextLine());

        res = convert(_in);
//        bw.write(res);
//        bw.newLine();
        System.out.println(res);
//        bw.close();
    }
}
