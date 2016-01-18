/**
 * Created by Jimz on 19/01/2016.
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
        while (arr[minIndex] < arr[arr.length-1]) {
            int count=0;
            for (int i=minIndex; i<arr.length; i++){
                if (arr[i] >= min) {
                    count++;
                    arr[i] -= min;
                }
                if (arr[i] < min && arr[i] > 0)
                    minIndex=i;
            }
            min = arr[minIndex];
            System.out.println(count);
        }
    }
}