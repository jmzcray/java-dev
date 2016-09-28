/**
 * Created by au_j on 28/09/2016.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SampleRobot {

/*
 * Complete the function below.
 */

    static String compute(String instructions) {

        return "";
    }

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
//        final String fileName = System.getenv("OUTPUT_PATH");
//        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        String _instructions;
        try {
            _instructions = in.nextLine();
        } catch (Exception e) {
            _instructions = null;
        }

        res = compute(_instructions);
//        bw.write(res);
//        bw.newLine();
        System.out.println(res);
//        bw.close();
    }
}
