package TechnicalAssesments.Goldman;

import java.util.Collections;
import java.util.List;

public class Goldman2 {

    public static int maxProfit(int costPerCut, int salePrice, List<Integer> lengths) {
        int maxProfit = 0;
        int currentProfit = 0;
        int maxRodLength = 0;

        // Sort the lengths in ascending order
        Collections.sort(lengths);

        // Find out the maximum length among all rods
        for (int currentLength : lengths) {
            maxRodLength = Math.max(maxRodLength, currentLength);
        }

        // For each possible rod length, calculate possible profit
        for (int currentLength = 1; currentLength <= maxRodLength; currentLength++) {
            int previousSum = 0; // Profit accumulated from previous cuts

            // Cut each rod into smaller rods of size curLength
            // Count total rods and total cuts
            for (int length : lengths) {
                int cuts = 0;
                int waste = 0;

                // Calculate cuts and waste based on rod length and currentLength
                if (length % currentLength == 0) {
                    cuts = (length / currentLength) - 1;
                } else {
                    cuts = length / currentLength;
                }
                waste = length % currentLength;

                // Calculate profit for the current rod length and update prevSum
                int profit = Math.max(previousSum,
                        previousSum + (length * salePrice - cuts * costPerCut - waste * salePrice));
                previousSum = profit;
            }

            currentProfit = previousSum;
            // Update the maximum profit obtained so far
            maxProfit = Math.max(maxProfit, currentProfit);
        }

        return maxProfit;
    }
}
