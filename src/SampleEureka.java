/**
 * Created by james on 6/01/2017.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.util.Arrays;
import java.util.Scanner;

class SampleEureka {

    public static List<Long> sumDigPow(long a, long b) {
        List<Long> result = new ArrayList<>();
        for (long i=a; i<=b; i++) {
            if (isEureka(i))
                result.add(i);
        }
        return result;
    }

    private static boolean isEureka(long num) {
        long eureka = 0;
        long tmp = num;
        int count = String.valueOf(num).length();
        while (tmp > 0) {
            int digit = (int) tmp % 10;
            eureka = eureka + (long) Math.pow(digit, count);
            tmp /= 10;
            count--;
        }
        return eureka == num;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();

        System.out.println( Arrays.toString(sumDigPow(a, b).toArray()) );
    }
}