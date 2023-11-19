package TechnicalAssesments.Vanguard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Vanguard1 {
    /*
     * Complete the 'getSpamEmails' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY subjects
     *  2. STRING_ARRAY spam_words
     */
    public static List<String> getSpamEmails(List<String> subjects, List<String> spam_words) {
        List<String> result = new ArrayList<>();
        Set<String> spamWordsSet = new HashSet<>();
        for (String word : spam_words) {
            spamWordsSet.add(word.toLowerCase());
        }

        for (int i = 0; i < subjects.size(); i++) {
            String subject = subjects.get(i).toLowerCase();
            String[] words = subject.split(" ");

            int numSpamWords = 0;
            for (String word : words) {
                if (spamWordsSet.contains(word)) {
                    numSpamWords++;
                }
            }

            if (numSpamWords >= 2) {
                result.add("spam");
            } else {
                result.add("not_spam");
            }
        }

        return result;
    }
}
