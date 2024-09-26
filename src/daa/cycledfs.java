package daa;

class cycledfs {
    // Function to perform DFS and check for cycles
    private static boolean dfs(int node, int[][] adj, boolean[] visited, boolean[] recStack) {
        // Mark the current node as visited and part of the recursion stack
        visited[node] = true;
        recStack[node] = true;

        // Recur for all adjacent nodes
        for (int i = 0; i < adj.length; i++) {
            if (adj[node][i] == 1) { // Check if there's an edge from node to i
                // If the node is not visited, recurse on it
                if (!visited[i] && dfs(i, adj, visited, recStack)) {
                    return true;
                } 
                // If the node is in the recursion stack, a cycle is found
                else if (recStack[i]) {
                    return true;
                }
            }
        }

        // Remove the node from the recursion stack
        recStack[node] = false;
        return false;
    }

    // Function to detect cycle in a directed graph using an adjacency matrix
    public static boolean isCyclic(int[][] adj) {
        boolean[] visited = new boolean[adj.length];
        boolean[] recStack = new boolean[adj.length];

        // Check each node
        for (int i = 0; i < adj.length; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, recStack)) {
                    return true; // Cycle found
                }
            }
        }
        return false; // No cycle found
    }

    public static void main(String[] args) {
        // Example adjacency matrix for the graph
        int[][] adj = {
            {0, 1, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {1, 0, 0, 0}  // Cycle exists: 0 -> 1 -> 2 -> 3 -> 0
        };

        if (isCyclic(adj)) {
            System.out.println("Graph has a cycle");
        } else {
            System.out.println("Graph does not have a cycle");
        }
    }
}
