/**
 * Created by au_j on 24/10/2016.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SampleBraces {


    /*
     * Complete the function below.
     */

    static String[] braces(String[] values) {

        ArrayList<String> currentBrace = new ArrayList<String>();
        String[] result = new String [values.length];
        boolean valid;

        for (int i=0; i<values.length; i++){
            currentBrace.clear();
            result[i] = "NO";
            valid = true;
            for (int y=0; y<values[i].length(); y++){
                String current = values[i];
                String currentChar = String.valueOf(current.charAt(y));
                if (isOpenBracket( currentChar )) {
                    currentBrace.add(currentChar);
                } else if (isClosedBracket(currentChar)) {
                    if (currentBrace.size() == 0) {
                        valid = false;
                        break;
                    } else {
                        if (currentChar.equals(")") && currentBrace.get(currentBrace.size()-1).equals("(")) {
                            currentBrace.remove(0);
                        } else if (currentChar.equals("}") && currentBrace.get(currentBrace.size()-1).equals("{")) {
                            currentBrace.remove(0);
                        } else if (currentChar.equals("]") && currentBrace.get(currentBrace.size()-1).equals("[")) {
                            currentBrace.remove(0);
                        }
                    }
                }
            }
            if (currentBrace.size() == 0 && valid){
                result[i] = "YES";
            }
        }
        return result;
    }

    private static boolean isOpenBracket(String b){
        return (b.equals("(") || b.equals("{") || b.equals("["));
    }

    private static boolean isClosedBracket(String b){
        return (b.equals(")") || b.equals("}") || b.equals("]"));
    }



    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
//        final String fileName = System.getenv("OUTPUT_PATH");
//        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String[] res;

        int _values_size = 0;
        _values_size = Integer.parseInt(in.nextLine().trim());
        String[] _values = new String[_values_size];
        String _values_item;
        for(int _values_i = 0; _values_i < _values_size; _values_i++) {
            try {
                _values_item = in.nextLine();
            } catch (Exception e) {
                _values_item = null;
            }
            _values[_values_i] = _values_item;
        }

        res = braces(_values);
        for(int res_i=0; res_i < res.length; res_i++) {
//            bw.write(String.valueOf(res[res_i]));
//            bw.newLine();
            System.out.println(res);
        }

//        bw.close();
    }
}

