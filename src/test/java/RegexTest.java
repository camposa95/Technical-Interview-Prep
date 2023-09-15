import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    // main method
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();

        // define pattern for finding quantities
        Pattern p = Pattern.compile("\\d+(?= usd)");
        Matcher m = p.matcher("1 usd 2 usd 3 usd 4 usd 5 usd 6 usd 7 usd 8 usd 9 usd 10 usd");

        // find all matches
        while (m.find()) {
            // add the match to the list
            list.add(m.group());
        }

        // print the list
        for (String match: list) {
            System.out.println(match);
        }

        System.out.println("Done");
    }
}
