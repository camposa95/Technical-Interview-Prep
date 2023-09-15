package TechnicalAssesments.TickTock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TickTock1 {
    
    public static long getMinCost(List<Integer> cost, List<Integer> compatible1, List<Integer> compatible2, int min_compatible) {

        // Create two lists to store GPUs compatible with each cluster
        LinkedList<Integer> compatibleWithBoth = new LinkedList<>();
        LinkedList<Integer> compatibleWithCluster1 = new LinkedList<>();
        LinkedList<Integer> compatibleWithCluster2 = new LinkedList<>();
    
        // Populate the compatible lists based on the gpuList
        for (int i = 0; i < cost.size(); i++) {
            if (compatible1.get(i) == 1 && compatible2.get(i) == 1) {
                compatibleWithBoth.add(cost.get(i));
            } else if (compatible1.get(i) == 1) {
                compatibleWithCluster1.add(cost.get(i));
            } else if (compatible2.get(i) == 1) {
                compatibleWithCluster2.add(cost.get(i));
            }
        }
    
        // Sort the compatible lists in ascending order
        Collections.sort(compatibleWithBoth);
        Collections.sort(compatibleWithCluster1);
        Collections.sort(compatibleWithCluster2);
    
        // Calculate the minimum cost by selecting the first min_compatible GPUs from both lists
        long minCost = 0;
        for (int i = 0; i < min_compatible; i++) {
            if (compatibleWithBoth.peek() != null) {
                
                Integer gpu1 = compatibleWithCluster1.peek();
                Integer gpu2 = compatibleWithCluster2.peek();
                Integer both = compatibleWithBoth.peek();

                if ((gpu1 == null || gpu2 == null) || both < gpu1 + gpu2) {
                    minCost += compatibleWithBoth.poll();
                } else {
                    minCost += compatibleWithCluster1.poll() + compatibleWithCluster2.poll();
                }
            } else {
                try {
                    minCost += compatibleWithCluster1.poll() + compatibleWithCluster2.poll();
                } catch (Exception e) {
                    return -1;
                }
            }
        }
    
        return minCost;
    }
    
}
