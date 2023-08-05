package TechnicalAssesments.Sentry;

public class Sentry1 {

    
    public static String filterBadWords(String badWords, String message) {
        // Split the badWords string into individual bad words.
        String[] badWordList = badWords.split("\\s+");

        // Create a regular expression pattern to match the bad words with wildcards.
        StringBuilder regexBuilder = new StringBuilder();
        for (String badWord : badWordList) {
            if (badWord.contains("*")) {
                // Escape the characters for regex and replace '*' with '.*' to match any characters.
                String regexWord = badWord.replaceAll("\\*", ".*");
                regexBuilder.append("\\b").append(regexWord).append("\\b|"); // Add word boundary anchors.
            } else {
                regexBuilder.append("\\b").append(badWord).append("\\b|"); // Add word boundary anchors.
            }
        }
        // Remove the last '|' character from the regex string.
        String regex = regexBuilder.substring(0, regexBuilder.length() - 1);

        // Use the regex pattern to replace the bad words in the message with asterisks.
        String filteredMessage = message.replaceAll(regex, match -> "*".repeat(match.length()));

        return filteredMessage;
    }

}
