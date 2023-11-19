package TechnicalAssesments.BlackRock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import java.util.*;

public class BlackRock2 {

    /**
   * Iterate through each line of input.
   */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;

        int lineNumber = 0;
        String fxRates = null;
        String selectedCurrency = null;
        String targetCurrency = null;

        while ((line = in.readLine()) != null) {
            if (lineNumber == 0) {
            fxRates = line;
            }
        
            if (lineNumber == 1) {
            selectedCurrency = line;
            }
        
            if (lineNumber == 2) {
            targetCurrency = line;
            }
        
            lineNumber++;
        }

    // Process the fxRates and calculate the maximum amount of the target currency
    double maxAmount = calculateMaxAmount(fxRates, selectedCurrency, targetCurrency);

    // Print the result
    System.out.println(maxAmount);
    }

    private static double calculateMaxAmount(String fxRates, String selectedCurrency, String targetCurrency) {
        class Pair<K, V> {
            private K key;
            private V value;

            public Pair(K key, V value) {
                this.key = key;
                this.value = value;
            }

            public K getKey() {
                return key;
            }

            public V getValue() {
                return value;
            }
        }
        String[] rateList = fxRates.split(";");

        // Create a map to store the exchange rates
        Map<String, Map<String, Double>> exchangeRates = new HashMap<>();

        // Populate the exchangeRates map with the provided rates
        for (String rate : rateList) {
            String[] parts = rate.split(",");
            String fromCurrency = parts[0];
            String toCurrency = parts[1];
            double rateValue = Double.parseDouble(parts[2]);

            // Add the exchange rate to the map
            if (!exchangeRates.containsKey(fromCurrency)) {
                exchangeRates.put(fromCurrency, new HashMap<>());
            }
            exchangeRates.get(fromCurrency).put(toCurrency, rateValue);
        }

        // Use Depth-First Search (DFS) to find the maximum amount of the target currency
        Stack<Pair<String, Double>> stack = new Stack<>();
        stack.push(new Pair<>(selectedCurrency, 1.0));

        double maxAmount = -1.0; // Maximum amount encountered

        while (!stack.isEmpty()) {
            Pair<String, Double> pair = stack.pop();
            String currentCurrency = pair.getKey();
            double currentAmount = pair.getValue();

            // If the current currency is the target currency and the current amount is greater than the maxAmount, update maxAmount
            if (currentCurrency.equals(targetCurrency) && currentAmount > maxAmount) {
                maxAmount = currentAmount;
            }

            // Check if there are exchange rates for the current currency
            if (exchangeRates.containsKey(currentCurrency)) {
                Map<String, Double> rates = exchangeRates.get(currentCurrency);
                for (String nextCurrency : rates.keySet()) {
                    double exchangeRate = rates.get(nextCurrency);
                    double nextAmount = currentAmount * exchangeRate;
                    stack.push(new Pair<>(nextCurrency, nextAmount));
                }
            }
        }

        // Return the maximum amount
        return maxAmount;
    }


}
