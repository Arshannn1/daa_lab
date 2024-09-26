package daa;

import java.util.*;

public class bfs {
    // Function to perform BFS traversal from the given start node
    public static void bffs(Map<Integer, List<Integer>> graph, int startNode) {
        // Set to keep track of visited nodes
        Set<Integer> visited = new HashSet<>();
        // Queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        // Add the start node to the queue and mark it as visited
        queue.add(startNode);
        visited.add(startNode);

        // Perform BFS
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println("Visited node: " + node);

            // Check if the current node exists in the graph
            if (graph.containsKey(node)) {
                // Loop through the neighbors of the current node
                for (int neighbor : graph.get(node)) {
                    // If the neighbor hasn't been visited yet, add it to the queue
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example directed graph represented as an adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(2,999));
        graph.put(2, Arrays.asList(3));
        // Node 3 has no outgoing edges

        // Starting node for BFS
        int startNode = 0;

        // Perform BFS from the given starting node
        System.out.println("BFS starting from node " + startNode + ":");
        bffs(graph, startNode);
    }
}

