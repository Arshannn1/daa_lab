package daa;

import java.util.*;

 public class Krushkal {
	 
    static class Triplet_edge_implement {
        int u, v, weight;
        Triplet_edge_implement(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    static class DisjointSet {
        int[] parent;

        DisjointSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;						//Initialization:

//When you set parent[i] = i for each element, it means each node is its own parent initially.
//This indicates that each element is in its own separate set at the start, with each element acting as the "representative" or "root" of its set.
            }
        }

        int find(int u) {
            if (parent[u] == u)
                return u; 
            return find(parent[u]);
        }
        
        

        void union(int u, int v) {
            int rootU = find(u); 
            int rootV = find(v);
            if (rootU == rootV) {
            	return;
            }
            else
            {
            	parent[rootU] = rootV;
            }
        }
    }
    

    static int kruskal(int n, List< Triplet_edge_implement> edges) {
        // Use a lambda function to sort edges by weight
        edges.sort((edge1, edge2) -> Integer.compare(edge1.weight, edge2.weight));  // Sort by edge weight

        DisjointSet ds = new DisjointSet(n);
        int mstWeight = 0;

        for ( Triplet_edge_implement e : edges) {
            if (ds.find(e.u) != ds.find(e.v)) {
                ds.union(e.u, e.v);
                mstWeight += e.weight;
            }
        }

        return mstWeight;
    }

    public static void main(String[] args) {
        List< Triplet_edge_implement> edges = new ArrayList<>();
        edges.add(new  Triplet_edge_implement(0, 1, 10));
        edges.add(new  Triplet_edge_implement(0, 2, 6));
        edges.add(new  Triplet_edge_implement(0, 3, 5));
        edges.add(new  Triplet_edge_implement(1, 3, 15));
        edges.add(new  Triplet_edge_implement(2, 3, 4));

        int n = 4;  // Number of vertices
        int mstWeight = kruskal(n, edges);
        System.out.println("Minimum Spanning Tree Weight: " + mstWeight);
    }
    
 }
