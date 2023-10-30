package DataStructures;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class AdjacencyListGraph {
    
    class Node {
        int data;
        Set<Node> neighbors;
    }

    /**
     * Iterative Depth First Search print of all nodes
     * 
     * @param start
     */
    public static void dfs(Node start) {
        Set<Node> visitedNodes = new HashSet<>();
        Stack<Node> stack = new Stack<>();

        stack.push(start);
        visitedNodes.add(start);

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();

            System.out.println(currentNode.data);

            for (Node neighbor : currentNode.neighbors) {
                if (!visitedNodes.contains(neighbor)) {
                    visitedNodes.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }
    }

    /**
     * Iterative Breath First Search print of all nodes
     * 
     * @param start
     */
    public static void bfs(Node start) {
        Set<Node> visitedNodes = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(start);
        visitedNodes.add(start);

        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();

            System.out.println(currentNode.data);

            for (Node neighbor : currentNode.neighbors) {
                if (!visitedNodes.contains(neighbor)) {
                    // we must mark a node as visited before 
                    // adding it to the queue to avoid duplicate
                    visitedNodes.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}
