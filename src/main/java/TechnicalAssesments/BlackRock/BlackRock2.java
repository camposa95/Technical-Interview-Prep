package TechnicalAssesments.BlackRock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import java.util.*;

public class BlackRock2 {

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;

        while ((line = in.readLine()) != null) {
            // Split the input line into individual values
            String[] values = line.split(";");

            // Extract the necessary information from the input
            String fxRates = values[0];
            String selectedCurrency = values[1];
            String targetCurrency = values[2];

            // Process the fxRates and calculate the maximum amount of the target currency
            double maxAmount = calculateMaxAmount(fxRates, selectedCurrency, targetCurrency);

            // Print the result
            System.out.println(maxAmount);
        }
    }

    private static double calculateMaxAmount(String fxRates, String selectedCurrency, String targetCurrency) {
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

        // Use Breadth-First Search (BFS) to find the maximum amount of the target currency
        Queue<Pair<String, Double>> queue = new LinkedList<>();
        queue.add(new Pair<>(selectedCurrency, 1.0));

        while (!queue.isEmpty()) {
            Pair<String, Double> pair = queue.poll();
            String currentCurrency = pair.getKey();
            double currentAmount = pair.getValue();

            // If the current currency is the target currency, return the current amount
            if (currentCurrency.equals(targetCurrency)) {
                return currentAmount;
            }

            // Check if there are exchange rates for the current currency
            if (exchangeRates.containsKey(currentCurrency)) {
                Map<String, Double> rates = exchangeRates.get(currentCurrency);
                for (String nextCurrency : rates.keySet()) {
                    double exchangeRate = rates.get(nextCurrency);
                    double nextAmount = currentAmount * exchangeRate;
                    queue.add(new Pair<>(nextCurrency, nextAmount));
                }
            }
        }

        // If the target currency cannot be reached, return -1.0
        return -1.0;
    }

}
