package daa;

import java.util.*;

public class TopologicalSort {
	//List<String> deadEnds = new ArrayList<>();
    // Recursive method to perform DFS
    public static void dfsRecursive(Map<String, List<String>> graph, String node, Set<String> visited,List<String> deadEnds) {
        // If the node has already been visited, return
        if (visited.contains(node)) {
            return;
        }
        
       
        
        // Mark the current node as visited and process it
        visited.add(node);
        System.out.print(node + " ");

        // Recur for all the vertices adjacent to this vertex
        for (String neighbor : graph.get(node)) {
            dfsRecursive(graph, neighbor, visited,deadEnds);
        }
        
        deadEnds.add(node);
    }

    // Driver code
    public static void main(String[] args) {
        // Graph represented as an adjacency list
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("D"));
        graph.put("C", Arrays.asList("E"));
        graph.put("D", Arrays.asList("F"));
        graph.put("E", Arrays.asList("F"));
        graph.put("F", new ArrayList<>());  // No neighbors for F

        // Set to track visited nodes
        Set<String> visited = new HashSet<>();
        List<String> deadEnds = new ArrayList<>();

        // Perform DFS starting from node "A"
        System.out.println("DFS :");
        dfsRecursive(graph, "A", visited, deadEnds);
        Collections.reverse(deadEnds);
        System.out.println("\n topological : " + deadEnds);
    }
}
