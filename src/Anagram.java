import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String word1 = in.next();
        String word2 = in.next();

        System.out.println( String.valueOf(isAnagram(word1, word2)) );
    }

    private static boolean isAnagram(String word1, String word2) {
        if (StringUtils.isEmpty(word1) || StringUtils.isEmpty(word2)) {
            return false;
        }
        if (word1.length() != word2.length()) {
            return false;
        }
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        HashMap<Character, Integer> wordMap = new HashMap<>();
        for (int i=0; i<word1.length(); i++) {
            Character ch = word1.charAt(i);
            if (wordMap.containsKey(ch)) {
                wordMap.put(ch, wordMap.get(ch) + 1);
            } else {
                wordMap.put(ch, 1);
            }
        }

        for (int j=0; j<word2.length(); j++) {
            Character ch = word2.charAt(j);
            if (wordMap.containsKey(ch)) {
                wordMap.put(ch, wordMap.get(ch) - 1);
            } else {
                return false;
            }
        }

//        Iterator it = wordMap.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry entry = (Map.Entry) it.next();
//            if ((Integer) entry.getValue() != 0) {
//                return false;
//            }
//            it.remove();
//        }

        for (Integer charCount : wordMap.values()) {
            if (charCount != 0) {
                return false;
            }
        }
        return true;
    }
}

