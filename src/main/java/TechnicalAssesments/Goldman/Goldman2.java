package TechnicalAssesments.Goldman;

public class Goldman2 {
    public static long calculateMaximumProfit(int cost_per_cut, int metal_price, int[] lengths) {

    long maxProfit = 0;
    long curProfit = 0;
    int maxLength = 0;
    int totalRods = 0;
    int totalCuts = 0;
    Arrays.sort(lengths);
    // Find out maximum length
    for (int curLength : lengths) {
        maxLength = Math.max(maxLength, curLength);
    }

    // For each of the possible rod lengths, calculate possible profit
    for (int curLength = 1; curLength <=maxLength; curLength++) {        
        int prevSum=0;
        // Cut each of the rods into smaller rods of size curLength
        // Count total rods and total cuts
        for (int length : lengths) {
            int cut = 0;
            int waste = 0;
            if(length%curLength==0){
                cut=(length/curLength)-1;
            }else{
                cut=length/curLength;
            }
            waste=length%curLength;
            int profit=Math.max(prevSum,prevSum+(length*metal_price-cut*cost_per_cut-waste*metal_price));
            prevSum=profit;
        }

        curProfit=prevSum;
        // Calculate maximum profit
        maxProfit = Math.max(maxProfit, curProfit);
    }

    return maxProfit;
}
}
