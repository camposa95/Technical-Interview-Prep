package TechnicalAssesments;

import java.util.Collections;
import java.util.HashSet;

public class GoogleAssesement2 {
    public static String solution(String S) {
        // -------------------------------- directions --------------------------------

        // There is a string text consisting of at most 10 letters. Replace all
        // occurrences of each distinct letter in text with a different decimal digit
        // (each occurrence of the same letter should be replaced with the same digit).
        // The choice of digit for each letter does not matter as long as the digit is
        // different from the digits chosen for other letters. After the replacements,
        // the text treated as a number should be as large as possible.

        // Write a function:
        // string solution(string &text);
        // that, given a string text, returns a string representing the largest number
        // that can be obtained.

        // Examples:
        // 1. For text = "BABBC", letter 'A' can be replaced with digit 8, each letter
        // 'B' with 9 and letter 'C' with 7. The function should return "98997".
        // Note that there are another valid substitutions, for example "12113", but
        // "98997" represents the largest number among them.
        // 2. For text = "XYYZZZ", the function should return "988777".

        // Assume that:
        // the length of string text is within the range [1..10];
        // string text consists only of uppercase letters (A−Z).
        // In your solution, focus on correctness. The performance of your solution will
        // not be the focus of the assessment.

        // -------------------------------- solution --------------------------------

        // 1. Create a set of the digits 0-9
        HashSet<Integer> digits = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            digits.add(i);
        }

        // Because the largest number will be the number with larger digit in the most
        // significant place, we want to start with the largest digit and work our way
        // down
        // 2. Loop through the string and replace each letter with the largest digit
        // that is still available
        // Note we can't do this in place because of concurrent modification issues
        String largestNumber = S;

        // Store the letters that have been replaced so we don't duplicate work
        HashSet<Character> replacedLetters = new HashSet<>();

        // Loop throught the given string ding the replaceing in the largestNumber
        // string, and also removing the digit from the digits set, and adding the
        // letter to the replacedLetters set
        for (int i = 0; i < S.length(); i++) {
            char letter = S.charAt(i);
            if (!replacedLetters.contains(letter)) {
                // Find the largest digit that is still available
                int largestDigit = Collections.max(digits);

                // Replace all instances of the letter with the largest digit
                largestNumber = largestNumber.replace(letter, Character.forDigit(largestDigit, 10));

                // Remove the digit from the digits set
                digits.remove(largestDigit);

                // Add the letter to the replacedLetters set
                replacedLetters.add(letter);
            } else {
                // If the letter has already been replaced, we can skip it
            }
        }

        return largestNumber;
    }
}
