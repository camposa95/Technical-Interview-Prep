package TechnicalAssesments.WolverineTrading;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WT2 {
    
    /*
     * Complete the 'decode' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY codes
     *  2. STRING encoded
     */

    public static String decode(List<String> codes, String encoded) {
        
        Map<String, String> mappings = new HashMap<>();
        for (String code : codes) {
            String[] decode = code.split("\t");
            String key = decode[1].intern();
            
            String value = decode[0].intern();
            if (value.equals("[newline]")) {
                value = "\n".intern();
            }
            
            mappings.put(key, value);
        }
        
        Pattern p = Pattern.compile(String.join("|", mappings.keySet()));
        Matcher matcher = p.matcher(encoded);
        
        // StringBuilder to store the decoded string
        StringBuilder decodedStringBuilder = new StringBuilder();
        int lastEnd = 0; // Keep track of the last match end index
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();

            // Append the text between the last match and the current match
            decodedStringBuilder.append(encoded.substring(lastEnd, start));

            // Append the corresponding value for the code
            String code = encoded.substring(start, end).intern();
            String value = mappings.get(code);
            decodedStringBuilder.append(value);

            // Update the last match end index
            lastEnd = end;
        }

        // Append any remaining text after the last match
        decodedStringBuilder.append(encoded.substring(lastEnd));

        return decodedStringBuilder.toString();
    }
}
