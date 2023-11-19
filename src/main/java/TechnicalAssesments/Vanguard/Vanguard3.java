package TechnicalAssesments.Vanguard;

import java.util.LinkedList;
import java.util.List;

public class Vanguard3 {
    

    /*
     * Complete the 'missingWords' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     */
    public static List<String> missingWords(String s, String t) {
        String missing = s.replace(t, "");

        String[] sWords = missing.split(" ");
        List<String> result = new LinkedList<>();
        for (int i = 0; i < sWords.length; i++) {
            result.add(sWords[i]);
        }

        return result;
    }
}
