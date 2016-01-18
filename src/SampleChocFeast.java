/**
 * Created by d329312 on 18/01/2016.
 *
 * https://www.hackerrank.com/challenges/chocolate-feast/
 *
 * First input is the amount you have
 * Second input is the cost of a chocolate
 * Third input is the amount of wraps you can use to exchange for an extra chocolate
 *
 * GOAL: Find out how many chocolates you can get
 *
 * Sample input:
 4
 10 2 5
 12 4 4
 6 2 2
 43203 60 5
 *
 * Sample output:
 6
 3
 5
 899
 *
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SampleChocFeast {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int c = in.nextInt();
            int m = in.nextInt();

            int wrappers = n/c;
            int count = wrappers;
            while (wrappers >= m) {
                count = count + wrappers/m;
                wrappers = wrappers%m + wrappers/m;
            }
            System.out.println (count);
        }
    }

}
