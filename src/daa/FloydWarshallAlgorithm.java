package daa;

public class FloydWarshallAlgorithm {

    // Method to compute the shortest paths between all pairs of vertices
    public static int[][] floydWarshall(int[][] graph) {
        int n = graph.length; // Number of vertices
        int[][] distance = new int[n][n];

        // Initialize the distance matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    distance[i][j] = 0; // Distance to self is 0
                } else {
                    distance[i][j] = graph[i][j]; // Distance is the edge weight
                }
            }
        }

        // Floyd-Warshall algorithm to compute shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // If the path through vertex k is shorter, update the distance
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE) {
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    }
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        // Adjacency matrix representation of the graph with edge weights
        // Integer.MAX_VALUE represents no direct edge between nodes
        int[][] graph = {
            {0, 9, -4, Integer.MAX_VALUE},
            {6, 0, 1, 2},
            {Integer.MAX_VALUE, 5, 0, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 1, 0}
        };

        int[][] shortestPaths = floydWarshall(graph);

        // Print the shortest paths
        System.out.println("Shortest Paths:");
        for (int[] row : shortestPaths) {
            for (int value : row) {
                if (value == Integer.MAX_VALUE) {
                    System.out.print("INF "); // Represent infinity for no connection
                } else {
                    System.out.print(value + " ");
                }
            }
            System.out.println();
        }
    }
}
