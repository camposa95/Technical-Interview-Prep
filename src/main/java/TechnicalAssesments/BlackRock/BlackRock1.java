package TechnicalAssesments.BlackRock;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BlackRock1 {

    public void dskcvdsv() {
        
    import java.util.*;

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

    public static void main(String[] args) {
        WeightedDirectedGraph graph = new WeightedDirectedGraph(5);
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 6);
        graph.addEdge(2, 3, 4);
        graph.addEdge(2, 4, 2);
        graph.addEdge(3, 4, 1);

        int startNode = 0;
        int endNode = 4;

        List<Integer> longestPath = graph.findLongestPath(startNode, endNode);

        if (longestPath.isEmpty()) {
            System.out.println("No path found between nodes " + startNode + " and " + endNode);
        } else {
            System.out.println("Longest path between nodes " + startNode + " and " + endNode + ": " + longestPath);
        }
    }
}

    }
}
