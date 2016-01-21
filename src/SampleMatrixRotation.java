/**
 * Created by d329312 on 20/01/2016.
 *
 * https://www.hackerrank.com/challenges/matrix-rotation-algo
 *
 * Sample input:
 4 4 2
 1 2 3 4
 5 6 7 8
 9 10 11 12
 13 14 15 16
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class SampleMatrixRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        int rotate = in.nextInt();

        if (rotate%(((row*2)+(col*2))-4) > 0)
            rotate = rotate%(((row*2)+(col*2))-4);

        System.out.println("diameter: " + (((row*2)+(col*2))-4));
        System.out.println("rotate: " + rotate);

        //ArrayList[][] matrix = new ArrayList[row][col];
        List<List<Integer>> matrix = new ArrayList<List<Integer>>();
        for (int r=0; r<row; r++){
            List<Integer> matrixcol = new ArrayList<Integer>();
            for (int c=0; c<col; c++) {
                matrixcol.add(in.nextInt());
            }
            matrix.add(matrixcol);
        }

    }
}