package TechnicalAssesments.Vanguard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        String[] sWords = s.split(" ");
        String[] tWords = t.split(" ");

        Map<String, Integer> tMap = new HashMap<String, Integer>();
        for (int i = 0; i < tWords.length; i++) {
            String tWord = tWords[i].intern();

            if (tMap.containsKey(tWord)) {
                tMap.put(tWord, tMap.get(tWord) + 1);
            } else {
                tMap.put(tWord, 1);
            }
        }
        

        List<String> result = new LinkedList<String>();
        for (int i = 0; i < sWords.length; i++) {
            String sWord = sWords[i].intern();

            if (!tMap.entrySet().contains(sWord)) {
                result.add(sWord);
            } else {
                if (tMap.get(sWord) > 1) {
                    tMap.put(sWord, tMap.get(sWord) - 1);
                } else {
                    tMap.remove(sWord);
                }
            }
        }


        return result;
    }
}
