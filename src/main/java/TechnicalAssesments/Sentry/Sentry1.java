package TechnicalAssesments.Sentry;

import java.util.ArrayList;
import java.util.List;

public class Sentry1 {

    public static List<String> add_whitespace(String words, int line_char_limit) {
        String[] wordArray = words.split("\\s+");
        List<String> result = new ArrayList<>();
        int currentLineLength = 0;
        StringBuilder currentLine = new StringBuilder();

        for (String word : wordArray) {
            if (currentLineLength + currentLine.length() + word.length() <= line_char_limit) {
                if (currentLine.length() > 0) {
                    currentLine.append(" ");
                    currentLineLength++;
                }
                currentLine.append(word);
                currentLineLength += word.length();
            } else {
                result.add(formatLine(currentLine.toString(), currentLineLength, line_char_limit));
                currentLine = new StringBuilder(word);
                currentLineLength = word.length();
            }
        }

        if (currentLine.length() > 0) {
            result.add(formatLine(currentLine.toString(), currentLineLength, line_char_limit));
        }

        return result;
    }

    private static String formatLine(String line, int currentLength, int line_char_limit) {
        if (line.contains("-")) {
            int hyphenIndex = line.indexOf("-");
            String firstPart = line.substring(0, hyphenIndex + 1);
            String secondPart = line.substring(hyphenIndex + 1);

            if (currentLength + secondPart.length() <= line_char_limit) {
                return line;
            } else {
                return firstPart.trim();
            }
        } else {
            int extraWhitespace = line_char_limit - currentLength;
            int spaceToAdd = line.contains(" ") ? extraWhitespace / (line.split(" ").length - 1) : 0;
            int remainder = line.contains(" ") ? extraWhitespace % (line.split(" ").length - 1) : 0;

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
