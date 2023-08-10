package TechnicalAssesments.Sentry;

import java.util.ArrayList;
import java.util.List;

public class Sentry1 {

    public static List<String> add_whitespace(String words, int line_char_limit) {
        String[] wordArray = words.split("\\s+");
        List<String> result = new ArrayList<>();
        StringBuilder currentLine = new StringBuilder();

        for (String word : wordArray) {
            if (currentLine.length() + word.length() <= line_char_limit) {
                if (currentLine.length() > 0) {
                    currentLine.append(" ");
                }
                currentLine.append(word);
            } else {
                result.add(formatLine(currentLine.toString(), line_char_limit));
                currentLine = new StringBuilder(word);
            }
        }

        if (currentLine.length() > 0) {
            result.add(formatLine(currentLine.toString(), line_char_limit));
        }

        return result;
    }

    private static String formatLine(String line, int line_char_limit) {
        if (line.contains("-")) {
            int hyphenIndex = line.indexOf("-");
            String firstPart = line.substring(0, hyphenIndex + 1);
            String secondPart = line.substring(hyphenIndex + 1);
    
            if (line.length() + secondPart.length() <= line_char_limit) {
                return line;
            } else {
                return firstPart.trim();
            }
        } else {
            int extraWhitespace = line_char_limit - line.replaceAll("\\s", "").length();
            int spaceCount = line.contains(" ") ? line.split(" ").length - 1 : 0;
            int spaceToAdd = spaceCount > 0 ? extraWhitespace / spaceCount : 0;
            int remainder = spaceCount > 0 ? extraWhitespace % spaceCount : 0;
    
            StringBuilder formattedLine = new StringBuilder();
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++) {
                formattedLine.append(words[i]);
                if (i < words.length - 1) {
                    for (int j = 0; j < spaceToAdd; j++) {
                        formattedLine.append(" ");
                    }
                    if (remainder > 0) {
                        formattedLine.append(" ");
                        remainder--;
                    }
                }
            }
            return formattedLine.toString();
        }
    }
    
}
