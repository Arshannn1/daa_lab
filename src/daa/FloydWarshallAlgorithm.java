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
                } else if (graph[i][j] != 'x') {
                    distance[i][j] = graph[i][j]; // Distance is the edge weight
                } else {
                    distance[i][j] = Integer.MAX_VALUE; // No edge, set to infinity
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
        int[][] graph = {
            {0, 9, -4, 'x'},
            {6, 0, 1, 2},
            {'x', 5, 0, 'x'},
            {'x', 'x', 1, 0}        //this x means not possible to reach as of now, u can keep zero there or inf
        };

        int[][] shortestPaths = floydWarshall(graph);

        // Print the shortest paths
        System.out.println("Shortest Paths:");
        for (int[] row : shortestPaths) {
            for (int value : row) {
                if (value == Integer.MAX_VALUE) {
                    System.out.print("x ");
                } else {
                    System.out.print(value + " ");
                }
            }
            System.out.println();
        }
    }
}
