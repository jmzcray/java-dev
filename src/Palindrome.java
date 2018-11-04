import java.io.IOException;
import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String word = in.next();

        System.out.println( String.valueOf(isPalindrome(word)) );
    }

    private static boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString().equalsIgnoreCase(word);
    }
}
