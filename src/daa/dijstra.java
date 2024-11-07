package daa;


import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class dijstra {
    // Graph representation
    static Map<String, Map<String, Integer>> graph = new HashMap<>();
    
    
    
//    graph = {                    //python
//    	    "a": {"b": 5, "c": 2},
//    	    "b": {"d": 1, "e": 6},
//    	    "c": {"b": 8, "d": 7},
//    	    "d": {"e": 3, "f": 2},
//    	    "e": {"f": 1},
//    	    "f": {}
//    	}

    static {
        graph.put("a", new HashMap<>() {{ put("b", 5); put("c", 2); }});
        graph.put("b", new HashMap<>() {{ put("d", 1); put("e", 6); }});
        graph.put("c", new HashMap<>() {{ put("b", 8); put("d", 7); }});     
        graph.put("d", new HashMap<>() {{ put("e", 3); put("f", 2); }});
        graph.put("e", new HashMap<>() {{ put("f", 1); }});
        graph.put("f", new HashMap<>());
    }

    // Function to initialize costs and parents based on the chosen start node
    public static Map<String, Integer> initializeCosts(Map<String, Map<String, Integer>> graph, String start) {
        Map<String, Integer> costs = new HashMap<>();
        for (String node : graph.keySet()) {
            costs.put(node, Integer.MAX_VALUE);
        }
        costs.put(start, 0);
        return costs;
    }

    public static Map<String, String> initializeParents(Map<String, Map<String, Integer>> graph) {
        Map<String, String> parents = new HashMap<>();
        for (String node : graph.keySet()) {
            parents.put(node, null);
        }
        return parents;
    }

    // Function to find the lowest cost node
    public static String findLowestCostNode(Map<String, Integer> costs, ArrayList<String> processed) {
        int lowestCost = Integer.MAX_VALUE;
        String lowestCostNode = null;
        for (String node : costs.keySet()) {
            int cost = costs.get(node);
            if (cost < lowestCost && !processed.contains(node)) {
                lowestCost = cost;
                lowestCostNode = node;
            }
        }
        return lowestCostNode;
    }

    // Dijkstra's algorithm to find shortest paths from the chosen start node
    public static Map<String, Integer> dijkstra(Map<String, Map<String, Integer>> graph, String start) {
        Map<String, Integer> costs = initializeCosts(graph, start);
        Map<String, String> parents = initializeParents(graph);
        ArrayList<String> processed = new ArrayList<>();

        String node = findLowestCostNode(costs, processed);
        while (node != null) {
            int cost = costs.get(node);
          //  Map<String, Integer> neighbors = graph.get(node);
            for (String n :graph.get(node).keySet()) {
                int newCost = cost + graph.get(node).get(n);
                if (newCost < costs.get(n)) {
                    costs.put(n, newCost);
                    parents.put(n, node);
                }
            }
            processed.add(node);
            node = findLowestCostNode(costs, processed);
        }

        return costs;
    }

    public static void main(String[] args) {
        // Choose a start node
        String start = "a";  // Replace "a" with any node to start from

        // Run Dijkstra's algorithm
        Map<String, Integer> costs = dijkstra(graph, start);
      
        // Output the shortest paths and costs from the chosen start node
        System.out.println("Costs: " + costs);
        // System.out.println("Parents: " + parents);
    }
}




// import java.util.ArrayList;
// import java.util.Arrays;

// public class DijkstraAlgorithmMatrix {
//     // Adjacency matrix representation of the graph
//     static int[][] graph = {
//             {0, 5, 2, 0, 0, 0},
//             {0, 0, 0, 1, 6, 0},
//             {0, 8, 0, 7, 0, 0},
//             {0, 0, 0, 0, 3, 2},
//             {0, 0, 0, 0, 0, 1},
//             {0, 0, 0, 0, 0, 0}
//     };

//     // Initialize costs based on the start node
//     public static int[] initializeCosts(int numNodes, int start) {
//         int[] costs = new int[numNodes];
//         Arrays.fill(costs, Integer.MAX_VALUE);
//         costs[start] = 0;
//         return costs;
//     }

//     // Initialize parents array
//     public static int[] initializeParents(int numNodes) {
//         int[] parents = new int[numNodes];
//         Arrays.fill(parents, -1); // -1 indicates no parent
//         return parents;
//     }

//     // Find the node with the lowest cost that hasn't been processed
//     public static int findLowestCostNode(int[] costs, boolean[] processed) {
//         int lowestCost = Integer.MAX_VALUE;
//         int lowestCostNode = -1;
//         for (int i = 0; i < costs.length; i++) {
//             if (!processed[i] && costs[i] < lowestCost) {
//                 lowestCost = costs[i];
//                 lowestCostNode = i;
//             }
//         }
//         return lowestCostNode;
//     }

//     // Dijkstra's algorithm to find shortest paths from the start node
//     public static int[] dijkstra(int[][] graph, int start) {
//         int numNodes = graph.length;
//         int[] costs = initializeCosts(numNodes, start);
//         int[] parents = initializeParents(numNodes);
//         boolean[] processed = new boolean[numNodes];

//         int node = findLowestCostNode(costs, processed);
//         while (node != -1) {
//             int cost = costs[node];
//             for (int neighbor = 0; neighbor < numNodes; neighbor++) {
//                 int edgeCost = graph[node][neighbor];
//                 if (edgeCost > 0) {  // Only consider existing edges
//                     int newCost = cost + edgeCost;
//                     if (newCost < costs[neighbor]) {
//                         costs[neighbor] = newCost;
//                         parents[neighbor] = node;
//                     }
//                 }
//             }
//             processed[node] = true;
//             node = findLowestCostNode(costs, processed);
//         }

//         // Output the shortest path tree using parents array
//         System.out.println("Parents: " + Arrays.toString(parents));

//         return costs;
//     }

//     public static void main(String[] args) {
//         // Choose a start node (index-based)
//         int start = 0;  // Replace 0 with any starting index as per your matrix

//         // Run Dijkstra's algorithm
//         int[] costs = dijkstra(graph, start);

//         // Output the shortest paths and costs from the chosen start node
//         System.out.println("Costs: " + Arrays.toString(costs));
//     }
// }


