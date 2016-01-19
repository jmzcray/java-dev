/**
 * Created by Jimz on 19/01/2016.
 *
 * https://www.hackerrank.com/challenges/cut-the-sticks
 *
 * You are given N sticks, where the length of each stick is a positive integer. A cut operation is performed on the sticks such that all of them are reduced by the length of the smallest stick.
 *
 * Suppose we have six sticks of the following lengths:
 * 5 4 4 2 2 8
 *
 * Then, in one cut operation we make a cut of length 2 from each of the six sticks. For the next cut operation four sticks are left (of non-zero length), whose lengths are the following:
 * 3 2 2 6
 *
 * The above step is repeated until no sticks are left.
 *
 * Sample input:
 6
 5 4 4 2 2 8
 *
 * Sample output:
 6
 4
 2
 1
 *
 *
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SampleCutTheStick {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }

        Arrays.sort(arr);
        int min = arr[0], minIndex=0;
        while (minIndex >= 0 && arr[minIndex] <= arr[arr.length-1] ) {
            int count=0;
            for (int i=minIndex; i<arr.length; i++){
                if (arr[i] >= min) {
                    count++;
                    arr[i] -= min;
                }
                if (arr[i] <= 0)
                    minIndex = -1;
                else if (minIndex < 0 && arr[i] > 0){
                    minIndex = i;
                }
            }
            if (minIndex >= 0)
                min = arr[minIndex];
            System.out.println(count);
        }
    }
}