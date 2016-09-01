/**
 * Created by Jimz on 01/09/2016.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SampleBinaryTree {

    /*
     * Complete the function below.
     */

    static String gatherScores(int[] scores) {

        int treeDepth = scores.length / 2;

        int[][] tree = new int[treeDepth][(int) Math.sqrt(scores.length)+1];
        for (int i=0; i<scores.length; i++) {
            int treeLength = (int) Math.ceil(Math.sqrt(i+1));
            for (int y=0; y<treeLength; y++) {
                i = i+y;
                tree[i][y] = scores[i];
            }
        }

        return "";
    }


    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        //BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;

        int _scores_size = 0;
        _scores_size = Integer.parseInt(in.nextLine());
        int[] _scores = new int[_scores_size];
        int _scores_item;
        for(int _scores_i = 0; _scores_i < _scores_size; _scores_i++) {
            _scores_item = Integer.parseInt(in.nextLine());
            _scores[_scores_i] = _scores_item;
        }

        res = gatherScores(_scores);
        //bw.write(res);
        //bw.newLine();
        System.out.println(res);
        //bw.close();
    }
}




