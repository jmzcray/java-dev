import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SampleLookAndSay {
    /*
 * Complete the function below.
 */

    static String LookAndSay(String start, int n) {

        String curStr=null;
        int curindex=0;
        StringBuilder result = new StringBuilder();

        for (int i=0; i<start.length(); i++){
            String cha = Character.toString(start.charAt(i));

            if (null!=curStr && !curStr.isEmpty()) {
                if (!cha.equals(curStr)){
                    result.append(i-curindex).append(curStr);
                    curindex = i;
                }
            }
            curStr = cha;
            if (i == start.length()-1) {
                result.append(i-curindex+1).append(curStr);
            }
        }
        //return result.toString();

        if (n == 1)
            return result.toString();
        else
            return LookAndSay(result.toString(), n-1);
    }

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        //final String fileName = System.getenv("OUTPUT_PATH");
        //BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        String _start;
        try {
            _start = in.nextLine();
        } catch (Exception e) {
            _start = null;
        }

        int _n;
        _n = Integer.parseInt(in.nextLine());

        res = LookAndSay(_start, _n);
        //bw.write(res);
        //bw.newLine();
        System.out.println(res);
        //bw.close();
    }
}