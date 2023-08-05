package TechnicalAssesments.Sentry;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentry1 {
    
    public static String filterBadWords(String badWords, String message) {
        // Split the badWords string into individual bad words.
        String[] badWordList = badWords.split("\\s+");

        // Process each bad word separately to ensure accurate replacements.
        for (String badWord : badWordList) {
            if (badWord.contains("*")) {
                // Escape characters for regex and replace '*' with '.*' to match any characters.
                String regexWord = badWord.replaceAll("\\*", ".*?");
                // Use word boundaries and look ahead to match the entire word.
                Pattern pattern = Pattern.compile("\\b" + regexWord + "(?=\\b|\\s|$)", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(message);
                StringBuffer sb = new StringBuffer();

                // Find matches and replace them with asterisks of the same length.
                while (matcher.find()) {
                    String matchedWord = matcher.group();
                    matcher.appendReplacement(sb, "*".repeat(matchedWord.length()));
                }
                matcher.appendTail(sb);
                message = sb.toString();
            } else {
                // For fixed bad words, use word boundaries to match the entire word.
                Pattern pattern = Pattern.compile("\\b" + Pattern.quote(badWord) + "\\b", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(message);
                StringBuffer sb = new StringBuffer();

                // Find matches and replace them with asterisks of the same length.
                while (matcher.find()) {
                    String matchedWord = matcher.group();
                    matcher.appendReplacement(sb, "*".repeat(matchedWord.length()));
                }
                matcher.appendTail(sb);
                message = sb.toString();
            }
        }

        return message;
    }






}
