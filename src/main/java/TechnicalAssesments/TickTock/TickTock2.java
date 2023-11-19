package TechnicalAssesments.TickTock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TickTock2 {
    public static long maximumPrioritySum(List<Integer> priority, int x, int y) {
        
        ArrayList<Integer> priority1 = new ArrayList<>(priority);
        Collections.sort(priority1);

        long sum = 0;
        int currentIndex = priority1.size() - 1;
        int secondsSinceLastReset = 0;
        for (int i = 0; i < y; i++) {
            if (secondsSinceLastReset == x) {
                secondsSinceLastReset = 0;
                currentIndex = priority1.size() - 1;
                sum += priority1.get(currentIndex);
            } else {
                if (currentIndex >= 0) {
                    sum += priority1.get(currentIndex);
                }
            }

            currentIndex--;
            secondsSinceLastReset++;
        }

        return sum;
    }
}
