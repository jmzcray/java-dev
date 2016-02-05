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
 *
 * Sample output:
 3 4 8 12
 2 11 10 16
 1 7 6 15
 5 9 13 14
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class SampleMatrixRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();
        int rotate = in.nextInt();

        int[][] arr = new int[rows][cols];
        int[][] result = new int[rows][cols];

        for (int r=0; r<rows; r++){
            for (int c=0; c<cols; c++){
                arr[r][c] = in.nextInt();
            }

        }

        rows--;
        cols--;
        for (int r=0; r<=rows; r++) {
            for (int c=0; c<=cols; c++) {
                int x = (r < rows - r )? r : rows - r;
                int y = (c < cols - c )? c : cols - c;
                int min = (x < y )? x : y;
                int maxRow = rows - min;
                int maxCol = cols - min;
                int diameter = (maxRow + maxCol) * 2 - min * 4;

                int row = r;
                int col = c;
                for (int a = 0; a < rotate%diameter; a++) {
                    if (col == min && row < maxRow) {
                        row++;
                    }
                    else if (row == maxRow && col < maxCol) {
                        col++;
                    }
                    else if (row > min && col == maxCol) {
                        row--;
                    }
                    else if (row == min && col > min) {
                        col--;
                    }
                }
                result[row][col] = arr[r][c];
            }
        }

        for (int r = 0; r <= rows; r++) {
            for (int c = 0; c <= cols; c++) {
                System.out.print(result[r][c] + " ");
            }
            System.out.println();
        }


/* My failed attempt */
//        if (rotate%(((row*2)+(col*2))-4) > 0)
//            rotate = rotate%(((row*2)+(col*2))-4);
//        System.out.println("diameter: " + (((row*2)+(col*2))-4));
//        System.out.println("rotate: " + rotate);

//        List<List<Integer>> matrix = new ArrayList<List<Integer>>();
//        for (int r=0; r<row; r++){
//            List<Integer> matrixcol = new ArrayList<Integer>();
//            for (int c=0; c<col; c++) {
//                matrixcol.add(in.nextInt());
//            }
//            matrix.add(matrixcol);
//        }
    }

}