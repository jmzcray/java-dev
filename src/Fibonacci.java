import java.io.IOException;
import java.util.Scanner;

// Different methods to find the nth position in a fibonacci sequence
// 1, 1, 2, 3, 5, 8 ...
//
// Note: don't put in a big number as it will cause stack overflow (not enough memory) due to recursive implementation

public class Fibonacci {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int position = in.nextInt();

        System.out.println( String.valueOf(findFib(position)) );
    }

    private static int findFib(int position) {

        int result;

        long startTime = System.nanoTime();
        result = recursiveFib(position);
        long endTime = System.nanoTime();
        System.out.println("recursiveFib took " + (endTime - startTime) + "ms and result is: " + result);


        startTime = System.nanoTime();
        int[] memo = new int[position + 1];
        result = recursiveDynamicFib(position, memo);
        endTime = System.nanoTime();
        System.out.println("recursiveDynamicFib took " + (endTime - startTime) + "ms and result is: " + result);

        startTime = System.nanoTime();
        result = IterativeFib(position);
        endTime = System.nanoTime();
        System.out.println("IterativeFib took " + (endTime - startTime) + "ms and result is: " + result);

        return result;
    }

    private static int recursiveFib(int position) {
        if (position == 1 || position == 2) {
            return 1;
        }
        return recursiveFib(position - 1) + recursiveFib( position - 2);
    }

    private static int recursiveDynamicFib(int position, int[] memo) {
        int result = 0;
        if (memo[position] != 0) {
            return memo[position];
        }
        if (position == 1 || position == 2) {
            result = 1;
        } else {
            result = recursiveDynamicFib(position - 1, memo) + recursiveDynamicFib(position - 2, memo);
        }
        memo[position] = result;
        return result;
    }

    private static int IterativeFib(int position) {
        int[] result = new int[position + 1];
        if (position == 1 || position == 2) {
            return 1;
        }
        result[1] = 1;
        result[2] = 1;

        for (int i=3; i<=position; i++) {
            result[i] = result[i-1] + result[i-2];
        }
        return result[position];
    }
}
