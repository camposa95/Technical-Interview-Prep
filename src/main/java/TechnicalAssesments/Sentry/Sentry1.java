package TechnicalAssesments.Sentry;

public class Sentry1 {

    public static String filterBadWords(String badWords, String message) {
        String[] badWordArray = badWords.split("\\s+");
        StringBuilder filteredMessage = new StringBuilder(message);

        for (String badWord : badWordArray) {
            String regex = "\\b" + badWord.replace("*", "\\w*") + "\\b";
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(filteredMessage);

            StringBuffer sb = new StringBuffer();
            while (matcher.find()) {
                String replacement = "*".repeat(matcher.group().length());
                matcher.appendReplacement(sb, replacement);
            }
            matcher.appendTail(sb);
            filteredMessage = sb;
            
        }

        return filteredMessage.toString();
    }









}
