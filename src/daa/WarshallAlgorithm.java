package daa;
public class WarshallAlgorithm {

    // Method to compute the transitive closure
    public static int[][] warshall(int[][] graph) {
        int n = graph.length; // Number of vertices
        int[][] reach = new int[n][n];

        // Initialize the reachability matrix as a copy of the graph
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                reach[i][j] = graph[i][j];
            }
        }

        // Warshall's algorithm to compute transitive closure
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // If i can reach k and k can reach j, then i can reach j
                    reach[i][j] = reach[i][j] | (reach[i][k] & reach[k][j]);
                }
            }
        }

        return reach;
    }

    public static void main(String[] args) {
        // Adjacency matrix representation of the graph
        int[][] graph = {
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 1, 0, 1},
            {0, 0, 0, 0}
        };

        int[][] transitiveClosure = warshall(graph);

        // Print the transitive closure
        System.out.println("Transitive Closure:");
        for (int[] row : transitiveClosure) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
