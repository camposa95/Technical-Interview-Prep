package TechnicalAssesments.Citadel;

public class Citadel1 {

    /*
     * Complete the 'findNumberOfWays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER n_intervals
     * 2. INTEGER n_processes
     */

    public static int bestSumAnyTreePath(List<Integer> parent, List<Integer> values) {
        int n = parent.size(); // Number of nodes in the tree
        
        // Create an adjacency list to represent the tree structure
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            int p = parent.get(i);
            adjList.get(p).add(i);
        }
        
        int[] dp = new int[n]; // Dynamic programming array to store the maximum sum at each node
        
        // Perform a depth-first search to calculate the maximum sum at each node
        dfs(adjList, values, dp, 0); // Start the DFS from the root node (node 0)
        
        return dp[0]; // The maximum sum at the root node represents the largest value sum in the tree
    }
    
    private static void dfs(List<List<Integer>> adjList, List<Integer> values, int[] dp, int node) {
        dp[node] = values.get(node); // Initialize the dp array with the value of the current node
        
        // Traverse all the child nodes of the current node
        for (int child : adjList.get(node)) {
            dfs(adjList, values, dp, child); // Recursively perform DFS on each child node
            
            // Update the maximum sum at the current node by considering the maximum sum
            // among its children and the value of the current node
            dp[node] = Math.max(dp[node], dp[child] + values.get(node));
        }
    }


}

