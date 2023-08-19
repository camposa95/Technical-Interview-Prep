package TechnicalAssesments.IMB;

public class IBM1 {
    public static int getMinFlips(String pwd) {
        int flipsNeeded = 0;  // The final minimum number of flips required

        // Traverse the input string to create even-length substrings
        for (int i = 0; i < pwd.length() - 1; i += 2) {
            char currentChar = pwd.charAt(i);
            char nextChar = pwd.charAt(i + 1);

            // If the current and next characters are different, a flip is needed
            if (currentChar != nextChar) {
                flipsNeeded++;
            }
        }

        return flipsNeeded;
    }
}
