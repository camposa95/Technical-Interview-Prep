package TechnicalAssesments.BlackRock;

import java.util.*;

public class BlackRock1 {

    public class WeightedDirectedGraph {
        private int numNodes;
        private int[][] adjacencyMatrix;

        public WeightedDirectedGraph(int numNodes) {
            this.numNodes = numNodes;
            adjacencyMatrix = new int[numNodes][numNodes];
        }

        public void addEdge(int source, int destination, int weight) {
            adjacencyMatrix[source][destination] = weight;
        }

        public List<Integer> findLongestPath(int startNode, int endNode) {
            int[] dp = new int[numNodes];
            int[] parent = new int[numNodes];
            Arrays.fill(parent, -1);

            for (int i = 0; i < numNodes; i++) {
                dp[i] = Integer.MIN_VALUE;
            }

            dp[startNode] = 0;

            for (int i = 0; i < numNodes - 1; i++) {
                for (int j = 0; j < numNodes; j++) {
                    for (int k = 0; k < numNodes; k++) {
                        if (adjacencyMatrix[j][k] > 0 && dp[j] != Integer.MIN_VALUE && dp[j] + adjacencyMatrix[j][k] > dp[k]) {
                            dp[k] = dp[j] + adjacencyMatrix[j][k];
                            parent[k] = j;
                        }
                    }
                }
            }

            if (dp[endNode] == Integer.MIN_VALUE) {
                return Collections.emptyList(); // No path found
            }

            List<Integer> path = new ArrayList<>();
            int current = endNode;
            while (current != -1) {
                path.add(0, current);
                current = parent[current];
            }

            return path;
        }

    }
}
