/**
 * Created by au_j on 28/09/2016.
 */

/*
 Sameple input:
 |name|address|~n|Patrick|patrick@test.com|pat@test.com|~n|Annie|annie@test.com|~n|Zoe|~n

 output:
 number of records, number of fields, number of empty values, name of the last field

 expected:
 2:3:1:address_1
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class SampleDataValidation {

/*
 * Complete the function below.
 */

    static String validate(String input) {

        if (input.matches("\\A\\p{ASCII}*\\z")) {


            return "";
        } else {
            return "|name|address|~n|Patrick|patrick@test.com|pat@test.com|~n|Annie|annie@test.com|~n|Zoe|~n";
        }
    }

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
//        final String fileName = System.getenv("OUTPUT_PATH");
//        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

        res = validate(_input);
//        bw.write(res);
//        bw.newLine();
        System.out.println(res);
//        bw.close();
    }

}
