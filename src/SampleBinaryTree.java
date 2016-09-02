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

        treeNode rootNode = new treeNode(scores[0]);

        for (int i=1; i<scores.length; i++) {
            massageTree(rootNode, scores[i]);
        }

        String output = rootNode.value + ":" + rootNode.count + "," + printTree(rootNode);
        return output.substring(0,output.length()-1);
    }

    public static class treeNode {
        treeNode left;
        treeNode right;
        int count;
        int value;

        //constructor
        public treeNode(int a) {
            value = a;
            count = 1;
        }
    }

    private static treeNode massageTree(treeNode currentNode, int value) {
        if (currentNode.value > value) {
            if (currentNode.left == null) {
                treeNode newNode = new treeNode(value);
                currentNode.left = newNode;
                return newNode;
            } else {
                return massageTree(currentNode.left, value);
            }
        } else if (currentNode.value < value) {
            if (currentNode.right == null) {
                treeNode newNode = new treeNode(value);
                currentNode.right = newNode;
                return newNode;
            } else {
                return massageTree(currentNode.right, value);
            }
        } else {
            currentNode.count++;
            return currentNode;
        }
    }

    private static String printTree (treeNode node) {
        if (node.left == null && node.right == null) {
            return "";
        } else {
            String output = "";
            if (node.left != null) {
                output += node.left.value + ":" + node.left.count;
            }
            output += ",";
            if (node.right != null) {
                output += node.right.value + ":" + node.right.count;
            }
            output += ",";

            if (node.left != null) {
                output += printTree(node.left);
            }
            if (node.right !=null) {
                output += printTree(node.right);
            }
            return output;
        }
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




