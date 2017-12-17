
/**
 * Created by Jimz on 16/01/2016.
 *
 *
 * Alphabetically-sorted string and returns last string
 *
 * Sample Input: banana
 *
 * Sample Output: nana
 *
 * Explain:
 * The word, banana, will be splitted alphabetically like so:
 * { a, an, ana, anan, anana, b, ba, ban, bana, banan, banana. n, na, nan, nana}
 *
 * Therefore the last substring is nana
 *
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class LastAlphabeticallySortedString {

    /*
     * Complete the function below.
     */
    static String compute(String s) {
        String output;

        Set<Character> unique = uniqAlpha(s);
        TreeSet substrings = new TreeSet<>();
        for (Character c : unique) {
            for (int i = s.indexOf(c); i <= s.length(); i++) {
                if (substrings.isEmpty()) {
                    substrings.add(String.valueOf(s.charAt(i)));
                } else {
                    String sub = s.substring(s.indexOf(c), i);
                    substrings.add(sub);
                }

            }
        }
        return String.valueOf(substrings.last());
        // return String.join(" ", substrings);
    }

    public static Set uniqAlpha(String string) {
        Set<Character> chars = new TreeSet<>();
        for( char c : string.toCharArray() ) {
            chars.add(c);
        }
        return chars;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        String res;
        String s;
        try {
            s = in.nextLine();
        } catch (Exception e){
            s = null;
        }
        res = compute(s);

        System.out.println( res );
    }
}