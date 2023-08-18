package TechnicalAssesments.Goldman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Goldman1 {
    public static void main(String[] args) {
        String inputString = "a3c96b2c2";
        String pairs = betterCompression(inputString);

        System.out.println(pairs);
    }
    
    public static String betterCompression(String s) {
        // Create a map to store the sum of numbers for each letter
        Map<Character, Integer> charToSum = new HashMap<>();
        
        // Define a pattern to match letter-number pairs
        Pattern pattern = Pattern.compile("[a-zA-Z]\\d+");
        Matcher matcher = pattern.matcher(s);

        // Iterate through the input and update the sums in the map
        while (matcher.find()) {
            String pair = matcher.group();
            char letter = pair.charAt(0);
            int number = Integer.parseInt(pair.substring(1));

            charToSum.put(letter, charToSum.getOrDefault(letter, 0) + number);
        }

        // Construct a list of revised pairs using entrySet() of the map
        List<String> revisedPairs = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : charToSum.entrySet()) {
            revisedPairs.add(entry.getKey() + String.valueOf(entry.getValue()));
        }

        // Sort the revised pairs alphabetically
        Collections.sort(revisedPairs);

        // Join the revised pairs and return the final result
        return String.join("", revisedPairs);
    }
}
