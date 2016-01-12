/**
 * Created by d329312 on 12/01/2016.
 *
 * Invalid:
 * The name of the start and end tag must be same.
 * <h1>Hello World</h2>
 *
 * Tag can be nested, but there will be no content in between the nested tags.
 * <h1><a>contents</a>invalid</h1>
 *
 *
 * Sample input:
 * 4
 * <h1>Nayeem loves counseling</h1>
 * <h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while<par>
 * <Amee>safat codes like a ninja</amee>
 * <SA premium>Imtiaz has a secret crush</SA premium>
 *
 * Sample output:
 * Nayeem loves counseling
 * Sanjay has no watch
 * So wait for a while
 * None
 * Imtiaz has a secret crush
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TagContentExtractor{
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String line = in.nextLine();

            Pattern ptag = Pattern.compile("<([a-zA-Z0-9][a-zA-Z0-9 ]*)>");
            Pattern pcontent = Pattern.compile("<[a-zA-Z0-9][a-zA-Z0-9 ]*>\\b(\\w+\\W+)\\b</[a-zA-Z0-9][a-zA-Z0-9 ]*>");

            Matcher mtag = ptag.matcher(line);

            boolean match = false;
            while (mtag.find()) {
                System.out.println(mtag.group(1));
                match = true;
            }

            if (!match)
                System.out.println("None");

            testCases--;
        }
    }
}
