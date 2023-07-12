package TechnicalAssesments.JPMorgan;

public class JpMorgan1 {
    public static long getIdealNums(long low, long high) {
        long count = 0;

        // Iterate through the range [low, high] and check each number
        for (long num = low; num <= high; num++) {
            // Check if the number is an ideal number
            if (isIdealNumber(num)) {
                count++;
            }
        }

        return count;
    }

    // Helper function to check if a number is an ideal number
    private static boolean isIdealNumber(long num) {
        // Divide the number by 3 and 5 as long as it is divisible
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }

        // If the number becomes 1, it is an ideal number
        return num == 1;
    }

}
