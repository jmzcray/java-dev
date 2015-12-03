import java.io.*;
import java.util.*;

public class SamplePrintStairs {
    public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();

        if (height > 0) {
            for (int i = 1; i <= height; i++) {
                for (int y = height; y > 0; y--) {
                    if (y>i)
                        System.out.print(" ");
                    else
                        System.out.print("#");
                }
                System.out.println();
            }
        }
    }
}