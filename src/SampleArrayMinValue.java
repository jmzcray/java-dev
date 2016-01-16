/**
 * Created by Jimz on 16/01/2016.
 *
 *
 * Sample input:
 8 5
 2 3 1 2 3 2 3 3
 0 3
 4 6
 6 7
 3 5
 0 7
 *
 * Sample output:
 1
 2
 3
 2
 1
 *--------------------------
 * Sample input:
 5 5
 1 2 2 2 1
 2 3
 1 4
 2 4
 2 4
 2 3
 *
 * Sample output:
 2
 1
 1
 1
 2
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SampleArrayMinValue {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int width[] = new int[n];
        for(int width_i=0; width_i < n; width_i++){
            width[width_i] = in.nextInt();
        }
        for(int a0 = 0; a0 < t; a0++){
            int i = in.nextInt();
            int j = in.nextInt();

            // This solution is slower than the uncommented solution below
            // int path[] = Arrays.copyOfRange(width, i, j+1);
            // Arrays.sort(path);
            // System.out.println(path[0]);

            int min=width[i];
            for (int x=i+1; x<=j; x++){
                if (min > width[x])
                    min = width[x];
            }
            System.out.println(min);
        }
    }
}