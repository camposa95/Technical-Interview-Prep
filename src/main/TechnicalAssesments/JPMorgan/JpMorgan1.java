package TechnicalAssesments.JPMorgan;

public class JpMorgan1 {

    public static long getIdealNums(long low, long high) {
        // Calculate the maximum powers of 3 and 5 within the given range
        int maxPowerOf3 = (int) (Math.log(high) / Math.log(3));
        int maxPowerOf5 = (int) (Math.log(high) / Math.log(5));

        // Initialize the count of ideal numbers
        long count = 0;

        // Generate all possible combinations of powers of 3 and 5
        for (int powerOf3 = 0; powerOf3 <= maxPowerOf3; powerOf3++) {
            for (int powerOf5 = 0; powerOf5 <= maxPowerOf5; powerOf5++) {
                long number = (long) Math.pow(3, powerOf3) * (long) Math.pow(5, powerOf5);
                if (number >= low && number <= high) {
                    count++;
                }
            }
        }

        return count;
    }

}
