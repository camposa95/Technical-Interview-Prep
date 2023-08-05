package TechnicalAssesments.Sentry;

public class Sentry1 {
    
    public static String filterBadWords(String badWords, String message) {
        String[] badWordArray = badWords.split("\\s+"); // Split badWords by whitespace
        String[] words = message.split("\\s+"); // Split the message into words by whitespace
        StringBuilder filteredMessage = new StringBuilder();

        for (String word : words) {
            boolean isBadWord = false;

            for (String badWord : badWordArray) {
                if (badWord.contains("*")) {
                    // Handle bad words with wildcards (*)
                    String regex = "\\b" + badWord.replace("*", "\\w*") + "\\b";
                    if (word.matches(regex)) {
                        isBadWord = true;
                        break;
                    }
                } else {
                    // Handle exact bad words
                    if (word.equals(badWord)) {
                        isBadWord = true;
                        break;
                    }
                }
            }

            if (isBadWord) {
                // If word is a bad word, replace it with *'s equal to the length of the word
                filteredMessage.append("*".repeat(word.length())).append(" ");
            } else {
                // Otherwise, keep the original word
                filteredMessage.append(word).append(" ");
            }
        }

        // Remove the trailing whitespace and return the filtered message
        return filteredMessage.toString().trim();
    }

}
