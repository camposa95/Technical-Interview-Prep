package TechnicalAssesments.IMB;

import java.util.List;

public class IBM2 {

    public static long getMinimumCost(List<Integer> arr) {
        long cost = 0;
        long maxCost = 0;
        int firstIndex = 0;
        int secondIndex = 0;

        // Find max diff between neighbors
        for (int i = 0; i < arr.size() - 1; i++) {
            int first = arr.get(i);
            int second = arr.get(i + 1);
            if (Math.abs(second - first) > maxCost) {
                maxCost = Math.abs(second - first);
                firstIndex = i;
                secondIndex = i + 1;
            }
        }

        // New number between the max diff
        int mid = Math.floorDiv((arr.get(firstIndex) + arr.get(secondIndex)), 2);

        // Add the cost
        cost += Math.pow(arr.get(firstIndex) - mid, 2);
        cost += Math.pow(arr.get(secondIndex) - mid, 2);

        // Add the cost
        for (int i = 0; i < arr.size() - 1; i++) {
            if (i == firstIndex) {
                continue;
            }
            int first = arr.get(i);
            int second = arr.get(i + 1);
            cost += Math.pow(first - second, 2);
        }

        return cost;
    }

}
