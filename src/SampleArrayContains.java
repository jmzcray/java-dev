/**
 * Created by james on 6/01/2017.
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;

public class SampleArrayContains {

    public static String[] inArray(String[] array1, String[] array2) {
        Set<String> resultSet = new TreeSet<String>();

        for (int i=0; i<array1.length; i++) {
            for (int y=0; y<array2.length; y++) {
                if (array2[y].contains(array1[i])) {
                    resultSet.add(array1[i]);
                    break;
                }
            }
        }

        return resultSet.toArray(new String[resultSet.size()]);
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String[] a = in.nextLine().split(" ");
        String[] b = in.nextLine().split(" ");

        System.out.println( Arrays.toString(inArray(a, b)) );
    }
}
