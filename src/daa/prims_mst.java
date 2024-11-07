package daa;



public class prims_mst {
	    public static void main(String[] args) {
	        int V = 5; // Number of vertices

	        int[][] graph = {
	            {0, 2, 0, 6, 0},
	            {2, 0, 3, 8, 5},
	            {0, 3, 0, 0, 7},
	            {6, 8, 0, 0, 9},
	            {0, 5, 7, 9, 0}
	            
	          
	        };

    // Arrays to keep track of MST
	        boolean[] inMST = new boolean[V];
	        int[] minEdge = new int[V];
	        int[] parent = new int[V];

	        // Initialize min edges to infinity and parent to -1
	        for (int i = 0; i < V; i++) {
	            minEdge[i] = Integer.MAX_VALUE;    //min edge is ioncomimg edge
	            parent[i] = -1;
	        }
	        minEdge[0] = 0; // Start with the first vertex

	        
//	        
//	        // Loop to find V-1 edges for MST
	        for (int count = 0; count < V - 1; count++) {
	            int min = Integer.MAX_VALUE;
	            int u = -1;

	            // Find the vertex with the minimum edge that isn't in the MST
	            for (int v = 0; v < V; v++) {
	                if (!inMST[v] && minEdge[v] < min) {
	                    min = minEdge[v];
	                    u = v;
	                }
	            }

            inMST[u] = true; // Include this vertex in MST

	            // Update the edges of the adjacent vertices
	            for (int v = 0; v < V; v++) {
	                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < minEdge[v]) {
	                    minEdge[v] = graph[u][v];
	                    parent[v] = u;
	                }
	            }
	        }

//	        // Print the edges in the MST
	        System.out.println("Edges in the Minimum Spanning Tree:");
	        int totalWeight = 0;
	        for (int i = 1; i < V; i++) {
	            System.out.println("Edge: " + parent[i] + " - " + i + " Weight: " + graph[parent[i]][i]);
	            totalWeight += graph[parent[i]][i];
	        }

	        System.out.println("Total weight of MST: " + totalWeight);
	    }
	}


//
//public class prims_mst {
//    public static void main(String args[]) {
//        int[][] graph = {
//            {0, 2, 0, 6, 0},
//            {2, 0, 3, 8, 5},
//            {0, 3, 0, 0, 7},
//            {6, 8, 0, 0, 9},
//            {0, 5, 7, 9, 0}
//        };
//
//        int[] visited = new int[5]; // Array size corrected to 5
//        int min = 999, u = 0, v = 0, total = 0;
//
//        // Initialize visited array and set 0s in graph to 999 for convenience
//        for (int i = 0; i < 5; i++) {
//            visited[i] = 0;
//            for (int j = 0; j < 5; j++) { // Inner loop range corrected to 5
//                if (graph[i][j] == 0) {
//                    graph[i][j] = 999;
//                }g
//            }
//        }
//
//        visited[0] = 1; // Start from the first vertex
//        for (int counter = 0; counter < 4; counter++) {
//            min = 999;
//            for (int i = 0; i < 5; i++) {
//                if (visited[i] == 1) {
//                    for (int j = 0; j < 5; j++) {
//                        if (visited[j] == 0 ) {
//                        	if (graph[i][j] <  min ) {
//                        
//                            min = graph[i][j];
//                            u = i;
//                            v = j;
//                        }
//                        }
//                    }
//                }
//            }
//            visited[v] = 1;
//            total += min;
//            System.out.println("source " + u + " -----> " + v + ": " + min);
//        }
//        System.out.println("Total cost of MST: " + total);
//    }
//}
