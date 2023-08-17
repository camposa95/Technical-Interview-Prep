package TechnicalAssesments.Vanguard;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Vanguard2 {
    
    /*
     * Complete the 'isPangram' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY pangram as parameter.
     */
    public static String isPangram(List<String> pangram) {
        StringBuilder result = new StringBuilder();

        // create a set of characters that represents the alphabet
        Set<Character> alphabet = new HashSet<>();
        for (char c = 'a'; c <= 'z'; c++) {
            alphabet.add(c);
        }        

        // iterate through each sentence in the pangram list
        for (int i = 0; i < pangram.size(); i++) {
            String sentence = pangram.get(i).toLowerCase();
            
            // create a new set of all the characters in the sentence
            Set<Character> sentenceChars = new HashSet<>();
            for (int j = 0; j < sentence.length(); j++) {
                sentenceChars.add(sentence.charAt(j));
            }

            // if the sentence contains all the characters in the alphabet, it is a pangram
            if (sentenceChars.containsAll(alphabet)) {
                result.append("1");
            } else {
                result.append("0");
            }
        }

        return result.toString();
    }
}
