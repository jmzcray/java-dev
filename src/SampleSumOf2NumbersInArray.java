/**
 * Created by au_j on 24/10/2016.
 */

import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

public class SampleSumOf2NumbersInArray {

    /*
     * Complete the function below.
     */

    static int numberOfPairs(int[] a, long k) {


    }

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;

        int _a_size = 0;
        _a_size = Integer.parseInt(in.nextLine().trim());
        int[] _a = new int[_a_size];
        int _a_item;
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(in.nextLine().trim());
            _a[_a_i] = _a_item;
        }

        long _k;
        _k = Long.parseLong(in.nextLine().trim());

        res = numberOfPairs(_a, _k);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }
}