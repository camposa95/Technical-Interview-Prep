package TechnicalAssesments.BelevedereTRading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class BelevedereTrading1 {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        Map<String, TradeStats> tradeMap = new HashMap<>();
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        while ((line = in.readLine()) != null) {
            String[] tradeInfo = line.split(",");
            if (tradeInfo.length == 4) {
                String key = tradeInfo[0];
                double value = Double.parseDouble(tradeInfo[1]);
                int quantity = Integer.parseInt(tradeInfo[2]);
                int sequenceNumber = Integer.parseInt(tradeInfo[3]);

                if (!tradeMap.containsKey(key) || sequenceNumber > tradeMap.get(key).lastSeqNumber) {
                    tradeMap.put(key, new TradeStats(value, quantity, sequenceNumber));
                }
            }
        }

        for (Map.Entry<String, TradeStats> entry : tradeMap.entrySet()) {
            String key = entry.getKey();
            TradeStats tradeStats = entry.getValue();
            double weightedMovingAverage = (tradeStats.prevWMA * tradeStats.prevQuantity +
                    tradeStats.value * tradeStats.quantity) / (tradeStats.prevQuantity + tradeStats.quantity);
            tradeStats.prevWMA = weightedMovingAverage;
            tradeStats.prevQuantity += tradeStats.quantity;
            System.out.println(key + ": " + decimalFormat.format(weightedMovingAverage));
        }
    }

    static class TradeStats {
        double value;
        int quantity;
        int lastSeqNumber;
        double prevWMA;
        int prevQuantity;

        public TradeStats(double value, int quantity, int lastSeqNumber) {
            this.value = value;
            this.quantity = quantity;
            this.lastSeqNumber = lastSeqNumber;
            this.prevWMA = 0;
            this.prevQuantity = 0;
        }
    }
}
