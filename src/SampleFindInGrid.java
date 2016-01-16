/**
 * Created by Jimz on 17/01/2016.
 *
 * https://www.hackerrank.com/challenges/the-grid-search
 * Find the smaller grid inside a larger grid.
 *
 * Sample input (4x6 larger | 2x2 smaller):
 1
 4 6
 123412
 781288
 561212
 123634
 2 2
 12
 34
 *
 * Sample output:
 * YES
 *
 * Sample input (10x10 larger | 3x4 smaller):
 1
 10 10
 7283455864
 6731158619
 8988242643
 3830589324
 2229505813
 5633845374
 6473530293
 7053106601
 0834282956
 4607924137
 3 4
 9505
 3845
 3530
 *
 * Sample output:
 * YES
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SampleFindInGrid {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int R = in.nextInt();
            int C = in.nextInt();
            String G[] = new String[R];
            for(int G_i=0; G_i < R; G_i++){
                G[G_i] = in.next();
            }
            int r = in.nextInt();
            int c = in.nextInt();
            String P[] = new String[r];
            for(int P_i=0; P_i < r; P_i++){
                P[P_i] = in.next();
            }

            boolean found = false;
            String firstrow = P[0];
            search:
            for (int i=0; i<G.length; i++){
                if (G[i].contains(firstrow)){
                    List<Integer> list = new ArrayList<Integer>();
                    int loc = G[i].indexOf(firstrow);
                    while (loc>=0 ){ // storing all index of found strings in the row
                        list.add(loc);
                        loc = G[i].indexOf(firstrow, loc+1);
                    }
                    for (int y=1; y<P.length; y++) { // going through rows
                        for (int l : list) { // going through index
                            if (l>0 && (i+y)<R && (l+c-1)<C) { // making sure no exceptions thrown for index boundary
                                if (!P[y].equals(G[i + y].substring(l, l + c))) // if P[y](small grid) does not match G[i+y](big grid) at index(l)
                                    list.set(list.indexOf(l), -1); // remove index
                                else {
                                    if (y == r-1) { // if all strings found in small grid
                                        found = true;
                                        break search;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (found)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}