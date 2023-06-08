package LeetCodeStuff;
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int Profit = 0;

        int todaysPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            todaysPrice = prices[i];
            buyPrice = Math.min(buyPrice, todaysPrice); // either this will decrease or .. 

            Profit = Math.max(Profit, todaysPrice - buyPrice); // this will
        }

        return Profit;
    }
}
