package TechnicalAssesments.BelevedereTRading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class BelevedereTrading1 {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line = in.readLine(); // Read the entire line of input
        String[] trades = line.split(";"); // Split input into individual trades
        Map<String, TradeStats> tradeMap = new HashMap<>();
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        for (String tradeStr : trades) {
            String[] tradeInfo = tradeStr.split(",");
            if (tradeInfo.length == 4) {
                String key = tradeInfo[0];
                double value = Double.parseDouble(tradeInfo[1]);
                int quantity = Integer.parseInt(tradeInfo[2]);
                int sequenceNumber = Integer.parseInt(tradeInfo[3]);

                TradeStats tradeStats = tradeMap.getOrDefault(key, new TradeStats());
                if (sequenceNumber > tradeStats.lastSeqNumber) {
                    tradeStats.valueSum += value * quantity;
                    tradeStats.quantitySum += quantity;
                    tradeStats.lastSeqNumber = sequenceNumber;
                    tradeMap.put(key, tradeStats);
                }
            }
        }

        for (Map.Entry<String, TradeStats> entry : tradeMap.entrySet()) {
            String key = entry.getKey();
            TradeStats tradeStats = entry.getValue();
            double weightedMovingAverage = tradeStats.valueSum / tradeStats.quantitySum;
            System.out.println(key + ": " + decimalFormat.format(weightedMovingAverage));
        }
    }

    static class TradeStats {
        double valueSum;
        int quantitySum;
        int lastSeqNumber;

        public TradeStats() {
            this.valueSum = 0;
            this.quantitySum = 0;
            this.lastSeqNumber = 0;
        }
    }
}
