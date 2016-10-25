/**
 * Created by au_j on 24/10/2016.
 */

import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

public class SampleAbsolutePrimes {

    /*
     * Complete the function below.
     */

    static int findLargestAbsolutePrimeInRange(int maximum) {

        return 0;
    }

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
        int _maximum;
        _maximum = Integer.parseInt(in.nextLine().trim());

        res = findLargestAbsolutePrimeInRange(_maximum);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }
}