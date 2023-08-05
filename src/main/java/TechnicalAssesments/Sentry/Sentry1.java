package TechnicalAssesments.Sentry;

public class Sentry1 {

    public static String filterBadWords(String badWords, String message) {
        String[] badWordArray = badWords.split("\\s+");
        String[] words = message.split("\\s+");
        StringBuilder filteredMessage = new StringBuilder();

        for (String word : words) {
            boolean isBadWord = false;

            for (String badWord : badWordArray) {
                if (badWord.contains("*")) {
                    // Handle bad words with wildcards (*)
                    String regex = "\\b" + badWord.replace("*", "\\w*") + "\\b";
                    Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
                    Matcher matcher = pattern.matcher(word);
                    if (matcher.find()) {
                        isBadWord = true;
                        break;
                    }
                } else {
                    // Handle exact bad words
                    if (word.equalsIgnoreCase(badWord)) {
                        isBadWord = true;
                        break;
                    }
                }
            }

            if (isBadWord) {
                filteredMessage.append("*".repeat(word.length())).append(" ");
            } else {
                filteredMessage.append(word).append(" ");
            }
        }

        return filteredMessage.toString().trim();
    }


}
