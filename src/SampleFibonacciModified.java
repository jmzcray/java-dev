/**
 * Created by d329312 on 2/03/2016.
 *
 * https://www.hackerrank.com/challenges/fibonacci-modified
 */

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class SampleFibonacciModified {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger a = BigInteger.valueOf(in.nextInt());
        BigInteger b = BigInteger.valueOf(in.nextInt());
        int n = in.nextInt();

        BigInteger result = b;
        for (int i=3; i<=n; i++){
            result = b.multiply(b).add(a);
            a = b;
            b = result;
        }

        System.out.println( result );
    }
}