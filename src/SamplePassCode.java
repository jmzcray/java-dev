/**
 * Created by james on 9/01/2017.
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 *
 Everyone knows passphrases. One can choose passphrases from poems, songs,
 movies names and so on but frequently they can be guessed due to common cultural references.
 You can get your passphrases stronger by different means. One is the following:

 choose a text in capital letters including or not digits and non alphabetic characters,

 1. shift each letter by a given number but the transformed letter must be a letter (circular shift),
 2. replace each digit by its complement to 9,
 3. keep such as non alphabetic and non digit characters,
 4. downcase each letter in odd position, upcase each letter in even position (the first character is in position 0),
 5. reverse the whole result.

 Example:

 your text: "BORN IN 2015!", shift 1

 1 + 2 + 3 -> "CPSO JO 7984!"

 4 "CpSo jO 7984!"

 5 "!4897 Oj oSpC"
 *
 *
 */

public class SamplePassCode {

    private static int count = 0;

    public static String playPass(String s, int n) {

//        StringBuilder sb = new StringBuilder();
//        int count=1;
//
//        for (char ch : s.toCharArray()) {
//            if (Character.isDigit(ch)) {
//                sb.append( String.valueOf(9 - Character.getNumericValue(ch)) );
//            } else if (Character.isLetter(ch)) {
//                if (Character.isLowerCase(ch))
//                    ch = (char) ( ((int)ch + n - (int)'a') % 26 + (int)'a' );
//                else
//                    ch = (char) ( ((int)ch + n - (int)'A') % 26 + (int)'A' );
//
//                if (count % 2 == 0)
//                    sb.append( String.valueOf(ch).toLowerCase() );
//                else
//                    sb.append( String.valueOf(ch).toUpperCase() );
//            } else {
//                sb.append( String.valueOf(ch) );
//            }
//            count++;
//        }
//
//        return sb.reverse().toString();

        count = 0;

        return new StringBuilder()
                .append(
                        s.toLowerCase()
                                .chars()
                                .map(i -> Character.isDigit(i) ? '9' - Character.getNumericValue(i) : i)
                                .mapToObj(c -> (char) c)
                                .map(i -> Character.isLetter(i) ?
                                        (char) ( ((int)i + n - (int)'a') % 26 + (int)'a')  : i)
                                .map(i -> (count++ % 2 == 0 ? Character.toUpperCase(i) : Character.toLowerCase(i)))
                                .map(i -> i.toString())
                                .collect(Collectors.joining("")))
                .reverse()
                .toString();

    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        int b = Integer.valueOf(in.nextLine());

        System.out.println( playPass(a, b) );
    }
}