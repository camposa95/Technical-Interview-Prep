package TechnicalAssesments.Sentry;

public class Sentry1 {
    
    public static String filterBadWords(String badWords, String message) {
        // Split the badWords string into individual bad words.
        String[] badWordList = badWords.split("\\s+");

        // Create a regular expression pattern to match the bad words with wildcards.
        StringBuilder regexBuilder = new StringBuilder();
        for (String badWord : badWordList) {
            if (badWord.contains("*")) {
                // Replace '*' with a non-greedy pattern to avoid overlapping matches.
                String regexWord = badWord.replaceAll("\\*", "(.*?\\\\b.*?)");
                regexBuilder.append(regexWord).append("|");
            } else {
                regexBuilder.append("\\b").append(Pattern.quote(badWord)).append("\\b|");
            }
        }
        // Remove the last '|' character from the regex string.
        String regex = regexBuilder.substring(0, regexBuilder.length() - 1);

        // Use the regex pattern to replace the bad words in the message with asterisks.
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(message);
        StringBuffer sb = new StringBuffer();

        while (matcher.find()) {
            String matchedWord = matcher.group();
            matcher.appendReplacement(sb, "*".repeat(matchedWord.length()));
        }
        matcher.appendTail(sb);

        return sb.toString();
    }

}
